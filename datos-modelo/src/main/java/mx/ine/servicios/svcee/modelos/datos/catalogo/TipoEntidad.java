/**
 * Fecha de creaci�n: 2019
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
package mx.ine.servicios.svcee.modelos.datos.catalogo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Clase Java para tipoEntidad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoEntidad">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CIUDADANO_SCPLN"/>
 *     &lt;enumeration value="REPORTES_SCPLN"/>
 *     &lt;enumeration value="ENTIDADES_EXTERNAS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoEntidad")
@XmlEnum
public enum TipoEntidad {


    /**
     * Ciudadano via SCPLN
     */
    CIUDADANO_SCPLN(1, "Ciudadano", "Consulta Permanente a Lista Nominal", true),
    
    /**
     * Reportes SCPLN
     */
    REPORTES_SCPLN(2, "Responsable de SCPLN", "Encargado de generar reportes del sisema consulta permanente a lista nominal", true),

    /**
     * Entidades Externas
     */
    ENTIDADES_EXTERNAS(3, "Responsable de Entidades Externas", "Encargado de generar reportes en el sistema de cualquier entidad externa", true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    TipoEntidad(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representaci�n TipoEntidad del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoEntidad}
     * @return {@link TipoEntidad}
     */
    public static TipoEntidad valueOf(int id) {
        for (TipoEntidad TipoEntidad : values()) {
            if (TipoEntidad.getId() == id) {
                return TipoEntidad;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inv�lido para obtener enum TipoEntidad");
    }

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @return el atributo clave
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return el atributo activo
     */
    public boolean isActivo() {
        return activo;
    }
}
