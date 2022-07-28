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
 * Enum que representa los diferentes tipos de bajas que aplican a un ciudadano.
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public enum TipoBajaPadron {

	/**
	 * Catalogo tipo DUPLICADO
	 */
	DUPLICADO(1, "DUPLICADO", "Duplicado", true),

	/**
	 * Catalogo tipo DEFUNCION
	 */
	DEFUNCION(2, "DEFUNCION", "Defunci�n", true),

	/**
	 * Catalogo tipo SUSPENSION
	 */
	SUSPENSION(3, "SUSPENSION", "Suspensi�n", true),

	/**
	 * Catalogo tipo PERDIDA_VIGENCIA
	 */
	CANCELACION_TRAMITE(4, "CANCELACION TRAMITE", "Cancelacion de tramite", true),

	/**
	 * Catalogo tipo PERDIDAD_NACIONALIDAD
	 */
	PERDIDAD_NACIONALIDAD(5, "PERDIDAD NACIONALIDAD", "Perdida de nacionalidad", false),

	/**
	 * Catalogo tipo CAMBIO_DOMICILIO
	 */
	CAMBIO_DOMICILIO(6, "CAMBIO DE DOMICILIO", "Cambio de domicilio", false),

	/**
	 * Catalogo tipo MENORES_DE_EDAD
	 */
	MENORES_DE_EDAD(7, "MENORES DE EDAD", "Menores de edad", false),

	/**
	 * Catalogo tipo MIGRACION
	 */
	MIGRACION(8, "MIGRACION", "Migraci�n", false),

	/**
	 * Catalogo tipo SUSPENSION_POR_VALIDACION_EN_SVCS
	 */
	SUSPENSION_POR_VALIDACION_EN_SVCS(9, "SUSPENSION POR VALIDACION EN SVCS",
		"Suspensi�n por validaci�n en SVCS", true),

	/**
	 * Catalogo tipo TRAMITE_CON_DOCUMENTACION_APOCRIFA
	 */
	TRAMITE_CON_DOCUMENTACION_APOCRIFA(10, "TRAMITE CON DOCUMENTACION APOCRIFA",
		"Tramite con documentaci�n ap�crifa", false),
	/**
	 * Catalogo tipo CANCELADO_POR_SUSPENSI�N_DERECHOS
	 */
	TRAMITE_CANCELADO_POR_SUSPENSION_DERECHOS(11,
		"TRAMITE CANCELADO POR SUSPENSI�N DE DERECHOS",
		"Tramite cancelado por suspensi�n de derechos", true),

	/**
	 * Catalogo tipo DOMICILIO_IRREGULAR
	 */
	DOMICILIO_IRREGULAR(12, "DOMICILIO IRREGULAR", "Domicilio irregular", true),

	/**
	 * Catalogo tipo DATOS_PERSONALES_IRREGULARES
	 */
	DATOS_PERSONALES_IRREGULARES(13, "DATOS PERSONALES IRREGULARES",
		"Datos personales irregulares", true),

	/**
	 * Catalogo tipo PERDIDA_VIGENCIA
	 */
	PERDIDA_VIGENCIA(14, "PERDIDA DE VIGENCIA", "Perdida de vigencia", true),

	/**
	 * Catalogo tipo Usurpaci�n de identidad
	 */
	USURPACION_IDENTIDAD(15, "USURPACION DE IDENTIDAD", "Usurpaci�n de identidad", true),
	
	/**
     * Catalogo tipo Credencial robada al ciudadano
     */
    CREDENCIAL_ROBADA_CIUDADANO(97, "CREDENCIAL_ROBADA_CIUDADANO", "Credencial robada al ciudadano", true),
    
    /**
     * Catalogo tipo Credencial extraviada por el ciudadano
     */
    CREDENCIAL_EXTRAVIADA_CIUDADANO(98, "CREDENCIAL_EXTRAVIADA_CIUDADANO", "Credencial extraviada por el ciudadano", true),
    
    /**
     * Catalogo tipo Credencial robada al instituto
     */
    CREDENCIAL_ROBADA_INE(99, "CREDENCIAL_ROBADA_INE", "Credencial robada al instituto", true),
	
	NO_IDENTIFICADO(
			-1,
			"NO IDENTIFICADO",
			"NO IDENTIFICADO",
			true);

	private int id;

	private String nombre;

	private String descripcion;

	private boolean activo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoBajaPadron.class);

	/**
	 * Constructor
	 * @param id
	 * @param clave
	 * @param descripcion
	 * @param activo
	 */
	private TipoBajaPadron(int id, String clave, String descripcion, boolean activo) {
		this.id = id;
		this.nombre = clave;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	/**
	 * Regresa una instancia de esta clase a partir de un identificador.
	 * @param id
	 * @return Una instancia de {@link} TipoBajaPadron
	 */
	public static TipoBajaPadron valueOf(int id) {
		for (TipoBajaPadron tipoBajaPadron : values()) {
			if (tipoBajaPadron.getId() == id) {
				return tipoBajaPadron;
			}
		}
		LOGGER.warn("Id inv�lido para obtener enum tipo baja" + id);
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
	 * @return el atributo nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre a actualizar
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
