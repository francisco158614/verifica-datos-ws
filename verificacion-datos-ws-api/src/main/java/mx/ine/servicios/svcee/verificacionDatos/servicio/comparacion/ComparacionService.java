/**
 * ComparacionService.java
 * Fecha de creación: 16/07/2015, 11:52:29
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.comparacion;

import java.util.Map;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosComparacion;

/**
 * Caso de uso generar respuesta de comparación
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface ComparacionService {
	
	
    
    
    /**
     * Genera la respuesta de comparacion para los datos de tipo biometrico y tipo texto del
     * ciudadano.
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param datosComparacion
     * @param datosCiudadano
     * @return respuestaComparacion
     * @throws Exception
     */
    public Map<String,Boolean> generaRespuesta(DatosComparacion datosComparacion,DatosCiudadano datosCiudadano)throws Exception;
    
    
}
