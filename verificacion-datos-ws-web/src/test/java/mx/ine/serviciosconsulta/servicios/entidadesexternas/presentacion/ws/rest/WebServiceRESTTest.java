package mx.ine.serviciosconsulta.servicios.entidadesexternas.presentacion.ws.rest;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;
import mx.ine.servicios.svcee.verificacionDatos.util.Utils;

public class WebServiceRESTTest implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9048358281821313664L;
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceRESTTest.class);

	@Test
	@Ignore
	public void probarMapper() {
		LOGGER.info("Prueba Mapper");
		ObjectMapper mapper = Utils.getMapper1();
		String entrada = "{\"DatosEntrada\":{\"serialCertificado\": \"f\",\"tipoRespuestaSolicitada\": \"CONSULTA_EXTERNA\",\"datosComparacion\": {\"claveElector\": \"JRMRRL91051009H600\",\"numeroEmisionCredencial\": 0,\"ocr\":\"0974199033363\",\"cic\":138250663,\"curp\": \"JUMR910510HDFRRL01\",\"nombre\": \"FRANCISCO\",\"apellidoPaterno\": \"ANDRES\",\"apellidoMaterno\": \"LOPEZ\",\"anioRegistro\": 2007,\"anioEmision\": 2014,\"numeroReporteRoboExtravio\":null},\"conAvisoPrivacidad\": true,\"indice\":\"cxz001\"}}";
		DatosEntrada datosEntarda = null;
		String salida = "";
		
		if(entrada != null && !entrada.isEmpty()) {
			try {
				datosEntarda = mapper.readValue(entrada,DatosEntrada.class);
				LOGGER.info("Deserializacion correcto");
				LOGGER.info(mapper.writeValueAsString(datosEntarda));
			}
			catch(Exception e) {
				LOGGER.error("Error al parsear:" + entrada);
			}
			try {
				RespuestaIntegrador respuestaintegrador = new RespuestaIntegrador();
				respuestaintegrador.setCodigoRespuestaDatos(0);
				salida = mapper.writeValueAsString(respuestaintegrador);
				LOGGER.info("Serializado correcto");
				LOGGER.info(salida);
			}
			catch(Exception e) {
				LOGGER.error("Error al serializar");
			}
		}
		LOGGER.info("FIN");
	}

}
