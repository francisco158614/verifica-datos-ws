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

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoRespuestaSolicitada;

import javax.xml.bind.annotation.XmlAccessType;;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serialCertificado" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tipoRespuestaSolicitada" type="{INE}tipoRespuestaSolicitada"/>
 *         &lt;element name="datosComparacion" type="{INE}datosComparacion"/>
 *         &lt;element name="conAvisoPrivacidad" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/**
 * Datos del entrada del servicio integrador
 * @author 
 * @version 1.0
 * @since SIIRFE 6.5.0.0.3
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tipoRespuestaSolicitada",
    "datosComparacion", 
    "conAvisoPrivacidad",
    "indice"
})
@XmlRootElement(name="DatosEntrada")
public class DatosEntrada implements Serializable{
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1539933520706995244L;
	
	    
    /**
     * Tipo de respuesta o servicio que se solicita
     */
	 @XmlElement(required = true)
    private TipoRespuestaSolicitada tipoRespuestaSolicitada;  
     
    /**
     * Datos de comparacion
     */
	 @XmlElement(required = true)
    private DatosComparacion datosComparacion;
    
    
    /**
     * Bandera de aviso de privacidad
     */
	 @XmlElement(required = true)
    private Boolean conAvisoPrivacidad;
	 
	 /**
	  * id de la trnasación de la consulta
	  */
	 @XmlElement(required = true)
	 private String indice;
    
	
	/**
     * @return el atributo tipoRespuestaSolicitada
     */
    public TipoRespuestaSolicitada getTipoRespuestaSolicitada() {
        return tipoRespuestaSolicitada;
    }
    /**
     * @param tipoRespuestaSolicitada parametro tipoRespuestaSolicitada a actualizar
     */
    public void setTipoRespuestaSolicitada(TipoRespuestaSolicitada tipoRespuestaSolicitada) {
        this.tipoRespuestaSolicitada = tipoRespuestaSolicitada;
    }
   
    /**
     * @return el atributo datosComparacion
     */
    public DatosComparacion getDatosComparacion() {
        return datosComparacion;
    }
    /**
     * @param datosComparacion parametro datosComparacion a actualizar
     */
    public void setDatosComparacion(DatosComparacion datosComparacion) {
        this.datosComparacion = datosComparacion;
    }
    /**
     * @return el atributo conAvisoPrivacidad
     */
    public Boolean getConAvisoPrivacidad() {
        return conAvisoPrivacidad;
    }
    /**
     * @param conAvisoPrivacidad parametro conAvisoPrivacidad a actualizar
     */
    public void setConAvisoPrivacidad(Boolean conAvisoPrivacidad) {
        this.conAvisoPrivacidad = conAvisoPrivacidad;
    }
    
    /**
     * 
     * @return identificador de la transacción en la solicitud
     */
	public String getIndice() {
		return indice;
	}
	/**
	 * 
	 * @param indice identificador de la transacción en la solicitud
	 */
	public void setIndice(String indice) {
		this.indice = indice;
	}
  
    
    
    
}
