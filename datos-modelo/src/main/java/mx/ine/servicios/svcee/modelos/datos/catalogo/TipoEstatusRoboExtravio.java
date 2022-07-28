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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enum de vigencia del reporte
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoEstatusRoboExtravio {
    /**
     * Vigencia temporal
     */
    TEMPORAL(1, "Temporal", "Reporte temporal", true),

    /**
     * Vigencia permanente
     */
    PERMANENTE(2, "Permanente", "Reporte permanente", true),

    /**
     * Vigencia permanente
     */
    CANCELADO(3, "Cancelado", "Reporte cancelado", true),

    /**
     * Vigencia permanente
     */
    NO_IDENTIFICADO(4, "No identificado", "Reporte en el cual no se identifica un ciudadano",
        true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoEstatusRoboExtravio.class);

    TipoEstatusRoboExtravio(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representaci�n TipoEstatusRoboExtravio del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoEstatusRoboExtravio}
     * @return {@link TipoEstatusRoboExtravio}
     */
    public static TipoEstatusRoboExtravio valueOf(int id) {
        for (TipoEstatusRoboExtravio tipoEstatusRoboExtravio : values()) {
            if (tipoEstatusRoboExtravio.getId() == id) {
                return tipoEstatusRoboExtravio;
            }
        }
        LOGGER.warn("Id '" + id
            + "' inv�lido para obtener enum TipoEstatusRoboExtravio");
        return TipoEstatusRoboExtravio.NO_IDENTIFICADO;
    }

    /**
     * Obtiene un tipoVigenciaReporte por su clave
     * @param clave
     * @return TipoEstatusRoboExtravio que contiene esa clave
     */
    public static TipoEstatusRoboExtravio obtenPorClave(String clave) {
        for (TipoEstatusRoboExtravio tipoEstatusRoboExtravio : values()) {
            if (tipoEstatusRoboExtravio.getNombre().equals(clave)) {
                return tipoEstatusRoboExtravio;
            }
        }
        throw new IllegalArgumentException("Clave '" + clave
            + "' inv�lida para obtener enum TipoEstatusRoboExtravio");
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
