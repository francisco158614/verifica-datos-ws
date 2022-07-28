package mx.ine.servicios.svcee.verificacionDatos.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;

/**
 * Handles requests for the application home page.
 */
@Controller
public class InicioController {
	/**
	 * Logger de la clase
	 */
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(InicioController.class);
 

    /** home */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {        
        return "inicio";
    }
    
    
 
    @RequestMapping(value = "/error/400", method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml", "text/html"  })
    @ResponseBody
    public RespuestaIntegrador errorHTTP400(HttpServletResponse response) {
    	 RespuestaIntegrador repuesta   =  new RespuestaIntegrador();
	     repuesta.setDescripcion("Parametros de entrada sintacticamente incorrectos");
	     response.addHeader("Content-Security-Policy", "default-src 'self'");
         return repuesta;
    }
    
    
    @RequestMapping(value = "/error/401",  method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml","text/html"  })
    @ResponseBody
    public RespuestaIntegrador errorHTTP401() {
    	 RespuestaIntegrador errorHTTP401   =  new RespuestaIntegrador();
	     errorHTTP401.setDescripcion("No autorizado o credenciales incorrectas");
         return errorHTTP401;
    }
    
    
    @RequestMapping(value = "/error/404",  method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml","text/html"  })
    @ResponseBody
    public RespuestaIntegrador errorHTTP404() {
    	 RespuestaIntegrador errorHTTP404   =  new RespuestaIntegrador();
	     errorHTTP404.setDescripcion("Recurso no encontrado");
         return errorHTTP404;
    }
    @RequestMapping(value = "/error/405",  method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml","text/html"})
    @ResponseBody
    public RespuestaIntegrador errorHTTP405() {
    	 RespuestaIntegrador errorHTTP405   =  new RespuestaIntegrador();
	     errorHTTP405.setDescripcion("Metodo no soportado");
         return errorHTTP405;
    }
    
    @RequestMapping(value = "/error/415",  method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml","text/html" })
    @ResponseBody
    public RespuestaIntegrador errorHTTP415() {
    	 RespuestaIntegrador errorHTTP415   =  new RespuestaIntegrador();
	     errorHTTP415.setDescripcion("Medio no soportado");
         return errorHTTP415;
    }
    
    
    @RequestMapping(value = "/error/500",  method ={RequestMethod.GET, RequestMethod.POST}, produces = { "application/json" }, consumes = {
            "application/json", "application/xml" })
    @ResponseBody
    public RespuestaIntegrador errorHTTP500() {
    	 RespuestaIntegrador errorHTTP500   =  new RespuestaIntegrador();
	     errorHTTP500.setDescripcion("Error en tiempo de ejecucion");
         return errorHTTP500;
    }

}
