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
package mx.ine.servicios.svcee.modelos.datos.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import mx.ine.servicios.svcee.modelos.datos.catalogo.Entidad;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoBajaPadron;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoCausaRoboExtravio;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoEstatusCiudadano;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoEstatusRoboExtravio;
import mx.ine.servicios.svcee.modelos.datos.catalogo.TipoReincorporacionPadron;

public class DatosCiudadano implements Serializable {
	
    private static final long serialVersionUID = 8272533235887120440L;
    @JsonProperty("_id") 
    private Long ciudadanoId;
    
    @JsonProperty("credencial_id")
    private Long credencialId;
    
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
    
    @JsonProperty("curp")
    private String curp;
    
    @JsonProperty("nombre")
    private String nombre;
    
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    
    /**
     * fecha en cadena formato yyyy-MM-dd
     */
    @JsonProperty("fecha_inscripcion_padron")
    private String fechaInscripcionPadron;
    /**
     * fecha en cadena formato yyyy-MM-dd
     */
    @JsonProperty("fecha_ultimo_tramite")
    private String fechaUltimoTramite;
    /**
     * fecha en cadena formato yyyy-MM-dd
     */
    @JsonProperty("fecha_vigencia_credencial")
    private String fechaVigenciaCredencial;
    /**
     * fecha en cadena formato yyyy-MM-dd
     */
    @JsonProperty("fecha_creacion")
    private String fechaCreacionCredencial;
    /**
     * fecha en cadena formato yyyy-MM-dd
     */
    @JsonProperty("fecha_baja")
    private String fechaBaja;
    
    @JsonProperty("fecha_actualizacion_ln")    
    private String  fechaActualizacionLN;
    
   /**
    * validado, en hbase se guarda como cadena 1= true 0 = false 
    */
    @JsonProperty("residente_extranjero")
    private Boolean residenteExtrajero;
    
    @JsonProperty("estatusextranjero")
    private Integer estatusExtranjero;
    
    /**
     * validado, en hbase se guarda el identificador de la entidad como cadena  
     */
    private Entidad entidad;
    

    /**
     * validado, en hbase se guarda el identificador de la entidad como cadena  
     */
    @JsonProperty("entidad_id")
    private Integer entidad_id;
    
    
    /**
     * 
     */
    @JsonProperty("seccion")
    private String seccion;
    /**
     * en hbase se guarda como cadena
     */
    @JsonProperty("distrito_id")
    private Integer distrito;
    /**
     * en hbase se guarda como cadena
     */
    @JsonProperty("municipio_id")
    private Integer municipio;
    
    /**
     * en hbase se guarda el identificador de la enum en cadena
     */
    private TipoReincorporacionPadron tipoReincorporacionPadron;
    
    @JsonProperty("tipo_reincorporacion_padron_id")
    private Integer tipoReincorporacionPadron_id;
    
    //estatusciudadano_id
    
    /**
     * en hbase se guarda el identificador de la enum en cadena
     */
    private TipoEstatusCiudadano tipoEstatusCiudadano;
    
    @JsonProperty("estatusciudadano_id")
    private Integer tipoEstatusCiudadano_id;
    
   
    private TipoBajaPadron tipoBajaPadron;
    
    @JsonProperty("tipo_bajapadron_id")
    private Integer tipoBajaPadron_id;
    /**
     * En hbase se guarda como cadena
     */
    @JsonProperty("reporteroboextravio_id")
    private Long numeroReporteRoboExtravio;
    
    /**
     * en hbase se guarda el identificador de la enum en cadena
     */
    
    private TipoEstatusRoboExtravio tipoEstatusRoboExtravio;
    
    @JsonProperty("estatus_roboetravio_id")
    private Integer tipoEstatusRoboExtravio_id;
    
    /**
     * en hbase se guarda el identificador de la enum en cadena
     */
    private TipoCausaRoboExtravio tipoCausaRoboExtravio;
    
    @JsonProperty("causa_roboextravio_id")
    private Integer tipoCausaRoboExtravio_id;
    
    /**
     * Bandera que indica que el ciudadano indico que no quiere que sus datos sean utilizados por el sistema
     */
    @JsonProperty("estatus_arco")
    private Boolean estatusArco;
    
    /**
     * bandera que activada en true implica que aunque este dado de baja por suspension de derechos, su
     * credencial es vigente como medio de identificación.
     */
    @JsonProperty("suspension_derechos")
    private Boolean suspensionDerechos;
    
    /**
     * bandera auxiliar que identifica una credencial anterior. <code>true</code> en caso de que no sea la ultima credencial.
     */
    private boolean auxCredencialAnt;
    
    /**
     * Bandera auxiliar que se activa cuando tiene un reporte de robo/extravio permanente.
     */
    private boolean auxConReporteRoboExtr;
    
