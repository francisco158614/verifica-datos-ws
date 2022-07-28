/**
 * DatosCiudadanoDAO.java
 * Fecha de creación: 07/08/2015, 17:14:00
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
public interface CredencialDAO {
    

	
	/**
	 * @author Andres Lopez (andres.lopez@ine.mx)
	 * @param filtro objeto con el cic
	 * @return 
	 * @throws Exception
	 */
	public List<Credencial> buscaPorCic(DatosCiudadano filtro)throws Exception;
	
	/**
	 * @author Andres Lopez (andres.lopez@ine.mx)
	 * @param filtro objeto con la clave de elector o el ocr o el número emisión o cualquier 
	 * conbinación.
	 * @return 
	 * @throws Exception
	 */
	
	public List<Credencial> buscaPorClave(DatosCiudadano filtro)throws Exception;
	
	
	/**
	 * @author Andres Lopez (andres.lopez@ine.mx)
	 * @param filtro objeto con numero de reporte de robo o extravío
	 * @return 
	 * @throws Exception
	 */
	
	public List<Credencial> buscaPorReporteRoboExtr( DatosCiudadano filtro)throws Exception;
	
	
	
}
