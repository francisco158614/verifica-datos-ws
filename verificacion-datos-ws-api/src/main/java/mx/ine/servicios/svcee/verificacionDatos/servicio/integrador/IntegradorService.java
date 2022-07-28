/**
 * IntegradorService.java
 * Fecha de creaci�n: 16/07/2015, 11:13:30
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.integrador;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;

/**
 * Servicio que integra datos de consulta, realiza b�squeda y env�a respuesta de situaci�n
 * resgistral y/o de comparaci�n de datos (CU-Integrar Servicios)
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @author andres-lopez (andres.lopez) mantenimiento 2017
 * @version 6.5
 * @since SIIRFE 6.1
 */
public interface IntegradorService {
	

	/**
	 *  Regresa la respuesta de situaci�n resgistral y/o de comparaci�n de datos del CU-Integrar Servicios
	 *  @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
	 *  @author Andres Lopez (andres.lopez@ine.mx) cambios en 2016 para entidades externas
	 *  @param datosEntrada Objeto con los parametros de entrada
	 *  @return RespuestaIntegrador respuesta que intrega la respuesta de situaci�n registral y comparaci�n
	 */
    public RespuestaIntegrador realizaConsulta(DatosEntrada datosEntrada);
}
