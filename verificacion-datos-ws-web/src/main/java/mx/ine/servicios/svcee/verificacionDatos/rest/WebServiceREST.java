/**
 * RestService.java
 * Fecha de creaci�n: 20/08/2015, 14:54:00
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.servicios.svcee.verificacionDatos.rest;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.IntegradorService;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Servicio REST para consultar el estado de la credencial para entidades externas
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Controller
@RequestMapping("/SVCEE")
public class WebServiceREST implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 51370301133910538L;

	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceREST.class);

	/**
	 * Servicio que obtiene los datos
	 */
	@Resource
	private IntegradorService integradorService;
	/**
	 * Mapper de la clase
	 */
	private ObjectMapper myMapper;
	
	/**
	 * Constructor por defecto
	 */
	public WebServiceREST() {
		this.myMapper = getMapper1();
	}

	/**
	 * Configuracion basica del mapper
	 * @return
	 */
	public static ObjectMapper getMapper1() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,true);
		mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE,true);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper;
	}
	
	/**
	 * regresa la respuesta de situaci�n resgistral y/o de comparaci�n de datos del CU-Integrar Servicios
	 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
	 * @param datosEntrada
	 * @return respuestaIntegrador
	 */
	@RequestMapping(value="/consulta",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<String> consultaEntidadesExternas(@RequestBody String entrada,HttpServletResponse response) {
		DatosEntrada datosEntrada = null;
		long inicio = new Date().getTime();
		long fin;
		RespuestaIntegrador respuesta=new RespuestaIntegrador();
		ResponseEntity<String> wrapper1;
		String salida = "";
		
		if(entrada != null && !entrada.isEmpty()) {
			try {
				datosEntrada = this.myMapper.readValue(entrada,DatosEntrada.class);
			}
			catch(Exception e) {
				LOGGER.error("Error al parsear el objeto de entrada");
			}
		}
		
		respuesta = integradorService.realizaConsulta(datosEntrada);
		fin = new Date().getTime();
		respuesta.setTiempoServicio(fin - inicio);
		
		try {
			salida = this.myMapper.writeValueAsString(respuesta);
		}
		catch(Exception e) {
			LOGGER.error("Error al serializar");
		}
		response.setHeader("Content-Security-Policy", "default-src 'self'");
		wrapper1 = new ResponseEntity<String>(salida,HttpStatus.OK);
		return wrapper1;
	}
	@RequestMapping(value="/info",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getInfo(){
		return "funciona, v6.5.0.4.0";
	}
}
