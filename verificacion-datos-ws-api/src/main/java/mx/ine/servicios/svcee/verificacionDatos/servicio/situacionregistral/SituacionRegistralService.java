/**
 * SituacionRegistralService.java
 * Fecha de creaci�n: 16/07/2015, 17:53:46
 *
 * Copyright (c) 2015 Instituto Nacional Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
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
     * Se genera la respuesta de la situaci�n registral del ciudadano para una entidad externa en base a la comparaci�n
     * que se hace entre los datos de consulta y los datos de ciudadano que se encuentren en
     * estatus EN PADRON, EN LISTA NOMINAL, en BAJAS o BAJAS EXCLUIDAS.
     * @author Andres Lopez (andres.lopez@ine.mx)
     * @param datosConsulta Objeto con los datos de la petici�n
     * @param datosCiudadano objeto con los datos del ciudadano
     * @return respuesta corta (VIGENTE, NO VIGENTE) de la situaci�n registral para entidades externas 
     */
    public RespuestaSituacionRegistralExterna generaRespuestaExterna(DatosComparacion  datosConsulta,DatosCiudadano datosCiudadano, RespuestaIntegrador respuesta);
}
