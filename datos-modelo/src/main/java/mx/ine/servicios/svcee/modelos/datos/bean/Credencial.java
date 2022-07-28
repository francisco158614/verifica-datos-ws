/**
 * Fecha de creación: 2021
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
package mx.ine.servicios.svcee.modelos.datos.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credencial implements Serializable {
	
    private static final long serialVersionUID = 8272533235887120440L;
    @JsonProperty("_id")
    private Long credencialId;
    
    @JsonProperty("ciudadano_id")
    private Long ciudadanoId;
    
    @JsonProperty("clave_elector")
    private String claveElector;
    /**
     * validado, en hbase se guarda como cadena
     */
    @JsonProperty("num_emision_credencial")
    private Integer numeroEmisionCredencial;
    
    @JsonProperty("ocr")
    private String ocr;
    
    @JsonProperty("cic")
    private Long cic;
    
    @JsonProperty("numero_reporte_roboetravio")
   private Long numeroReporteRoboExtravio;

    
    
	public Long getCredencialId() {
		return credencialId;
	}

	public void setCredencialId(Long credencialId) {
		this.credencialId = credencialId;
	}

	public Long getCiudadanoId() {
		return ciudadanoId;
	}

	public void setCiudadanoId(Long ciudadanoId) {
		this.ciudadanoId = ciudadanoId;
	}

	public String getClaveElector() {
		return claveElector;
	}

	public void setClaveElector(String claveElector) {
		this.claveElector = claveElector;
	}

	public Integer getNumeroEmisionCredencial() {
		return numeroEmisionCredencial;
	}

	public void setNumeroEmisionCredencial(Integer numeroEmisionCredencial) {
		this.numeroEmisionCredencial = numeroEmisionCredencial;
	}

	public String getOcr() {
		return ocr;
	}

	public void setOcr(String ocr) {
		this.ocr = ocr;
	}

	public Long getCic() {
		return cic;
	}

	public void setCic(Long cic) {
		this.cic = cic;
	}

	public Long getNumeroReporteRoboExtravio() {
		return numeroReporteRoboExtravio;
	}

	public void setNumeroReporteRoboExtravio(Long numeroReporteRoboExtravio) {
		this.numeroReporteRoboExtravio = numeroReporteRoboExtravio;
	}

	   
}