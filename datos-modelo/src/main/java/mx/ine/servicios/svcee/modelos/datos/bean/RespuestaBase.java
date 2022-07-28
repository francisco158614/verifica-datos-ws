/**
 * Fecha de creación: 2019
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
 * 
 */
package mx.ine.servicios.svcee.modelos.datos.bean;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * @author Andres Lopez (andres.lopez@ine.mx)
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "respuestaSituacionRegistral",
    "respuestaComparacion",
    "codigoRespuestaDatos"
})
@XmlRootElement(name = "RespuestaBase")
public class RespuestaBase implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3796072848305590345L;

	/**
	 * Respuesta resumida para entidades externas.
	 */
	private RespuestaSituacionRegistralExterna respuestaSituacionRegistral;

	/**
	 * Respuesta de la comparación de datos
	 */	
	private Map<String,Boolean> respuestaComparacion;
	
		
	/**
	 * Codigo de respuesta de la petición de datos
	 */
	private Integer codigoRespuestaDatos;  

	


	/**
	 * Obtiene el valor de la propiedad  {@link #respuestaSituacionRegistralExterna}
	 * @return the respuestaSituacionRegistralExterna
	 */
	public RespuestaSituacionRegistralExterna getRespuestaSituacionRegistral() {
		return respuestaSituacionRegistral;
	}

	/**
	 * Metodo para asignar el valor de {@link #respuestaSituacionRegistralExterna}
	 * @param respuestaSituacionRegistralExterna el valor de {@link #respuestaSituacionRegistralExterna}
	 */
	public void setRespuestaSituacionRegistral(
			RespuestaSituacionRegistralExterna respuestaSituacionRegistral) {
		this.respuestaSituacionRegistral = respuestaSituacionRegistral;
	}


	/**
	 * Obtiene el valor de la propiedad  {@link #respuestaComparacion}
	 * @return the respuestaComparacion
	 */
	public Map<String, Boolean> getRespuestaComparacion() {
		return respuestaComparacion;
	}

	/**
	 * Metodo para asignar el valor de {@link #respuestaComparacion}
	 * @param respuestaComparacion el valor de {@link #respuestaComparacion}
	 */
	public void setRespuestaComparacion(Map<String, Boolean> respuestaComparacion) {
		this.respuestaComparacion = respuestaComparacion;
	}

	
	public Integer getCodigoRespuestaDatos() {
		return codigoRespuestaDatos;
	}

	public void setCodigoRespuestaDatos(Integer codigoRespuestaDatos) {
		this.codigoRespuestaDatos = codigoRespuestaDatos;
	}



	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		if(respuestaSituacionRegistral!=null){
			builder.append(respuestaSituacionRegistral.toString());
		}
		if(respuestaComparacion!=null){

			builder.append(respuestaComparacion.toString());
		}
		String cad=String.valueOf(codigoRespuestaDatos);
		builder.append(cad);
		return builder.toString();
	}



}
