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
 * Tipo de servicios solicitados
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoServicioSolicitado {

    /**
     * Servicio solicitado OCR
     */
    OCR(1, "OCR", "Servicio solicitado OCR", true),

    /**
     * Servicio solicitado CIC
     */
    CIC(2, "CIC", "Servicio solicitado CIC", true),

    /**
     * Servicio solicitado CURP
     */
    CURP(3, "CURP", "Servicio solicitado CURP", true),
    
    /**
     * Servicio solicitado Reporte Robo/Extravío
     */
    REPROBOEXT(4, "REPROBOEXT", "Servicio solicitado Reporte Robo Extravío", true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    TipoServicioSolicitado(int id, String clave, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representación TipoServicioSolicitado del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoServicioSolicitado}
     * @return {@link TipoServicioSolicitado}
     */
    public static TipoServicioSolicitado valueOf(int id) {
        for (TipoServicioSolicitado TipoServicioSolicitado : values()) {
            if (TipoServicioSolicitado.getId() == id) {
                return TipoServicioSolicitado;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inválido para obtener enum TipoServicioSolicitado");
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
