/**
 * MyUserPrincipal.java
 * Fecha de creación: 29/04/2020
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
 */package mx.ine.servicios.svcee.verificacionDatos.sec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * Clase que encapsula las credenciales del usuario para el autenticathion manager de spring
 * @author andres.lopez@ine.mx
 * @since 2020
 *
 */
public class MyUserPrincipal implements UserDetails {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Usuario principal
	 */
	private User user;
	
	
    public MyUserPrincipal(User user) {
        this.user = user;
        
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		
		List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
		for(String rol:user.getRoles()) {
			updatedAuthorities.add(new SimpleGrantedAuthority(rol));		
		}
		return updatedAuthorities;
	}

	@Override
	public String getPassword() {
		return user.getPclav();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}