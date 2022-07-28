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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DatosComparacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="DatosComparacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="claveElector" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="numeroEmisionCredencial" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ocr" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cic" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="curp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidoPaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="apellidoMaterno" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="anioRegistro" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="anioEmision" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numeroReporteRoboExtravio" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DatosComparacion", propOrder = {
	"ocr",
	"claveElector",
    "numeroEmisionCredencial",    
    "cic",
    "curp",
    "nombre",
    "apellidoPaterno",
    "apellidoMaterno",
    "anioRegistro",
    "anioEmision",
    "numeroReporteRoboExtravio"
})
public class DatosComparacion implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8503670957769765416L;

	@XmlElement(required = true)
    protected String ocr;
	
    @XmlElement(required = true)
    protected String claveElector;
    
    protected Integer numeroEmisionCredencial;
    
    @XmlElement(required = true)
    protected String cic;
    @XmlElement(required = true)
    protected String curp;
    @XmlElement(required = true)
    protected String nombre;
    @XmlElement(required = true)
    protected String apellidoPaterno;
    @XmlElement(required = true)
    protected String apellidoMaterno;
    protected Integer anioRegistro;
    protected Integer anioEmision;
    protected Long numeroReporteRoboExtravio;

    /**
     * Obtiene el valor de la propiedad claveElector.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaveElector() {
        return claveElector;
    }

    /**
     * Define el valor de la propiedad claveElector.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaveElector(String value) {
        this.claveElector = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroEmisionCredencial.
     * 
     */
    public Integer getNumeroEmisionCredencial() {
        return numeroEmisionCredencial;
    }

    /**
     * Define el valor de la propiedad numeroEmisionCredencial.
     * 
     */
    public void setNumeroEmisionCredencial(Integer value) {
        this.numeroEmisionCredencial = value;
    }

    /**
     * Obtiene el valor de la propiedad ocr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOcr() {
        return ocr;
    }

    /**
     * Define el valor de la propiedad ocr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOcr(String value) {
        this.ocr = value;
    }

    /**
     * Obtiene el valor de la propiedad cic.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCic() {
        return cic;
    }

    /**
     * Define el valor de la propiedad cic.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCic(String value) {
        this.cic = value;
    }

    /**
     * Obtiene el valor de la propiedad curp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurp() {
        return curp;
    }

    /**
     * Define el valor de la propiedad curp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurp(String value) {
        this.curp = value;
    }

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoPaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Define el valor de la propiedad apellidoPaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoPaterno(String value) {
        this.apellidoPaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad apellidoMaterno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Define el valor de la propiedad apellidoMaterno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApellidoMaterno(String value) {
        this.apellidoMaterno = value;
    }

    /**
     * Obtiene el valor de la propiedad anioRegistro.
     * 
     */
    public Integer getAnioRegistro() {
        return anioRegistro;
    }

    /**
     * Define el valor de la propiedad anioRegistro.
     * 
     */
    public void setAnioRegistro(Integer value) {
        this.anioRegistro = value;
    }

    /**
     * Obtiene el valor de la propiedad anioEmision.
     * 
     */
    public Integer getAnioEmision() {
        return anioEmision;
    }

    /**
     * Define el valor de la propiedad anioEmision.
     * 
     */
    public void setAnioEmision(Integer value) {
        this.anioEmision = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroReporteRoboExtravio.
     * 
     */
    public Long getNumeroReporteRoboExtravio() {
        return numeroReporteRoboExtravio;
    }

    /**
     * Define el valor de la propiedad numeroReporteRoboExtravio.
     * 
     */
    public void setNumeroReporteRoboExtravio(Long value) {
        this.numeroReporteRoboExtravio = value;
    }
	

	/*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DatosComparacion [claveElector=" + claveElector + ", numeroEmisionCredencial="
            + numeroEmisionCredencial + ", ocr=" + ocr + ", cic=" + cic + ",  curp=" + curp
            + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
            + ", apellidoMaterno=" + apellidoMaterno + ", anioRegistro=" + anioRegistro
            + "]";
    }

}
