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

/**
 * Enum de tipo de busqueda que se utilizará para encontrar los datos de un ciudadano
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoBusqueda {
    
    /**
     * Busqueda por CURP
     */
    CURP(1, "CURP", "Busqueda por CURP", true),
    
    /**
     * Busqueda por CIC
     */
    CIC(2, "CIC", "Busqueda por CIC", true),

    /**
     * Busqueda por Clave de Elector
     */
    CLAVE_ELECTOR(3, "CLAVE ELECTOR", "Busqueda por Clave de Elector", true),
    
    /**
     * Búsqueda por Reporte Robo/Extravío
     */
    REPORTEROBOEXTRAVIO_ID(4, "REPORTEROBOEXTRAVIO", "Busqueda por Reporte Robo o Extravío", true);
    

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    TipoBusqueda(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representación TipoBusqueda del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoBusqueda}
     * @return {@link TipoBusqueda}
     */
    public static TipoBusqueda valueOf(int id) {
        for (TipoBusqueda TipoBusqueda : values()) {
            if (TipoBusqueda.getId() == id) {
                return TipoBusqueda;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inválido para obtener enum TipoBusqueda");
    }
    
    /**
     * Regresa la representación TipoBusqueda del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoBusqueda}
     * @return {@link TipoBusqueda}
     */
    public static TipoBusqueda valueOfClave(String clave) {
        for (TipoBusqueda TipoBusqueda : values()) {
            if (TipoBusqueda.getNombre().equals(clave)) {
                return TipoBusqueda;
            }
        }
        throw new IllegalArgumentException("clave '" + clave
            + "' inválido para obtener enum TipoBusqueda");
    }

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @return el atributo nombre
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