    /**
     * Identificador de la foto para buscar en el CEPH
     */
    @JsonProperty("fotografia_id")
    private String fotoId;
    
    /**
     * Identificador de las huellas para buscar en el CEPH
     */
    @JsonProperty("huellas_id")
    private  String huellasId;
    
    
    
    
	/**
	 * @return the auxConReporteRoboExtr
	 */
	public boolean isAuxConReporteRoboExtr() {
		return auxConReporteRoboExtr;
	}

	/**
	 * @param auxConReporteRoboExtr the auxConReporteRoboExtr to set
	 */
	public void setAuxConReporteRoboExtr(boolean auxConReporteRoboExtr) {
		this.auxConReporteRoboExtr = auxConReporteRoboExtr;
	}

	
    public Long getCiudadanoId() {
		return ciudadanoId;
	}

	public void setCiudadanoId(Long ciudadanoId) {
		this.ciudadanoId = ciudadanoId;
	}

	/**
     * @return el atributo credencialId
     */
    public Long getCredencialId() {
        return credencialId;
    }

    /**
     * @param credencialId parametro credencialdatosCiudadanoId a actualizar
     */
    public void setCredencialId(Long credencialId) {
        this.credencialId = credencialId;
    }
    

    /**
     * @return el atributo claveElector
     */
    public String getClaveElector() {
        return claveElector;
    }

    /**
     * @param claveElector parametro claveElector a actualizar
     */
    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    /**
     * @return el atributo ocr
     */
    public String getOcr() {
        return ocr;
    }

    /**
     * @param ocr parametro ocr a actualizar
     */
    public void setOcr(String ocr) {
        this.ocr = ocr;
    }

    /**
     * @return el atributo cic
     */
    public Long getCic() {
        return cic;
    }

    /**
     * @param cic parametro cic a actualizar
     */
    public void setCic(Long cic) {
        this.cic = cic;
    }

    /**
     * @return el atributo curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp parametro curp a actualizar
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }
    
    
    
    /**
     * @return el atributo numeroEmisionCredencial
     */
    public Integer getNumeroEmisionCredencial() {
        return numeroEmisionCredencial;
    }

    /**
     * @param numeroEmisionCredencial parametro numeroEmisionCredencial a actualizar
     */
    public void setNumeroEmisionCredencial(Integer numeroEmisionCredencial) {
        this.numeroEmisionCredencial = numeroEmisionCredencial;
    }
    
    
    

    /**
     * @return el atributo nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre parametro nombre a actualizar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return el atributo apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno parametro apellidoPaterno a actualizar
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return el atributo apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno parametro apellidoMaterno a actualizar
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return el atributo fechaInscripcionPadron
     */
    public String getFechaInscripcionPadron() {
        return fechaInscripcionPadron;
    }

    /**
     * @param fechaInscripcionPadron parametro fechaInscripcionPadron a actualizar
     */
    public void setFechaInscripcionPadron(String fechaInscripcionPadron) {
        this.fechaInscripcionPadron = fechaInscripcionPadron;
    }

    /**
     * @return el atributo fechaUltimoTramite
     */
    public String getFechaUltimoTramite() {
        return fechaUltimoTramite;
    }

    /**
     * @param fechaUltimoTramite parametro fechaUltimoTramite a actualizar
     */
    public void setFechaUltimoTramite(String fechaUltimoTramite) {
        this.fechaUltimoTramite = fechaUltimoTramite;
    }

    /**
     * @return el atributo fechaVigenciaCredencial
     */
    public String getFechaVigenciaCredencial() {
        return fechaVigenciaCredencial;
    }

    /**
     * @param fechaVigenciaCredencial parametro fechaVigenciaCredencial a actualizar
     */
    public void setFechaVigenciaCredencial(String fechaVigenciaCredencial) {
        this.fechaVigenciaCredencial = fechaVigenciaCredencial;
    }

    /**
     * @return el atributo fechaCreacionCredencial
     */
    public String getFechaCreacionCredencial() {
        return fechaCreacionCredencial;
    }

    /**
     * @param fechaCreacionCredencial parametro fechaCreacionCredencial a actualizar
     */
    public void setFechaCreacionCredencial(String fechaCreacionCredencial) {
        this.fechaCreacionCredencial = fechaCreacionCredencial;
    }

    /**
	 * @return the fechaBaja
	 */
	public String getFechaBaja() {
		return fechaBaja;
	}

