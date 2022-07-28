/**
 * ComparacionServiceImpl.java
 * Fecha de creación: 27/07/2015, 17:43:32
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.impl;

import java.util.HashMap;
import java.util.Map;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosComparacion;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoCampo;
import mx.ine.servicios.svcee.verificacionDatos.servicio.comparacion.ComparacionService;
import mx.ine.servicios.svcee.verificacionDatos.util.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Caso de uso generar respuesta de comparación
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service("comparacionService")
public class ComparacionServiceImpl implements ComparacionService {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ComparacionServiceImpl.class);

	/**
	 * Genera la respuesta de comparacion para los datos de tipo biometrico y tipo texto del
	 * ciudadano.
	 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
	 * @param datosComparacion
	 * @param datosCiudadano
	 * @return respuestaComparacion
	 */
	@Override
	public Map<String,Boolean> generaRespuesta(DatosComparacion datosComparacion,DatosCiudadano datosCiudadano)throws Exception {
		try{

			return comparaCiudadano(datosComparacion, datosCiudadano);         
		}
		catch(Exception e){
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]generaRespuesta,"+datosComparacion.toString());
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]generaRespuesta,"+datosCiudadano.toString());
			LOGGER.error("[VERIFICA-DATOS-WS-ERROR]generaRespuesta,"+e.getMessage());
			throw e;
		}
	}

	/**
	 * se comparan cada uno de los datos de comparacion con los datos del
	 * ciudadano en caso de que sea igual la respuesta de comparacion será igual
	 * a 1 en caso contrario se asigna 0, en caso de que no se haya recibido el
	 * dato, la respuesta quedará igual a null, solo aplica para los datos de
	 * texto.
	 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
	 * @param datosComparacion
	 * @param datosCiudadano
	 * @return Map<String, Boolean>
	 */
	private Map<String, Boolean> comparaCiudadano(DatosComparacion datosComparacion,DatosCiudadano datosCiudadano) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put(TipoCampo.C_NOMBRE, null);
		result.put(TipoCampo.C_A_PATERNO, null);
		result.put(TipoCampo.C_A_MATERNO, null);
		result.put(TipoCampo.C_CURP, null);
		result.put(TipoCampo.C_CLAVE_ELECTOR, null);
		result.put(TipoCampo.C_OCR, null);
		
		result.put(TipoCampo.C_ANIO_REGISTRO, null);
		result.put(TipoCampo.C_ANIO_EMISION,null);		
		result.put(TipoCampo.C_EMISION, null);
		
		if (datosComparacion != null && datosCiudadano != null) {
			result.put(TipoCampo.C_NOMBRE,Utils.comparaString(datosComparacion.getNombre(), datosCiudadano.getNombre()));
			result.put(TipoCampo.C_A_PATERNO,Utils.comparaString(datosComparacion.getApellidoPaterno(),datosCiudadano.getApellidoPaterno()));
			result.put(TipoCampo.C_A_MATERNO,Utils.comparaString(datosComparacion.getApellidoMaterno(),datosCiudadano.getApellidoMaterno()));
			result.put(TipoCampo.C_CURP,Utils.comparaString(datosComparacion.getCurp(), datosCiudadano.getCurp()));
			result.put(TipoCampo.C_CLAVE_ELECTOR,Utils.comparaString(datosComparacion.getClaveElector(), datosCiudadano.getClaveElector()));
			result.put(TipoCampo.C_OCR,Utils.comparaString(datosComparacion.getOcr(), datosCiudadano.getOcr()));

			result.put(TipoCampo.C_ANIO_REGISTRO,Utils.comparaInteger(datosComparacion.getAnioRegistro(),Utils.obtieneAnio(datosCiudadano.getFechaInscripcionPadron())));
			result.put(TipoCampo.C_ANIO_EMISION,Utils.comparaInteger(datosComparacion.getAnioEmision(),Utils.obtieneAnio(datosCiudadano.getFechaCreacionCredencial())));
			result.put(TipoCampo.C_EMISION,Utils.comparaInteger(datosComparacion.getNumeroEmisionCredencial(),datosCiudadano.getNumeroEmisionCredencial()));

		}
		return result;
	}
}
