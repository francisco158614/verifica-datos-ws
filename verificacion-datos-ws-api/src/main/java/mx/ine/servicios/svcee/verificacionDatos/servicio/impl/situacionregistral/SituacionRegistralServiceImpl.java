/**
 * SituacionRegistralServiceImpl.java
 * Fecha de creación: 17/07/2015, 16:02:38
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.impl.situacionregistral;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosComparacion;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaSituacionRegistralExterna;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoBajaPadron;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoBusqueda;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoCausaRoboExtravio;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoEstatusCiudadano;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoEstatusRoboExtravio;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoRespuestaSituacionRegistral;
import mx.ine.servicios.svcee.verificacionDatos.servicio.situacionregistral.SituacionRegistralService;
import mx.ine.servicios.svcee.verificacionDatos.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Caso de uso Genera respuesta de situacion registral
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @author andres-lopez (andres.lopez@ine.mx) se actualiza para generar respuesta a entidades externas. 2017
 * @version 6.5
 * @since SIIRFE 6.1
 */
@Service("situacionRegistralService")
public class SituacionRegistralServiceImpl implements SituacionRegistralService {
	/**
	 * Logger de la clase
	 */

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(SituacionRegistralServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * @see mx.ine.serviciosconsulta.servicios.entidadesexternas.servicio.situacionregistral.SituacionRegistralService#generaRespuestaExterna(mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.bean.DatosComparacion, mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.entidad.DatosCiudadano)
	 */
	@Override
	public RespuestaSituacionRegistralExterna generaRespuestaExterna(DatosComparacion  datosConsulta,DatosCiudadano datosCiudadano, RespuestaIntegrador respuestaIntegrador) {
		RespuestaSituacionRegistralExterna respuesta = new RespuestaSituacionRegistralExterna();
		TipoRespuestaSituacionRegistral tipoRespuestaSituacionRegistral = null;
		if(datosCiudadano!=null && Boolean.FALSE.equals(datosCiudadano.getEstatusArco())){			
			// es vigente
			if (datosCiudadano.getTipoEstatusCiudadano().equals(TipoEstatusCiudadano.LISTA_NOMINAL)) {			
				tipoRespuestaSituacionRegistral=TipoRespuestaSituacionRegistral.VIGENTE;
				
			//bajas	
			}else if(datosCiudadano.getTipoEstatusCiudadano().equals(TipoEstatusCiudadano.BAJAS)){
				tipoRespuestaSituacionRegistral=tipoBajaPadron(datosCiudadano);
			}
			//en otro caso es no_vigente
			else{
				tipoRespuestaSituacionRegistral=TipoRespuestaSituacionRegistral.NO_VIGENTE;

			}
			//validar si es la ultima credencial
			if(tipoRespuestaSituacionRegistral.equals(TipoRespuestaSituacionRegistral.VIGENTE)) {
				//validar si es la ultima credencial
				if(TipoBusqueda.CIC.getNombre().equals(respuestaIntegrador.getServicioSolicitado())){
					//si no es igual entonces se cambia a no vigente
					if(!datosConsulta.getCic().equals(datosCiudadano.getCic().toString())){
						tipoRespuestaSituacionRegistral=TipoRespuestaSituacionRegistral.NO_VIGENTE;
						datosCiudadano.setAuxCredencialAnt(true);
						respuestaIntegrador.setUltimaCredencial(false);
					}
				}else if(TipoBusqueda.CLAVE_ELECTOR.getNombre().equals(respuestaIntegrador.getServicioSolicitado())){
					if(!comparaKeyClaveElector(datosConsulta, datosCiudadano)){
						tipoRespuestaSituacionRegistral=TipoRespuestaSituacionRegistral.NO_VIGENTE;
						datosCiudadano.setAuxCredencialAnt(true);
						respuestaIntegrador.setUltimaCredencial(false);
					}   
				}
			}
			
			
			respuesta.setTipoSituacionRegistral(tipoRespuestaSituacionRegistral);

			/* En caso de que tenga un reporte de robo o extravio, se setea el valor */
			TipoRespuestaSituacionRegistral tipoRespuestaReporteRoboExtravio = obtieneReporteRoboOExtravioConsultaExterna(datosConsulta, datosCiudadano);
			respuesta.setTipoReporteRoboExtravio(tipoRespuestaReporteRoboExtravio);				
		}else{			
			respuesta.setTipoSituacionRegistral(TipoRespuestaSituacionRegistral.DATOS_NO_ENCONTRADOS);			
		}

		return respuesta;
	}

	/**
	 * Regresa el tipo de respuesta de la situación registral, de acuerdo al
	 * tipo de baja en el que se encuentre un ciudadano.
	 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
	 * @param tipoBajaPadron
	 * @return respuesta
	 */

	public TipoRespuestaSituacionRegistral tipoBajaPadron(DatosCiudadano datosCiudadano) {
		TipoBajaPadron tipoBajaPadron=datosCiudadano.getTipoBajaPadron();
		
		TipoRespuestaSituacionRegistral tipoRespuestaSituacionRegistral = null;
		switch (tipoBajaPadron) {
		
		case SUSPENSION:			
			if(datosCiudadano.getSuspensionDerechos()){
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.VIGENTE;
			}else{
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.NO_VIGENTE;
			}
			break;
		case SUSPENSION_POR_VALIDACION_EN_SVCS:
			if(datosCiudadano.getSuspensionDerechos()){
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.VIGENTE;
			}else{
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.NO_VIGENTE;
			}
			break;	
		case TRAMITE_CANCELADO_POR_SUSPENSION_DERECHOS:
			if(datosCiudadano.getSuspensionDerechos()){
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.VIGENTE;
			}else{
				tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.NO_VIGENTE;
			}	
			break;
		default:
			tipoRespuestaSituacionRegistral = TipoRespuestaSituacionRegistral.NO_VIGENTE;
			break;
		}
		return tipoRespuestaSituacionRegistral;
	}


	/**
	 * Regresa un tipo de respuseta de sitiación registral de reporte de robo o
	 * extravio para consulta externa
	 * @author Esther Flores Rodriguez (esther.fr03@gmail.com) 
	 * @author Andres Lopez (andres.lopez@ine.mx) mantenimiento 2017
	 * @param datosConsulta
	 * @param datosCiudadano
	 * @return respuesta
	 */
	private TipoRespuestaSituacionRegistral obtieneReporteRoboOExtravioConsultaExterna( DatosComparacion datosConsulta,DatosCiudadano datosCiudadano) {
		TipoRespuestaSituacionRegistral tipoReporteRoboOExtravio = null;
		if (datosCiudadano.getTipoCausaRoboExtravio() != null && datosCiudadano.getTipoEstatusRoboExtravio() != null) {
			TipoCausaRoboExtravio tipoCausa = datosCiudadano.getTipoCausaRoboExtravio();
			TipoEstatusRoboExtravio tipoEstatus = datosCiudadano.getTipoEstatusRoboExtravio();
			if (tipoCausa.equals(TipoCausaRoboExtravio.ROBO)) {
				if (tipoEstatus.equals(TipoEstatusRoboExtravio.PERMANENTE)) {					
					tipoReporteRoboOExtravio = TipoRespuestaSituacionRegistral.REPORTE_DE_ROBO;			
					datosCiudadano.setAuxConReporteRoboExtr(true);
				} else if (tipoEstatus.equals(TipoEstatusRoboExtravio.TEMPORAL))  {					
					tipoReporteRoboOExtravio = TipoRespuestaSituacionRegistral.REPORTE_DE_ROBO_TEMPORAL;					                	
				}

			}
			else if (tipoCausa.equals(TipoCausaRoboExtravio.EXTRAVIO)) {
				if (tipoEstatus.equals(TipoEstatusRoboExtravio.PERMANENTE)) {
					tipoReporteRoboOExtravio = TipoRespuestaSituacionRegistral.REPORTE_DE_EXTRAVIO;
					datosCiudadano.setAuxConReporteRoboExtr(true);
				}else if (tipoEstatus.equals(TipoEstatusRoboExtravio.TEMPORAL)) {
					tipoReporteRoboOExtravio = TipoRespuestaSituacionRegistral.REPORTE_DE_EXTRAVIO_TEMPORAL;
				}
			}
		}
		return tipoReporteRoboOExtravio;
	}
	
	/**
	 * compara que la llave conformada por clave elector+ ocr +num emisión correspondan con la ultima credencial del
	 * ciudadano
	 * @param datosComparacion objeto con los datos de consulta.
	 * @param datosCiudadano datos obtenidos de la fuente de datos del padrón.
	 * @return <code>true</code> en caso de que seán todos los campos identicos.
	 */
	private boolean comparaKeyClaveElector(DatosComparacion datosComparacion, DatosCiudadano datosCiudadano){
		boolean bClave=Utils.comparaString(datosComparacion.getClaveElector(), datosCiudadano.getClaveElector());
		boolean bOcr=Utils.comparaString(datosComparacion.getOcr(), datosCiudadano.getOcr());
		boolean bNumEmision=Utils.comparaInteger(datosComparacion.getNumeroEmisionCredencial(),datosCiudadano.getNumeroEmisionCredencial());
		return (bClave&&bOcr&&bNumEmision);
	}


}
