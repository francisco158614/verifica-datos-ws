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
package mx.ine.servicios.svcee.modelos.datos.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoRespuestaSituacionRegistral;

/**
 * @author Andres Lopez (andres.lopez@ine.mx)
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "tipoSituacionRegistral",
    "tipoReporteRoboExtravio"
})
@XmlRootElement(name = "RespuestaSituacionRegistralExterna")
public class RespuestaSituacionRegistralExterna implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4257281130356965836L;
	/**
	 * Situaci�n registral del ciudadano.
	 */
	private TipoRespuestaSituacionRegistral tipoSituacionRegistral;
	/**
	 * Reporte de robo o extravio:
	 */
	private TipoRespuestaSituacionRegistral tipoReporteRoboExtravio;


	/**
	 * @return el atributo tipoSituacionRegistral
	 */
	public TipoRespuestaSituacionRegistral getTipoSituacionRegistral() {
		return tipoSituacionRegistral;
	}
	/**
	 * @param tipoSituacionRegistral parametro tipoSituacionRegistral a actualizar
	 */
	public void setTipoSituacionRegistral(
			TipoRespuestaSituacionRegistral tipoSituacionRegistral) {
		this.tipoSituacionRegistral = tipoSituacionRegistral;
	}
	/**
	 * @return el atributo tipoReporteRoboOExtravio
	 */
	public TipoRespuestaSituacionRegistral getTipoReporteRoboExtravio() {
		return tipoReporteRoboExtravio;
	}
	/**
	 * @param tipoReporteRoboOExtravio parametro tipoReporteRoboOExtravio a actualizar
	 */
	public void setTipoReporteRoboExtravio(
			TipoRespuestaSituacionRegistral tipoReporteRoboOExtravio) {
		this.tipoReporteRoboExtravio = tipoReporteRoboOExtravio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String cadena="";
		if(tipoSituacionRegistral!=null){				
			cadena+=tipoSituacionRegistral.toString() ;
		}
		if (tipoReporteRoboExtravio!=null) {
			cadena+=tipoReporteRoboExtravio.toString() ;
		}

		return cadena;
	}
}
