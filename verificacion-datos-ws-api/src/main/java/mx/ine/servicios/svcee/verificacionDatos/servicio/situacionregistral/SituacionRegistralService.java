/**
 * SituacionRegistralService.java
 * Fecha de creación: 16/07/2015, 17:53:46
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.situacionregistral;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosComparacion;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaSituacionRegistralExterna;

/**
 * Caso de uso Genera respuesta de situacion registral
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @author Andres Lopez (andres.lopez@ine.mx) 2016 se realiaron cambios para entidades externas
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface SituacionRegistralService {
    
    /**
     * Se genera la respuesta de la situación registral del ciudadano para una entidad externa en base a la comparación
     * que se hace entre los datos de consulta y los datos de ciudadano que se encuentren en
     * estatus EN PADRON, EN LISTA NOMINAL, en BAJAS o BAJAS EXCLUIDAS.
     * @author Andres Lopez (andres.lopez@ine.mx)
     * @param datosConsulta Objeto con los datos de la petición
     * @param datosCiudadano objeto con los datos del ciudadano
     * @return respuesta corta (VIGENTE, NO VIGENTE) de la situación registral para entidades externas 
     */
    public RespuestaSituacionRegistralExterna generaRespuestaExterna(DatosComparacion  datosConsulta,DatosCiudadano datosCiudadano, RespuestaIntegrador respuesta);
}
