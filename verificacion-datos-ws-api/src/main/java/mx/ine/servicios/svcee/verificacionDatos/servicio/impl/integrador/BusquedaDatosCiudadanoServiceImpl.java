/**
 * BusquedaDatosCiudadanoServiceImpl.java
 *
 * Copyright (c) 2015 Instituto Nacional Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Nacional Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.servicios.svcee.verificacionDatos.servicio.impl.integrador;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.ine.servicios.svcee.modelos.datos.CodigoRespuesta;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosComparacion;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoBusqueda;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.BusquedaDatosCiudadanoService;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.BusquedaEstrategia;

/**
 * Realiza la busqueda de los datos del ciudadano/credencial
 * @author INE
 * @version 1.0
 * @since SIIRFE 5.1
 */
@Service("busquedaDatosCiudadanoService")
public class BusquedaDatosCiudadanoServiceImpl implements BusquedaDatosCiudadanoService {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaDatosCiudadanoServiceImpl.class);

	@Resource(name = "busquedaCicEstrategia")
	private BusquedaEstrategia busquedaCicEstrategia;
	//	@Resource(name = "busquedaCurpEstrategia")
	//	private BusquedaEstrategia busquedaCurpEstrategia;
	@Resource(name = "busquedaClaveElectorEstrategia")
	private BusquedaEstrategia busquedaClaveElectorEstrategia;
	@Resource(name = "busquedaReporteRoboExtravioEstrategia")
	private BusquedaEstrategia busquedaReporteRoboExtravioEstrategia;

	/**
	 * Realiza la busqueda de los datos del ciudadano/credencial utilizando la informacion contenida en los datos de entrada
	 * @param datosEntrada
	 * @return lista de registros encontrados
	 */
	@Override
	public List<DatosCiudadano> buscaCiudadano(DatosEntrada datosEntrada,RespuestaIntegrador respuesta)throws Exception {
		List<DatosCiudadano> ciudadanos=null;
		TipoBusqueda tipoBusqueda = null;
		BusquedaEstrategia busquedaEstrategia = null;

		tipoBusqueda = obtenTipoBusqueda(datosEntrada,respuesta);
		if(tipoBusqueda!=null){
			respuesta.setServicioSolicitado(tipoBusqueda.getNombre());
			busquedaEstrategia = obtenEstrategiaBusqueda(tipoBusqueda,respuesta,datosEntrada);
			if(busquedaEstrategia!=null){
				if(busquedaEstrategia.valida(datosEntrada)) {
					Instant inicio=Instant.now();
					ciudadanos=busquedaEstrategia.busca(datosEntrada);
					Instant fin=Instant.now();		
					respuesta.setTiempoBusqueda(inicio.until(fin, ChronoUnit.MILLIS));
				}else {
					LOGGER.error("[VERIFICA-DATOS-WS-ERROR]DATOS_BUSQEDA_INVALIDOS:" + datosEntrada.getIndice());
					respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_DATOS_BUSQEDA_INVALIDOS.getId());
				}
			}
		}
		return ciudadanos;
	}
	/**
	 * Segun los datos de entrada definimos si la busqueda será por CURP, CIC, clave de
	 * elector o Reporte de Robo-Extravío
	 * @param datosEntrada
	 * @return TipoBusqueda
	 */
	private TipoBusqueda obtenTipoBusqueda(DatosEntrada datosEntrada,RespuestaIntegrador respuesta) {
		TipoBusqueda tipoBusqueda=null;

		if (datosEntrada.getTipoRespuestaSolicitada() == null) {
			respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_TIPO_RESPUESTA_SOLICITADA_INVALIDA.getId());
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]TIPO_RESPUESTA_SOLICITADA_INVALIDA:"+datosEntrada.getIndice());
		}else{
			switch (datosEntrada.getTipoRespuestaSolicitada()) {					
			case COMPARACION:
			case AMBAS:
			case CONSULTA_EXTERNA:	
				tipoBusqueda=obtenTipoBusquedaComparacion(datosEntrada,respuesta);
				break;
			default:						
				respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_TIPO_RESPUESTA_SOLICITADA_INVALIDA.getId());
				LOGGER.error("[VERIFICA-DATOS-WS-ERROR]TIPO_RESPUESTA_SOLICITADA_INVALIDA:"+datosEntrada.getIndice());
				break;
			}
		}


		return tipoBusqueda;

	}

	/**
	 * Obtiene el tipo de busqueda a partir de los datos de comparacion
	 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
	 * @param datosEntrada
	 * @return TipoBusqueda
	 */
	private TipoBusqueda obtenTipoBusquedaComparacion(DatosEntrada datosEntrada,RespuestaIntegrador respuesta) {
		TipoBusqueda tipoBusqueda=null;
		DatosComparacion datosComparacion = datosEntrada.getDatosComparacion();
		if (datosComparacion == null) {
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]obtenTipoBusquedaComparacion,Datos de comparacion nulos:"+datosEntrada.getIndice());
			respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_DATOS_BUSQEDA_INVALIDOS.getId());
		}else{
			//		if (StringUtils.hasText(datosComparacion.getCurp())) {
			//			return TipoBusqueda.CURP;
			//		}
			if (StringUtils.hasText(datosComparacion.getCic())) {
				tipoBusqueda=TipoBusqueda.CIC;
			}
			else if (StringUtils.hasText(datosComparacion.getClaveElector())) {
				tipoBusqueda=TipoBusqueda.CLAVE_ELECTOR;
			}else{
				respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_DATOS_BUSQEDA_INVALIDOS.getId());
				LOGGER.error("[VERIFICA-DATOS-WS-ERROR]obtenTipoBusquedaComparacion,Datos incompletos para busqueda por datos de comparacion:"+datosEntrada.getIndice());
			}
		}
		return tipoBusqueda;
	}
	
	/**
	 * Regresamos la estrategia de busqueda a utilizar
	 * @param tipoBusqueda
	 * @return BusquedaEstrategia
	 */
	private BusquedaEstrategia obtenEstrategiaBusqueda(TipoBusqueda tipoBusqueda,RespuestaIntegrador respuesta,DatosEntrada datosEntrada) {
		BusquedaEstrategia busquedaEstrategia=null;

		//		if (tipoBusqueda.equals(TipoBusqueda.CURP)) {
		//			return busquedaCurpEstrategia;
		//		}

		if (tipoBusqueda.equals(TipoBusqueda.CIC)) {
			busquedaEstrategia= busquedaCicEstrategia;
		}
		else if (tipoBusqueda.equals(TipoBusqueda.CLAVE_ELECTOR)) {
			busquedaEstrategia= busquedaClaveElectorEstrategia;
		}
		else if (tipoBusqueda.equals(TipoBusqueda.REPORTEROBOEXTRAVIO_ID)) {
			busquedaEstrategia= busquedaReporteRoboExtravioEstrategia;
		}else{
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]obtenEstrategiaBusqueda,No se puede obtener la estrategia de busqueda para un tipo de busqueda invalida : "+datosEntrada.getIndice());
			respuesta.setCodigoRespuestaDatos(CodigoRespuesta.ERROR_DATOS_BUSQEDA_INVALIDOS.getId());
		}
		return busquedaEstrategia;
	}
}
