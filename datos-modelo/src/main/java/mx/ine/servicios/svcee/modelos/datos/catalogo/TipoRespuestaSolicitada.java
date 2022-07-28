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
 * Tipo de respuesta solicitada al integrador de servicios, es decir, tipo de servicio a consultar
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@XmlType(name = "tipoRespuestaSolicitada")
@XmlEnum
public enum TipoRespuestaSolicitada {
    
    /**
     * Se envia respuesta de situacion registral del ciudadano (SCPLN)
     */
    SITUACION_REGISTRAL(1, "Situaci�n Registral", "Se env�a respuesta de situaci�n registral del ciudadano (SCPLN)", true),
    
    /**
     * Se envia respuesta de comparacion de los datos recibidos
     */
    COMPARACION(2, "Comparaci�n", "Se env�a respuesta de comparaci�n de los datos recibidos", true),

    /**
     * Se envia respuesta de situacion registral y respueta de comparacion
     */
    AMBAS(3, "Situaci�n Registral y Comparaci�n", "Se env�a respuesta de situaci�n registral y respueta de comparaci�n", true),
    
    /**
     * Se envia respuesta de situacion registral corta y respueta de comparacion
     */
    CONSULTA_EXTERNA(4, "Consulta Externa", "Se env�a respuesta de situaci�n registral corta y respueta de comparaci�n", true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    TipoRespuestaSolicitada(int id, String clave, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representaci�n TipoRespuestaSolicitada del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoRespuestaSolicitada}
     * @return {@link TipoRespuestaSolicitada}
     */
    public static TipoRespuestaSolicitada valueOf(int id) {
        for (TipoRespuestaSolicitada TipoRespuestaSolicitada : values()) {
            if (TipoRespuestaSolicitada.getId() == id) {
                return TipoRespuestaSolicitada;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inv�lido para obtener enum TipoRespuestaSolicitada");
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
