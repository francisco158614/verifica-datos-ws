/**


 * IntegradorServiceImpl.java
 * Fecha de creaciï¿½n: 16/07/2015, 17:21:36
 *
 * Copyright (c) 2015 Instituto Nacional Electoral. Direcciï¿½n
 * Ejecutiva del Registro Federal de Electores.
 * Perifï¿½rico Sur 239, Mï¿½xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaciï¿½n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaciï¿½n confidencial
 * no deberï¿½ ser divulgada y solo se podrï¿½ utilizar de acuerdo
 * a los tï¿½rminos que determine el propio Instituto.
 */
package mx.ine.servicios.svcee.verificacionDatos.servicio.impl.integrador;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import mx.ine.servicios.svcee.modelos.datos.CodigoRespuesta;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaSituacionRegistralExterna;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoRespuestaSituacionRegistral;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoRespuestaSolicitada;
import mx.ine.servicios.svcee.verificacionDatos.servicio.comparacion.ComparacionService;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.BusquedaDatosCiudadanoService;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.IntegradorService;
import mx.ine.servicios.svcee.verificacionDatos.servicio.situacionregistral.SituacionRegistralService;
import mx.ine.servicios.svcee.verificacionDatos.util.ConsultaException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Caso de uso Integrar Servicios
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @author andres-lopez (andres.lopez@ine.mx) Se realiza mantenimiento y control de cambios 2018
 * @version 6.5
 * @since SIIRFE 6.1
 */
@Service("integradorService")
public class IntegradorServiceImpl implements IntegradorService {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(IntegradorServiceImpl.class);

	@Resource
	private BusquedaDatosCiudadanoService busquedaDatosCiudadanoService;
	@Resource
	private SituacionRegistralService situacionRegistralService;
	@Resource
	private ComparacionService comparacionService;


