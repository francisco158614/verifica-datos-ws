/**
 * Fecha de creaci�n: 2021
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
 * 
 */
package mx.ine.servicios.svcee.modelos.datos.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Respuesta del servicio integrador
 * @author Edgar Emilio Paz Flores
 * @version 4.0
 * @since SIIRFE 6.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tiempoWS",
    "tiempoTotal"
})
@XmlRootElement(name = "RespuestaProxyIntegrador")
public class RespuestaProxyIntegrador  extends RespuestaIntegrador {
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7486492182636156806L;
	
	/**
	 * Tiempo total medido desde el WS
	 */
	private Long tiempoWS;
	/**
	 * Tiempo total medido desde el Proxy
	 */
	private Long tiempoTotal;
	
	public RespuestaProxyIntegrador() {
	}
	
	public RespuestaProxyIntegrador(RespuestaIntegrador datos) {
		this.setRespuestaSituacionRegistral(datos.getRespuestaSituacionRegistral());
		this.setRespuestaComparacion(datos.getRespuestaComparacion());
		this.setCodigoRespuestaDatos(datos.getCodigoRespuestaDatos());
		this.setCiudadanoId(datos.getCiudadanoId());
		this.setCredencialId(datos.getCredencialId());
		this.setTiempoDatos(datos.getTiempoDatos());
		this.setDescripcion(datos.getDescripcion());
		this.setServicioSolicitado(datos.getServicioSolicitado());
		this.setTiempoBusqueda(datos.getTiempoBusqueda());
		this.setCredencialActiva(datos.isCredencialActiva());
		this.setFotoId(datos.getFotoId());
		this.setHuellaId(datos.getHuellaId());
		this.setUltimaCredencial(datos.isUltimaCredencial());
		this.setEstatusArco(datos.getEstatusArco());
	}

	/**
	 * @return the tiempoWS
	 */
	public Long getTiempoWS() {
		return tiempoWS;
	}
	/**
	 * @param tiempoWS the tiempoWS to set
	 */
	public void setTiempoWS(Long tiempoWS) {
		this.tiempoWS = tiempoWS;
	}
	/**
	 * @return the tiempoTotal
	 */
	public Long getTiempoTotal() {
		return tiempoTotal;
	}
	/**
	 * @param tiempoTotal the tiempoTotal to set
	 */
	public void setTiempoTotal(Long tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}
}