	/**
	 * @param fechaBaja the fechaBaja to set
	 */
	public void setFechaBaja(String fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	
	
	public String getFechaActualizacionLN() {
		return fechaActualizacionLN;
	}

	public void setFechaActualizacionLN(String fechaActualizacionLN) {
		this.fechaActualizacionLN = fechaActualizacionLN;
	}

	/**
     * @return el atributo residenteExtrajero
     */
    public Boolean getResidenteExtrajero() {
        return residenteExtrajero;
    }

    /**
     * @param residenteExtrajero parametro residenteExtrajero a actualizar
     */
    public void setResidenteExtrajero(Boolean residenteExtrajero) {
        this.residenteExtrajero = residenteExtrajero;
    }

        
    public Integer getEstatusExtranjero() {
		return estatusExtranjero;
	}

	public void setEstatusExtranjero(Integer estatusExtranjero) {
		this.estatusExtranjero = estatusExtranjero;
	}

	/**
     * @return el atributo entidad
     */
    public Entidad getEntidad() {    	
        return entidad;
    }

    /**
     * @param entidad parametro entidad a actualizar
     */
    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    /**
     * @return el atributo seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion parametro seccion a actualizar
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
	 * @return the distrito
	 */
	public Integer getDistrito() {
		return distrito;
	}

	/**
	 * @param distrito the distrito to set
	 */
	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}

	/**
	 * @return the municipio
	 */
	public Integer getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(Integer municipio) {
		this.municipio = municipio;
	}

	/**
     * @return el atributo tipoReincorporacionPadron
     */
    public TipoReincorporacionPadron getTipoReincorporacionPadron() {
        return tipoReincorporacionPadron;
    }

    /**
     * @param tipoReincorporacionPadron parametro tipoReincorporacionPadron a actualizar
     */
    public void setTipoReincorporacionPadron(
        TipoReincorporacionPadron tipoReincorporacionPadron) {
        this.tipoReincorporacionPadron = tipoReincorporacionPadron;
    }

    /**
     * @return el atributo tipoEstatusCiudadano
     */
    public TipoEstatusCiudadano getTipoEstatusCiudadano() {
        return tipoEstatusCiudadano;
    }

    /**
     * @param tipoEstatusCiudadano parametro tipoEstatusCiudadano a actualizar
     */
    public void setTipoEstatusCiudadano(TipoEstatusCiudadano tipoEstatusCiudadano) {
        this.tipoEstatusCiudadano = tipoEstatusCiudadano;
    }

    /**
     * @return el atributo tipoBajaPadron
     */
    public TipoBajaPadron getTipoBajaPadron() {
        return tipoBajaPadron;
    }

    /**
     * @param tipoBajaPadron parametro tipoBajaPadron a actualizar
     */
    public void setTipoBajaPadron(TipoBajaPadron tipoBajaPadron) {
        this.tipoBajaPadron = tipoBajaPadron;
    }

    /**
     * @return el atributo numeroReporteRoboExtravio
     */
    public Long getNumeroReporteRoboExtravio() {
        return numeroReporteRoboExtravio;
    }

    /**
     * @param numeroReporteRoboExtravio parametro numeroReporteRoboExtravio 
     */
    public void setNumeroReporteRoboExtravio(Long numeroReporteRoboExtravio) {
        this.numeroReporteRoboExtravio = numeroReporteRoboExtravio;
    }

    /**
     * @return el atributo tipoEstatusRoboExtravio
     */
    public TipoEstatusRoboExtravio getTipoEstatusRoboExtravio() {
        return tipoEstatusRoboExtravio;
    }

    /**
     * @param tipoEstatusRoboExtravio parametro tipoEstatusRoboExtravio a actualizar
     */
    public void setTipoEstatusRoboExtravio(TipoEstatusRoboExtravio tipoEstatusRoboExtravio) {
        this.tipoEstatusRoboExtravio = tipoEstatusRoboExtravio;
    }

    /**
     * @return el atributo tipoCausaRoboExtravio
     */
    public TipoCausaRoboExtravio getTipoCausaRoboExtravio() {
        return tipoCausaRoboExtravio;
    }

    /**
     * @param tipoCausaRoboExtravio parametro tipoCausaRoboExtravio a actualizar
     */
    public void setTipoCausaRoboExtravio(TipoCausaRoboExtravio tipoCausaRoboExtravio) {
        this.tipoCausaRoboExtravio = tipoCausaRoboExtravio;
    }

	/**
	 * @return the estatusArco
	 */
	public Boolean getEstatusArco() {
		return estatusArco;
	}

	/**
	 * @param estatusArco the estatusArco to set
	 */
	public void setEstatusArco(Boolean estatusArco) {
		this.estatusArco = estatusArco;
	}

	public Boolean getSuspensionDerechos() {
		return suspensionDerechos;
	}

	public void setSuspensionDerechos(Boolean suspensionDerechos) {
		this.suspensionDerechos = suspensionDerechos;
	}

	/**
	 * @return the auxCredencialAnt
	 */
	public boolean getAuxCredencialAnt() {
		return auxCredencialAnt;
	}

