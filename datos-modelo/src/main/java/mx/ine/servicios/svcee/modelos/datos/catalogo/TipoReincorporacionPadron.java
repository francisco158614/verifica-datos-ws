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
 * Catalogo de tipos de reincorporacion que pueden ser procesadas en CECYRD.
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoReincorporacionPadron {

    /**
     * Este tipo de reincorporaci�n es solicitada a trav�s de un tramite registrado en MAC.
     */
    REINCORPORACION_TRAMITE(1, "REINCORPORACION POR TRAMITE",
        "Reincorporaci�n solicitada trav�s del levantamiento de un tr�mite en MAC.", true),
    /**
     * Este tipo de reincorporaci�n es requerido en forma expresa, no es originada por un
     * tr�mite, se origina cuando a un ciudadano se le aplica una baja mal indebida.
     */
    REINCORPORACION_BAJA_MAL_APLICADA(2, "REINCORPORACION POR BAJA MAL APLICADA",
        "Reincorporaci�n del ciudadano por baja mal aplicada.", true),
    /**
     * Este tipo de reincorporaci�n es requerido en forma expresa, es originada por un tr�mite
     * mal aplicado y se sobreescribe la informaci�n con los datos de otro ciudadano(ANTES
     * USURPACION).
     */
    REINCORPORACION_TRAMITE_MAL_APLICADO(3, "TRAMITE MAL APLICADO",
        "Reincorporaci�n de un ciudadano por tr�mite mal aplicado.", true),
    /**
     * Esta reincorporaci�n se da por solicitud expresa y tiene como base un documento con los
     * datos del ciudadano a reincorporar.
     */
    REINCORPORACION_DOCUMENTO(4, "REINCORPORACION POR DOCUMENTO",
        "Reincorporaci�n a trav�s de datos de un documento.", true),

    /**
     * Este tipo de reincorporaci�n es requerido en forma expresa, no es originada por un
     * tr�mite, se origina cuando a un ciudadano es rehabilitado en sus derechos pol�ticos.
     */
    REINCORPORACION_REHABILITACION(5, "REINCORPORACION POR REHABILITACION",
        "Reincorporaci�n por rehabilitaci�n de los derechos pol�ticos del ciudadano.", true),
    
     /**
     *REINCORPORACION_POR_DICTAMEN 
     */
    REINCORPORACION_POR_DICTAMEN(6, "REINCORPORACION POR DICTAMEN",
        "Reincorporaci�n realizada a traves del procesamiento de un tramite que cuenta con un sentido de dictamen de analisis juridico igual a regular - irregular.", true),
    
	NO_IDENTIFICADO(
			-1,
			"NO IDENTIFICADO",
			"NO IDENTIFICADO",
			true);

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    
    
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoReincorporacionPadron.class);

    /**
     * Constructor
     * @param id
     * @param nombre
     * @param descripcion
     * @param activo
     */
    private TipoReincorporacionPadron(int id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Metodo en el cual a partir de un id obtiene el enum {@link TipoReincorporacionPadron}
     * @param id
     * @return {@link TipoReincorporacionPadron}
     */
    public static TipoReincorporacionPadron valueOf(int id) {
        for (TipoReincorporacionPadron TipoReincorporacionPadron : values()) {
            if (TipoReincorporacionPadron.getId() == id) {
                return TipoReincorporacionPadron;
            }
        }
        LOGGER.warn("id invalido para obtener enum TipoReincorporacionCECYRD: " + id);
        return NO_IDENTIFICADO; 
    }

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return el atributo clave
     */
    public String getClave() {
        return nombre;
    }

    /**
     * @param clave parametro clave a actualizar
     */
    public void setNombre(String clave) {
        this.nombre = clave;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

}
