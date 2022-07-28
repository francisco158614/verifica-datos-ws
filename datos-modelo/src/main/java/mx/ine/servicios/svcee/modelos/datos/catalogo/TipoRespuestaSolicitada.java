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
    SITUACION_REGISTRAL(1, "Situación Registral", "Se envía respuesta de situación registral del ciudadano (SCPLN)", true),
    
    /**
     * Se envia respuesta de comparacion de los datos recibidos
     */
    COMPARACION(2, "Comparación", "Se envía respuesta de comparación de los datos recibidos", true),

    /**
     * Se envia respuesta de situacion registral y respueta de comparacion
     */
    AMBAS(3, "Situación Registral y Comparación", "Se envía respuesta de situación registral y respueta de comparación", true),
    
    /**
     * Se envia respuesta de situacion registral corta y respueta de comparacion
     */
    CONSULTA_EXTERNA(4, "Consulta Externa", "Se envía respuesta de situación registral corta y respueta de comparación", true);

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
     * Regresa la representación TipoRespuestaSolicitada del argumento <code>int</code>
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
            + "' inválido para obtener enum TipoRespuestaSolicitada");
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