	/**
	 * @param auxCredencialAnt the auxCredencialAnt to set
	 */
	public void setAuxCredencialAnt(boolean auxCredencialAnt) {
		this.auxCredencialAnt = auxCredencialAnt;
	}

	/**
	 * @return the fotoId
	 */
	public String getFotoId() {
		return fotoId;
	}

	/**
	 * @param fotoId the fotoId to set
	 */
	public void setFotoId(String fotoId) {
		this.fotoId = fotoId;
	}

	/**
	 * @return the huellasId
	 */
	public String getHuellasId() {
		return huellasId;
	}

	/**
	 * @param huellasId the huellasId to set
	 */
	public void setHuellasId(String huellasId) {
		this.huellasId = huellasId;
	}
	
	
	
	

	public Integer getEntidad_id() {
		return entidad_id;
	}

	public void setEntidad_id(Integer entidad_id) {
		this.entidad_id = entidad_id;
		if(entidad_id!=null) {
			setEntidad(Entidad.valueOf(entidad_id));
		}
	}

	public Integer getTipoReincorporacionPadron_id() {
		return tipoReincorporacionPadron_id;
	}

	public void setTipoReincorporacionPadron_id(Integer tipoReincorporacionPadron_id) {
		this.tipoReincorporacionPadron_id = tipoReincorporacionPadron_id;
		if(tipoReincorporacionPadron_id!=null) {
			setTipoReincorporacionPadron(TipoReincorporacionPadron.valueOf(tipoReincorporacionPadron_id));
		}
	}

	public Integer getTipoEstatusCiudadano_id() {
		return tipoEstatusCiudadano_id;
	}

	public void setTipoEstatusCiudadano_id(Integer tipoEstatusCiudadano_id) {
		this.tipoEstatusCiudadano_id = tipoEstatusCiudadano_id;
		if(tipoEstatusCiudadano_id!=null) {
			setTipoEstatusCiudadano(TipoEstatusCiudadano.valueOf(tipoEstatusCiudadano_id));
		}
	}

	public Integer getTipoBajaPadron_id() {
		return tipoBajaPadron_id;
	}

	public void setTipoBajaPadron_id(Integer tipoBajaPadron_id) {
		this.tipoBajaPadron_id = tipoBajaPadron_id;
		if(tipoBajaPadron_id!=null) {
			setTipoBajaPadron(TipoBajaPadron.valueOf(tipoBajaPadron_id));
		}
	}

	public Integer getTipoEstatusRoboExtravio_id() {
		return tipoEstatusRoboExtravio_id;
	}

	public void setTipoEstatusRoboExtravio_id(Integer tipoEstatusRoboExtravio_id) {
		this.tipoEstatusRoboExtravio_id = tipoEstatusRoboExtravio_id;
		if(tipoEstatusRoboExtravio_id!=null) {
			setTipoEstatusRoboExtravio(TipoEstatusRoboExtravio.valueOf(tipoEstatusRoboExtravio_id));
		}
	}

	public Integer getTipoCausaRoboExtravio_id() {
		return tipoCausaRoboExtravio_id;
	}

	public void setTipoCausaRoboExtravio_id(Integer tipoCausaRoboExtravio_id) {
		this.tipoCausaRoboExtravio_id = tipoCausaRoboExtravio_id;
		if(tipoCausaRoboExtravio_id!=null) {
			setTipoCausaRoboExtravio(TipoCausaRoboExtravio.valueOf(tipoCausaRoboExtravio_id));
		}
	}


    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "DatosCiudadano [ciudadanoId=" + ciudadanoId + ", credencialId=" + credencialId
            + ", claveElector=" + claveElector + ", numeroEmisionCredencial="
            + numeroEmisionCredencial + ", ocr=" + ocr + ", cic=" + cic + ", curp=" + curp
            + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
            + ", apellidoMaterno=" + apellidoMaterno + ", fechaInscripcionPadron="
            + fechaInscripcionPadron + ", fechaUltimoTramite=" + fechaUltimoTramite
            + ", fechaVigenciaCredencial=" + fechaVigenciaCredencial
            + ", fechaCreacionCredencial=" + fechaCreacionCredencial + ", residenteExtrajero="
            + residenteExtrajero + ", entidad=" + entidad + ", seccion=" + seccion
            + ", tipoReincorporacionPadron=" + tipoReincorporacionPadron
            + ", tipoEstatusCiudadano=" + tipoEstatusCiudadano + ", tipoBajaPadron="
            + tipoBajaPadron + ", numeroReporteRoboExtravio=" + numeroReporteRoboExtravio
            + ", tipoEstatusRoboExtravio=" + tipoEstatusRoboExtravio
            + ", tipoCausaRoboExtravio=" + tipoCausaRoboExtravio + "]";
    }

	
	
	
}
