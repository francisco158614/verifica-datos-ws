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
 * Catálogo que describe los diferentes estatus en los cuales se puede encontrar un ciudadano.
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoEstatusCiudadano {
	/**
	 * El ciudadano solo se encuentra en Padrón.
	 */
	PADRON(1, "EN PADRON", "EL CIUDADANO SE ENCUENTRA SOLO EN PADRON", true),
	/**
	 * el ciudadano se encuentra habilitado en la lista nominal de electores.
	 */
	LISTA_NOMINAL(2, "EN LISTA NOMINAL", "EL CIUDADANO SE ENCUENTRA EN LISTA NOMINAL", true),
	/**
	 * El ciudadano se encuentra dado de baja por alguna causa.
	 */
	BAJAS(3, "EN BAJAS", "EL CIUDADANO SE ENCUENTRA EN BAJAS", true),

	/**
	 * El ciudadano se encuentra dado de baja por haber intentado una usurpacion o por cambio
	 * de identidad
	 */
	BAJAS_EXCLUIDAS(
		4,
		"EN BAJAS EXCLUIDAS",
		"EL CIUDADANO HA SIDO EXCLUIDO POR INTENTO DE USURPACION Y POR INTENTO DE CAMBIO DE IDENTIDAD",
		true),
	
	NO_IDENTIFICADO(
			-1,
			"NO IDENTIFICADO",
			"NO IDENTIFICADO",
			true);
	

	private int id;

	private String nombre;

	private String descripcion;

	private boolean activo;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TipoEstatusCiudadano.class);

	/**
	 * Constructor
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param activo
	 */
	private TipoEstatusCiudadano(int id, String nombre, String descripcion, boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
	}

	/**
	 * Método el cual a partir de un id obtiene un enum {@link TipoEstatusCiudadano}
	 * @param id
	 * @return {@link TipoEstatusCiudadano}
	 */
	public static TipoEstatusCiudadano valueOf(int id) {
		for (TipoEstatusCiudadano tipoEstatusCiudadano : values()) {
			if (tipoEstatusCiudadano.getId() == id) {
				return tipoEstatusCiudadano;
			}
		}

		LOGGER.warn("id invalido para obtener enum TipoEstatusCiudadano: "
			+ id);
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
	 * @param nombre parametro clave a actualizar
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
