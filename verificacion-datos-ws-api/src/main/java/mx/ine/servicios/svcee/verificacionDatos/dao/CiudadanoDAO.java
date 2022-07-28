/**
 * DatosCiudadanoDAO.java
 * Fecha de creaci�n: 07/08/2015, 17:14:00
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
package mx.ine.servicios.svcee.verificacionDatos.dao;

import java.util.List;

import mx.ine.servicios.svcee.modelos.datos.bean.Credencial;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;

/**
 * Interfaz de acceso a datos para datos del ciudadano
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface CiudadanoDAO {
    

	
	/**
	 * @author Andres Lopez (andres.lopez@ine.mx)
	 * @param identificador unico del ciudadano
	 * @return 
	 * @throws Exception
	 */
	public DatosCiudadano busca(Long idCiudadano)throws Exception;
	
	
	
}
