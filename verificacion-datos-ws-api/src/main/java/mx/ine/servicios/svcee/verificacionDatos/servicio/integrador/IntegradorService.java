/**
 * IntegradorService.java
 * Fecha de creación: 16/07/2015, 11:13:30
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.integrador;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;

/**
 * Servicio que integra datos de consulta, realiza búsqueda y envía respuesta de situación
 * resgistral y/o de comparación de datos (CU-Integrar Servicios)
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @author andres-lopez (andres.lopez) mantenimiento 2017
 * @version 6.5
 * @since SIIRFE 6.1
 */
public interface IntegradorService {
	

	/**
	 *  Regresa la respuesta de situación resgistral y/o de comparación de datos del CU-Integrar Servicios
	 *  @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
	 *  @author Andres Lopez (andres.lopez@ine.mx) cambios en 2016 para entidades externas
	 *  @param datosEntrada Objeto con los parametros de entrada
	 *  @return RespuestaIntegrador respuesta que intrega la respuesta de situación registral y comparación
	 */
    public RespuestaIntegrador realizaConsulta(DatosEntrada datosEntrada);
}
