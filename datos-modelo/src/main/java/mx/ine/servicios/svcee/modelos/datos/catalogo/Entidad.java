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
package mx.ine.servicios.svcee.modelos.datos.catalogo;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Catálogo de entidades
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum Entidad {

    /**
     * Catalogo tipo AGUASCALIENTES
     */
    @XmlEnumValue("1")
    AGUASCALIENTES(1, "AGS", "Aguascalientes", true, "AGUASCALIENTES"),

    /**
     * Catalogo tipo BAJA CALIFORNIA
     */
    @XmlEnumValue("2")
    BAJA_CALIFORNIA(2, "BC", "Baja california", true, "BAJA_CALIFORNIA"),

    /**
     * Catalogo tipo BAJA CALIFORNIA SUR
     */
    @XmlEnumValue("3")
    BAJA_CALIFORNIA_SUR(3, "BCS", "Baja california sur", true, "BAJA_CALIFORNIA_SUR"),
    /**
     * Catalogo tipo CAMPECHE
     */
    @XmlEnumValue("4")
    CAMPECHE(4, "CAMP", "Campeche", true, "CAMPECHE"),
    /**
     * Catalogo tipo COAHUILA
     */
    @XmlEnumValue("5")
    COAHUILA(5, "COAH", "Coahuila", true, "COAHUILA"),
    /**
     * Catalogo tipo COLIMA
     */
    @XmlEnumValue("6")
    COLIMA(6, "COL", "Colima", true, "COLIMA"),
    /**
     * Catalogo tipo CHIAPAS
     */
    @XmlEnumValue("7")
    CHIAPAS(7, "CHIS", "Chiapas", true, "CHIAPAS"),
    /**
     * Catalogo tipo CHIHUAHUA
     */
    @XmlEnumValue("8")
    CHIHUAHUA(8, "CHIH", "Chihuahua", true, "CHIHUAHUA"),
    /**
     * Catalogo tipo DISTRITO FEDERAL
     */
    @XmlEnumValue("9")
    DISTRITO_FEDERAL(9, "DF", "Distrito Federal", true, "DISTRITO_FEDERAL"),
    /**
     * Catalogo tipo DURANGO
     */
    @XmlEnumValue("10")
    DURANGO(10, "DGO", "Durango", true, "DURANGO"),
    /**
     * Catalogo tipo GUANAJUATO
     */
    @XmlEnumValue("11")
    GUANAJUATO(11, "GTO", "Guanajuato", true, "GUANAJUATO"),
    /**
     * Catalogo tipo GUERRERO
     */
    @XmlEnumValue("12")
    GUERRERO(12, "GRO", "Guerrero", true, "GUERRERO"),
    /**
     * Catalogo tipo HIDALGO
     */
    @XmlEnumValue("13")
    HIDALGO(13, "HGO", "Hidalgo", true, "HIDALGO"),
    /**
     * Catalogo tipo JALISCO
     */
    @XmlEnumValue("14")
    JALISCO(14, "JAL", "Jalisco", true, "JALISCO"),
    /**
     * Catalogo tipo ESTADO DE MEXICO
     */
    @XmlEnumValue("15")
    ESTADO_DE_MEXICO(15, "MEX", "Mexico", true, "ESTADO_DE_MEXICO"),
    /**
     * Catalogo tipo MICHOACAN
     */
    @XmlEnumValue("16")
    MICHOACAN(16, "MICH", "Michoacan", true, "MICHOACAN"),
    /**
     * Catalogo tipo MORELOS
     */
    @XmlEnumValue("17")
    MORELOS(17, "MOR", "Morelos", true, "MORELOS"),
    /**
     * Catalogo tipo NAYARIT
     */
    @XmlEnumValue("18")
    NAYARIT(18, "NAY", "Nayarit", true, "NAYARIT"),
    /**
     * Catalogo tipo NUEVO LEON
     */
    @XmlEnumValue("19")
    NUEVO_LEON(19, "NL", "Nuevo Leon", true, "NUEVO_LEON"),
    /**
     * Catalogo tipo OAXACA
     */
    @XmlEnumValue("20")
    OAXACA(20, "OAX", "Oaxaca", true, "OAXACA"),
    /**
     * Catalogo tipo PUEBLA
     */
    @XmlEnumValue("21")
    PUEBLA(21, "PUE", "Puebla", true, "PUEBLA"),
    /**
     * Catalogo tipo QUERETARO
     */
    @XmlEnumValue("22")
    QUERETARO(22, "QRO", "Queretaro", true, "QUERETARO"),
    /**
     * Catalogo tipo
     */
    @XmlEnumValue("23")
    QUINTANA_ROO(23, "QROO", "Quintana Roo", true, "QUINTANA_ROO"),
    /**
     * Catalogo tipo SAN LUIS POTOSI
     */
    @XmlEnumValue("24")
    SAN_LUIS_POTOSI(24, "SLP", "San Luis Potosi", true, "SAN_LUIS_POTOSI"),
    /**
     * Catalogo tipo SINALOA
     */
    @XmlEnumValue("25")
    SINALOA(25, "SIN", "Sinaloa", true, "SINALOA"),
    /**
     * Catalogo tipo SONORA
     */
    @XmlEnumValue("26")
    SONORA(26, "SON", "Sonora", true, "SONORA"),
    /**
     * Catalogo tipo TABASCO
     */
    @XmlEnumValue("27")
    TABASCO(27, "TAB", "Tabasco", true, "TABASCO"),
    /**
     * Catalogo tipo TAMAULIPAS
     */
    @XmlEnumValue("28")
    TAMAULIPAS(28, "TAMPS", "Tamaulipas", true, "TAMAULIPAS"),
    /**
     * Catalogo tipo TLAXCALA
     */
    @XmlEnumValue("29")
    TLAXCALA(29, "TLAX", "Tlaxcala", true, "TLAXCALA"),
    /**
     * Catalogo tipo VERACRUZ
     */
    @XmlEnumValue("30")
    VERACRUZ(30, "VER", "Veracruz", true, "VERACRUZ"),
    /**
     * Catalogo tipo YUCATAN
     */
    @XmlEnumValue("31")
    YUCATAN(31, "YUC", "Yucatan", true, "YUCATAN"),
    /**
     * Catalogo tipo ZACATECAS
     */
    @XmlEnumValue("32")
    ZACATECAS(32, "ZAC", "Zacatecas", true, "ZACATECAS"),

    /**
     * Esta entidad es una exception y solo aplica para los documentos de identificacion para
     * los casos cuando el acta de nacimiento es expedida en otro pais.
     */
    @XmlEnumValue("39")
    SERVICIO_EXTERIOR_MEXICANO(39, "NE", "Servicio exterior mexicano", true,
        "SERVICIO_EXTERIOR_MEXICANO");

    /**
     * Regresa una instancia de esta clase a partir de un identificador.
     * @param id Identificador atraves del cual se obtendra una instancia de esta clase.
     * @return Una instancia de {@link Entidad}
     */
    public static Entidad valueOf(int id) {
        for (Entidad entidad : values()) {
            if (entidad.id == id) {
                return entidad;
            }
        }
        throw new IllegalArgumentException("Id invalido para obtener enum Entidad: " + id);
    }

    private int id;

    private String nombre;

    private String descripcion;

    private boolean activo;

    private String desCorta;

    /**
     * Constructor
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    private Entidad(int id, String clave, String descripcion, boolean activo, String desCorta) {
        this.id = id;
        this.nombre = clave;
        this.descripcion = descripcion;
        this.activo = activo;
        this.desCorta = desCorta;
    }

    /**
     * @return el atributo clave
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el atributo desCorta
     */
    public String getDesCorta() {
        return desCorta;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @return el atributo activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo parametro activo a actualizar
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @param nombre parametro clave a actualizar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param desCorta parametro desCorta a actualizar
     */
    public void setDesCorta(String desCorta) {
        this.desCorta = desCorta;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(int id) {
        this.id = id;
    }
}
