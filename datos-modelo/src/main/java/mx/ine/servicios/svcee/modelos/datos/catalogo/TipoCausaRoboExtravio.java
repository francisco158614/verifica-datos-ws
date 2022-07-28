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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enum de causas de reporte
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoCausaRoboExtravio {
    /**
     * Causa por credencial robada
     */
    ROBO(2, "Robo", "Credencial Robada", true),

    /**
     * Causa por crendencial extraviada
     */
    EXTRAVIO(3, "Extravio", "Credencial Extraviada", true),
    
    NO_IDENTIFICADO(-1, "NO IDENTIFICADO","No identificado",true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private static final Logger LOGGER = LoggerFactory.getLogger(TipoCausaRoboExtravio.class);

    TipoCausaRoboExtravio(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representación TipoCausaRoboExtravio del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoCausaRoboExtravio}
     * @return {@link TipoCausaRoboExtravio}
     */
    public static TipoCausaRoboExtravio valueOf(int id) {
        for (TipoCausaRoboExtravio tipoCausaRoboExtravio : values()) {
            if (tipoCausaRoboExtravio.getId() == id) {
                return tipoCausaRoboExtravio;
            }
        }
        LOGGER.warn("Id '" + id + "' inválido para obtener enum TipoCausaRoboExtravio");
        return NO_IDENTIFICADO;
    }

    /**
     * Obtiene un tipoCausaReporte por su clave
     * @param clave
     * @return TipoCausaRoboExtravio que contiene esa clave
     */
    public static TipoCausaRoboExtravio obtenPorClave(String clave) {

        for (TipoCausaRoboExtravio tipoCausaRoboExtravio : values()) {
            if (tipoCausaRoboExtravio.getNombre().equals(clave)) {
                return tipoCausaRoboExtravio;
            }
        }
        throw new IllegalArgumentException("Clave '" + clave
            + "' inválida para obtener enum TipoCausaRoboExtravio");
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
