/**
 * MyUserPrincipal.java
 * Fecha de creaci�n: 29/04/2020
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
package mx.ine.servicios.svcee.verificacionDatos.sec;

import java.io.Serializable;
import java.util.List;

/**
 * Clase utilizada para cargar las credenciales de usuarios validos para hacer peticiones 
 *
 * @author andres.lopez@ine.mx
 * @since 2020
 *
 */

public class User implements Serializable  {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * nombre de usuario
	 */
    private String username;
    /**
     *
     */
    private String pclav;
    
    /**
     * roles del usuario ejemplo: ROLE_ADMIN 
     */
    private List<String> roles;
    
    
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	public String getPclav() {
		return pclav;
	}

	public void setPClav(String cadena) {
		this.pclav = cadena;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	
    
    
 
}