	/*
	 * (non-Javadoc)
	 * @see mx.ine.serviciosconsulta.servicios.entidadesexternas.servicio.integrador.IntegradorService#realizaConsula(mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.bean.DatosEntrada)
	 */
	@Override
	public RespuestaIntegrador realizaConsulta(DatosEntrada datosEntrada) {
		RespuestaIntegrador respuestaIntegrador = new RespuestaIntegrador();
		Instant inicio=Instant.now();
		try {			
			RespuestaSituacionRegistralExterna respuestaSituacionRegistralExterna = null;
			Map<String,Boolean> respuestaComparacion =null;
			DatosCiudadano datosCiudadano = null;
			List<DatosCiudadano> ciudadanos=null;
			if (datosEntrada != null && StringUtils.hasText(datosEntrada.getIndice()) 
					&& datosEntrada.getDatosComparacion()!=null) {
				ciudadanos = busquedaDatosCiudadanoService.buscaCiudadano(datosEntrada,respuestaIntegrador);
				if(ciudadanos!=null){
					if (ciudadanos.size() == 1) {
						datosCiudadano = ciudadanos.get(0);	
						setValoresGenerales(datosCiudadano,respuestaIntegrador);
					}
					if(ejecutaServicioConsultaExterna(datosEntrada)){
						respuestaSituacionRegistralExterna=situacionRegistralService.generaRespuestaExterna(datosEntrada.getDatosComparacion(), datosCiudadano,respuestaIntegrador);

						if(ejecutaServicioComparacion(datosCiudadano, respuestaSituacionRegistralExterna)) {
							respuestaComparacion =comparacionService.generaRespuesta(datosEntrada.getDatosComparacion(),datosCiudadano);
							respuestaIntegrador.setCredencialActiva(true);
						}else {
							respuestaIntegrador.setCredencialActiva(false);
						}
					}
					/* Seteamos respuestas */			
					respuestaIntegrador.setRespuestaSituacionRegistral(respuestaSituacionRegistralExterna);
					respuestaIntegrador.setRespuestaComparacion(respuestaComparacion);
					respuestaIntegrador.setCodigoRespuestaDatos(CodigoRespuesta.OK.getId());
				}
			}else{				
				LOGGER.error("[VERIFICA-DATOS-WS-ERROR]Parametros de entrada nullos o incompletos,sin datos:");
				respuestaIntegrador.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_PARAMETROS_ENTRADA.getId());				
			}
		}catch (Exception e) {
			if(datosEntrada!=null && StringUtils.hasText(datosEntrada.getIndice())) {
				//cambios checkMarks Loggin Forging
				String indiceReguex=datosEntrada.getIndice().replace("\n", "\\n");
				LOGGER.error("[VERIFICA-DATOS-WS-ERROR]realizaConsulta:"+indiceReguex,e);
			}else {
				LOGGER.error("[VERIFICA-DATOS-WS-ERROR]realizaConsulta sin datos",e);
			}
			e = new ConsultaException(e);
			respuestaIntegrador.setDescripcion(e.getMessage());
			respuestaIntegrador.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_INESPERADO.getId());
		}
		Instant fin=Instant.now();		
		respuestaIntegrador.setTiempoDatos(inicio.until(fin, ChronoUnit.MILLIS));	 
		return respuestaIntegrador;
	}


	private void setValoresGenerales(DatosCiudadano datosCiudadano,RespuestaIntegrador respuestaIntegrador) {
		if(datosCiudadano!=null && Boolean.FALSE.equals(datosCiudadano.getEstatusArco())) {
			//set valores generales
			respuestaIntegrador.setCiudadanoId(datosCiudadano.getCiudadanoId().toString());
			respuestaIntegrador.setEstatusArco(datosCiudadano.getEstatusArco());
			if(datosCiudadano.getCredencialId()!=null) {
				respuestaIntegrador.setCredencialId(datosCiudadano.getCredencialId().toString());
			}
			respuestaIntegrador.setFotoId(datosCiudadano.getFotoId());
			respuestaIntegrador.setHuellaId(datosCiudadano.getHuellasId());
			//se asume que es la ultima credencial, despues se validara
			respuestaIntegrador.setUltimaCredencial(true);
		}else if(datosCiudadano!=null) {
			respuestaIntegrador.setCiudadanoId(datosCiudadano.getCiudadanoId().toString());
			respuestaIntegrador.setEstatusArco(datosCiudadano.getEstatusArco());			
			respuestaIntegrador.setFotoId(null);
			respuestaIntegrador.setHuellaId(null);
			respuestaIntegrador.setUltimaCredencial(null);
		}

	}



	/**
	 * Valida si se tiene que ejecutar el servicio de consulta para entidades externas(situacion registral)
	 * @author andres-lopez
	 * @param datosEntrada
	 * @return boolean
	 */
	private boolean ejecutaServicioConsultaExterna(DatosEntrada datosEntrada) {
		TipoRespuestaSolicitada tipoRespuestaSolicitada = datosEntrada.getTipoRespuestaSolicitada();
		if (tipoRespuestaSolicitada.equals(TipoRespuestaSolicitada.CONSULTA_EXTERNA)) {			
			return true;
		}
		return false;
	}
	/**
	 * Valida si se tiene que ejecutar el servicio de comparación.
	 * @param datosCiudadano
	 * @param respuestaSituacionRegistralExterna
	 * @return
	 */
	private boolean ejecutaServicioComparacion(DatosCiudadano datosCiudadano,RespuestaSituacionRegistralExterna respuestaSituacionRegistralExterna ) {
		if(datosCiudadano!=null
				&& !respuestaSituacionRegistralExterna.getTipoSituacionRegistral().equals(TipoRespuestaSituacionRegistral.DATOS_NO_ENCONTRADOS)
				&& datosCiudadano.getAuxCredencialAnt()==false 
				&& !datosCiudadano.isAuxConReporteRoboExtr()) {
			return true;
		}else {
			return false;

		}
	}



}
