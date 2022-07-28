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

/**
 * Enum de tipo de busqueda que se utilizar� para encontrar los datos de un ciudadano
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
     * B�squeda por Reporte Robo/Extrav�o
     */
    REPORTEROBOEXTRAVIO_ID(4, "REPORTEROBOEXTRAVIO", "Busqueda por Reporte Robo o Extrav�o", true);
    

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
     * Regresa la representaci�n TipoBusqueda del argumento <code>int</code>
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
            + "' inv�lido para obtener enum TipoBusqueda");
    }
    
    /**
     * Regresa la representaci�n TipoBusqueda del argumento <code>int</code>
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
            + "' inv�lido para obtener enum TipoBusqueda");
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
