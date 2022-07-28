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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Respuesta del servicio integrador
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @author Andres Lopez (andres.lopez@ine.mx) cambios 2016
 * @version 2.0
 * @since SIIRFE 6.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "ciudadanoId",
    "credencialId",
    "tiempoDatos",
    "descripcion",
    "servicioSolicitado",
    "tiempoBusqueda",
    "credencialActiva",
    "fotoId",
    "huellaId",
    "ultimaCredencial",
    "estatusArco",
    "tiempoServicio"
})
@XmlRootElement(name = "RespuestaIntegrador")
public class RespuestaIntegrador  extends RespuestaBase {
	
	/**
	 * Serial versión UID
	 */
	private static final long serialVersionUID = 6478425735816737561L;
    /**
     * Identificador del ciudadano verificado (sin invertir).
     */
	@XmlElement(required = true)
    private String ciudadanoId;
    /**
     * identificador de la credencial
     */
    private String credencialId;
    /**
	 * Tiempo en milisegundos que tardo en generar la respuesta completa del ws-entidades-externas
	 */
	private Long tiempoDatos;
	/**
	 * mensaje de error en caso de no existir es nulo
	 */
	private String descripcion;
	/**
	 * Estrategia de busqueda establecida por la aplicación.CIC,CURP,CLAVE_ELECTOR etc.
	 */
	private String servicioSolicitado;
	/**
	 * tiempo en milisegundos que tarda en realizar la busqueda del ciudadano.
	 */
	private Long tiempoBusqueda;
	/**
	 * bandera auxiliar que indica si es posible verificar biometricos
	 * se activa para cuando es la ultima credencial y no contiene un reporte de robo/extravio permanente
	 */
	private Boolean credencialActiva;
	/**
	 * Identificador de la foto asociada a la credencial
	 */
	private String fotoId;
	/**
	 * Identificador de la huella para siirfe
	 */
	private String huellaId;
	/**
	 * indica si fue la ultima credencial
	 */
	private Boolean ultimaCredencial;
	/**
	 * Bandera que se activa cuando el ciudadano buscado es encontrado con 
	 * la badera de estatus arco activa. 
	 */
	private Boolean estatusArco;
	private Long tiempoServicio;
	
	/**
	 * Obtiene el valor de la propiedad  {@link #ciudadanoId}
	 * @return the ciudadanoId
	 */
	public String getCiudadanoId() {
		return ciudadanoId;
	}
	/**
	 * Metodo para asignar el valor de {@link #ciudadanoId}
	 * @param ciudadanoId el valor de {@link #ciudadanoId}
	 */
	public void setCiudadanoId(String ciudadanoId) {
		this.ciudadanoId = ciudadanoId;
	}

	public String getCredencialId() {
		return credencialId;
	}

	public void setCredencialId(String credencialId) {
		this.credencialId = credencialId;
	}
	/**
	 * Obtiene el valor de la propiedad  {@link #tiempoDatos}
	 * @return the tiempoDatos
	 */
	public Long getTiempoDatos() {
		return tiempoDatos;
	}
	/**
	 * Metodo para asignar el valor de {@link #tiempoDatos}
	 * @param tiempoDatos el valor de {@link #tiempoDatos}
	 */
	public void setTiempoDatos(Long tiempoDatos) {
		this.tiempoDatos = tiempoDatos;
	}
	/**
	 * @return el atributo mensajeError
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param mensajeError parametro mensajeError a actualizar
	 */
	public void setDescripcion(String mensajeError) {
		this.descripcion = mensajeError;
	}
	/**
	 * @return the servicioSolicitado
	 */
	public String getServicioSolicitado() {
		return servicioSolicitado;
	}
	/**
	 * @param servicioSolicitado the servicioSolicitado to set
	 */
	public void setServicioSolicitado(String servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}
	/**
	 * @return the tiempoBusqueda
	 */
	public Long getTiempoBusqueda() {
		return tiempoBusqueda;
	}
	/**
	 * @param tiempoBusqueda the tiempoBusqueda to set
	 */
	public void setTiempoBusqueda(Long tiempoBusqueda) {
		this.tiempoBusqueda = tiempoBusqueda;
	}
	/**
	 * @return the verificaBiometricos
	 */
	public Boolean isCredencialActiva() {
		return credencialActiva;
	}
	/**
	 * @param verificaBiometricos the verificaBiometricos to set
	 */
	public void setCredencialActiva(Boolean verificaBiometricos) {
		this.credencialActiva = verificaBiometricos;
	}
	public String getFotoId() {
		return fotoId;
	}
	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}
	public String getHuellaId() {
		return huellaId;
	}

	public void setHuellaId(String huellaId) {
		this.huellaId = huellaId;
	}
	/**
	 * @return the ultimaCredencial
	 */
	public Boolean isUltimaCredencial() {
		return ultimaCredencial;
	}
	/**
	 * @param ultimaCredencial the ultimaCredencial to set
	 */
	public void setUltimaCredencial(Boolean ultimaCredencial) {
		this.ultimaCredencial = ultimaCredencial;
	}
	/**
	 * @return the estatusArco
	 */
	public Boolean getEstatusArco() {
		return estatusArco;
	}
	/**
	 * @param estatusArco the estatusArco to set
	 */
	public void setEstatusArco(Boolean estatusArco) {
		this.estatusArco = estatusArco;
	}

	@Override
	public String toString() {
		return "RespuestaIntegrador [getCiudadanoId()=" + getCiudadanoId() + ", getCredencialId()=" + getCredencialId()
				+ ", getTiempoDatos()=" + getTiempoDatos() + ", getDescripcion()=" + getDescripcion()
				+ ", getServicioSolicitado()=" + getServicioSolicitado() + ", getTiempoBusqueda()="
				+ getTiempoBusqueda() + ", isVerificaBiometricos()=" + isCredencialActiva() + ", getFotoId()="
				+ getFotoId() + ", getHuellaId()=" + getHuellaId() + ", getEstatusArco()=" + getEstatusArco() + "]";
	}
	/**
	 * @return the tiempoServicio
	 */
	public Long getTiempoServicio() {
		return tiempoServicio;
	}
	/**
	 * @param tiempoServicio the tiempoServicio to set
	 */
	public void setTiempoServicio(Long tiempoServicio) {
		this.tiempoServicio = tiempoServicio;
	}
}
