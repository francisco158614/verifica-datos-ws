/**
 * MyUserDetailsService.java
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
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 
 * Clase que sobre escribe la funcionalidad de UserDetails para cargar usuarios de JNDI o de base
 * de datos para el autenticathion manager de spring
 * @author andres.lopez@ine.mx
 * @since 2020
 *
 */
@SuppressWarnings("deprecation")
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);
	/**
	 * Cadena con el nombre de usuario, pwd Y rol ; separados por coma
	 */
	@Autowired
	@Qualifier("userJNDI")
	private String userJndi;
	
	@Autowired
	@Qualifier("passJNDI")
	private String passJndi;
	
	private String pclavEncode;
	
	private static final String ROLE="ROLE_ADMIN";
	
	@PostConstruct
	private void encodePassw() {
		pclavEncode=NoOpPasswordEncoder.getInstance().encode(passJndi);
	}
	
	/**
	 * Método que sobre escribe la funcionalidad de cargar las credenciales de un usuario.	
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		User user =findByUserName(username);
		if (user == null) {
			LOGGER.error("no se encontro el usuario:"+username);
			throw new UsernameNotFoundException(username);
		}else {		
			return new MyUserPrincipal(user);

		}

	}
	/**
	 * verifica que el nombre de usuario coincida con el nombre configurado en el JNDI,
	 * si coincide carga las credenciales de dicho usuario. en otro caso regresa null.
	 * @param username nombre de usuario
	 * @return usuario con las credenciales de seguridad, en caso de no coincidir dicho usuario regresa null.
	 */
	private User findByUserName(String username) {
		if(StringUtils.hasText(username) && username.equals(userJndi)) {			
			User usuer=new User();
			List<String> roles=new ArrayList<String>();
			usuer.setUsername(userJndi);
			usuer.setPClav(pclavEncode);
			roles.add(ROLE);
			usuer.setRoles(roles);
			return usuer;
		}
		
		return null;	
	}
}
