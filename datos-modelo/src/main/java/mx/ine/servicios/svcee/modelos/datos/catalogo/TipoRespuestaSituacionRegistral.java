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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 * Tipo de respuestas de la situacion registral de la credencial del ciudadano
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@XmlType(name = "tipoRespuestaSituacionRegistral")
@XmlEnum
public enum TipoRespuestaSituacionRegistral {

    /**
     * Catalogo tipo VIGENTE
     */
    VIGENTE(
        1,
        "ESTÁ VIGENTE TU CREDENCIAL",
        "TUS DATOS SE ENCUENTRAN EN EL PADRÓN ELECTORAL, Y TAMBIÉN EN LA LISTA NOMINAL DE ELECTORES.",
        true,
        true
        ),
    /**
     * Catalogo tipo NO_VIGENTE
     */
    NO_VIGENTE(
        2,
        "NO ESTÁ VIGENTE TU CREDENCIAL",
        "TU REGISTRO HA SIDO REINCORPORADO POR NOTIFICACIÓN DE UNA AUTORIDAD COMPETENTE AL PADRÓN ELECTORAL PERO NO ESTÁ EN LISTA NOMINAL DE ELECTORES. TRAMITA UNA NUEVA CREDENCIAL PARA VOTAR QUE SEA VIGENTE Y PUEDAS VOTAR.",
        true,
        false),
    /**
     * Catalogo RESIDENTE_EXTRANJERO
     */
    RESIDENTE_EXTRANJERO(
        3,
        "ESTÁ VIGENTE TU CREDENCIAL",
        "SÓLO PODRÁS EMITIR TU VOTO DESDE EL EXTRANJERO PARA PRESIDENTE DE LOS ESTADOS UNIDOS MEXICANOS, VÍA POSTAL.",
        true,
        true),
    /**
     * Catalogo RESECCIONAMIENTO
     */
    RESECCIONAMIENTO(4, "RE-SECCIONAMIENTO",
        "TU DOMICILIO DEJÓ DE PERTENECER A LA SECCIÓN ELECTORAL ", 
        true,
        true),
    /**
     * Catalogo REINCORPORADO
     */
    REINCORPORADO(
        5,
        "RE-INCORPORADO",
        "TU REGISTRO HA SIDO REINCORPORADO POR NOTIFICACIÓN DE UNA AUTORIDAD COMPETENTE AL PADRÓN ELECTORAL PERO NO ESTÁ EN LISTA NOMINAL DE ELECTORES. TRAMITA UNA NUEVA CREDENCIAL PARA VOTAR QUE SEA VIGENTE Y PUEDAS VOTAR.",
        true,
        false),
    /**
     * Catalogo OCR_DISTINTO
     */
    OCR_DISTINTO(
        6,
        "OCR DISTINTO A LA BASE DE DATOS",
        "EN CASO DE QUE TUS DATOS NO SE ENCUENTREN NUEVAMENTE ACUDE AL MÓDULO DE ATENCIÓN CIUDADANA PARA REGULARIZAR TU SITUACIÓN.",
        true,
        false),
    /**
     * Catalogo NUMERO_EMISION_DIFERENTE
     */
    NUMERO_EMISION_DIFERENTE(
        7,
        "NÚMERO DE EMISIÓN DIFERENTE",
        "¡ESTA NO ES TU ULTIMA CREDENCIAL!, REALIZASTE UN TRÁMITE DE ACTUALIZACIÓN DE DATOS, POR LO QUE TU CONSULTA FUE CON UNA CREDENCIAL ANTERIOR.",
        true,
        false),
    /**
     * Catalogo TRAMITE_EN_PROCESO
     */
    TRAMITE_EN_PROCESO(10, "TRÁMITE EN PROCESO", "¡NO CONCLUISTE TU TRÁMITE!", 
    	true,
    	false),
    /**
     * Catalogo CREDENCIAL_BAJA_PERDIDA_VIGENCIA
     */
    CREDENCIAL_BAJA_PERDIDA_VIGENCIA(11, "CREDENCIAL '03, 09, 12, ...",
        "¡TÚ CREDENCIAL FUE DADA DE BAJA POR PÉRDIDA DE VIGENCIA!", 
        true,
        false),

    /**
     * Catalogo DUPLICADO
     */
    DUPLICADO(
        12,
        "DUPLICADO",
        "¡EXISTE OTRO REGISTRO A TU NOMBRE!, QUE FUE IDENTIFICADO POR EL PROGRAMA DE DETECCIÓN DE DUPLICADOS, POR LO QUE LA CREDENCIAL QUE ESTAS CONSULTANDO CORRESPONDE A UN REGISTRO DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.(FUNDAMENTO LEGAL)",
        true,
        false),
    /**
     * Catalogo DEFUNCION
     */
    DEFUNCION(
        13,
        "DEFUNCIÓN",
        "POR DEFUNCIÓN ESTE REGISTRO FUE DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.(FUNDAMENTO LEGAL)",
        true,
        false),
    /**
     * Catalogo SUSPENSION_DE_DERECHOS
     */
    SUSPENSION_DE_DERECHOS(
        14,
        "SUSPENSIÓN DERECHOS POLÍTICOS",
        "POR SUSPENSIÓN DE DERECHOS, TU REGISTRO FUE DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES (FUNDAMENTO LEGAL)",
        true,
        false),
    /**
     * Catalogo CANCELACION_DE_TRAMITE
     */
    CANCELACION_DE_TRAMITE(
        15,
        "CANCELACIÓN DE TRÁMITE",
        "¡NO RECOGISTE TU NUEVA CREDENCIAL EN EL PLAZO ESTABLECIDO! Y TU REGISTRO FUE DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.(FUNDAMENTOS LEGALES)",
        true,
        false),
    /**
     * Catalogo PERDIDADA_DE_NACIONALIDAD
     */
    PERDIDADA_DE_NACIONALIDAD(
        16,
        "PÉRDIDA DE NACIONALIDAD",
        "POR PERDIDA DE CIUDADANÍA O POR HABER RENUNCIADO A LA NACIONALIDAD, TU REGISTRO FUE DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.(FUNDAMENTO LEGAL)",
        true,
        false),
    /**
     * Catalogo DATOS_IRREGULARES
     */
    DATOS_IRREGULARES(
        17,
        "DATOS IRREGULARES",
        "¡TÚ REGISTRO PRESENTA DATOS IRREGULARES! POR LO QUE FUE DADO DE BAJA DEL PADRÓN ELECTORAL Y EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES. (FUNDAMENTO LEGAL)",
        true,
        false),
    /**
     * Catalogo ROBADA_AL_INSTITUTO
     */
    ROBADA_AL_INSTITUTO(
        18,
        "ROBADA AL INSTITUTO",
        "¡ESTA CREDENCIAL ESTA REPORTADA COMO ROBADA O EXTRAVIADA! POR LO QUE ESTE REGISTRO NO SE ENCUENTRA EN EL PADRÓN ELECTORAL Y HA SIDO EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES",
        true,
        false),
    /**
     * Catalogo REPORTE_DE_ROBO PERMANENTE
     */
    REPORTE_DE_ROBO(
        19,
        "CON REPORTE PERMANENTE DE ROBO AL CIUDADANO",
        "¡ESTA CREDENCIAL FUE REPORTADA COMO ROBADA! POR LO QUE ESTE REGISTRO NO SE ENCUENTRA EN EL PADRÓN ELECTORAL Y HA SIDO EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.",
        true,
        false),
    /**
     * Catalogo REPORTE_DE_EXTRAVIO PERMANENTE
     */
    REPORTE_DE_EXTRAVIO(
        20,
        "REPORTE PERMANENTE EXTRAVÍO AL CIUDADANO",
        "¡ESTA CREDENCIAL FUE REPORTADA COMO EXTRAVIADA! POR LO QUE ESTE REGISTRO NO SE ENCUENTRA EN EL PADRÓN ELECTORAL Y HA SIDO EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.",
        true,
        false),
    /**
     * Catalogo DATOS_NO_ENCONTRADOS
     */
    DATOS_NO_ENCONTRADOS(
        21,
        "DATOS NO ENCONTRADOS",
        "EN CASO DE QUE TUS DATOS NO SE ENCUENTREN NUEVAMENTE ACUDE AL MÓDULO DE ATENCIÓN CIUDADANA PARA REGULARIZAR TU SITUACIÓN.",
        true,
        false),
    /**
     * Catalogo CAMBIO_CLAVE_ELECTOR
     */
    CAMBIO_CLAVE_ELECTOR(
        22,
        "CAMBIO DE CLAVE DE ELECTOR",
        "¡NO ES TU ÚLTIMO TRÁMITE! REALIZASTE UN NUEVO TRÁMITE CON CORRECCIÓN DE DATOS EN EL MÓDULO DEL INE  ",
        true,
        false),
    /**
     * Catalogo RESULTADO_VARIOS_REGISTROS
     */
    RESULTADO_VARIOS_REGISTROS(23, "RESULTADO CON MAS DE UN REGISTRO",
        "SE OBTIENE MAS DE UN REGISTRO COMO RESPUESTA", 
        true,
        false),
    /**
     * Catalogo USURPACION
     */
    USURPACION(24, "USURPACION", "TU CREDENCIAL FUE DADA DE BAJA POR USURPACIÓN!", 
    	true,
    	false),
    /**
     * Catalogo REPORTE_DE_ROBO TEMPORAL
     */
    REPORTE_DE_ROBO_TEMPORAL(
        25,
        "REPORTE_DE_ROBO_TEMPORAL",
        "¡ESTA CREDENCIAL FUE REPORTADA COMO ROBADA! POR LO QUE ESTE REGISTRO NO SE ENCUENTRA EN EL PADRÓN ELECTORAL Y HA SIDO EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.",
        true,
        true),
    /**
     * Catalogo REPORTE_DE_EXTRAVIO TEMPORAL
     */
    REPORTE_DE_EXTRAVIO_TEMPORAL(
        26,
        "REPORTE_DE_EXTRAVIO_TEMPORAL",
        "¡ESTA CREDENCIAL FUE REPORTADA COMO EXTRAVIADA! POR LO QUE ESTE REGISTRO NO SE ENCUENTRA EN EL PADRÓN ELECTORAL Y HA SIDO EXCLUIDO DE LA LISTA NOMINAL DE ELECTORES.",
        true,
        true),
    /**
     * Catalogo REPORTE_DE_ROBO CANCELADO
     */
    REPORTE_DE_ROBO_CANCELADO(
        27,
        "REPORTE_DE_ROBO_CANCELADO",
        "EL REPORTE DE ROBO DE TU CREDENCIAL FUE CANCELADO POR EL INSTITUTO DEBIDO A QUE NO SE REALIZÓ UN NUEVO TRÁMITE EN EL MÓDULO DE ATENCIÓN CIUDADANA DENTRO DE LOS 30 DÍAS NATURALES POSTERIORES AL LEVANTAMIENTO DE DICHO REPORTE",
        true,
        true),
    /**
     * Catalogo REPORTE_DE_EXTRAVIO CANCELADO
     */
    REPORTE_DE_EXTRAVIO_CANCELADO(
        28,
        "REPORTE_DE_EXTRAVIO_CANCELADO",
        "EL REPORTE DE EXTRAVÍO DE TU CREDENCIAL FUE CANCELADO POR EL INSTITUTO DEBIDO A QUE NO SE REALIZÓ UN NUEVO TRÁMITE EN EL MÓDULO DE ATENCIÓN CIUDADANA DENTRO DE LOS 30 DÍAS NATURALES POSTERIORES AL LEVANTAMIENTO DE DICHO REPORTE",
        true,
        true),
    /**
     * Catalogo REPORTE_DE_ROBO TEMPORAL_CONSULTA POR FOLIO
     */
   
    REPORTE_DE_ROBO_TEMPORAL_FOLIO(
    	29,
    	"REPORTE_DE_ROBO_TEMPORAL_FOLIO",
        "¡Esta credencial fue reportada como robada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
        true,
        true),
        
    /**
     * Catalogo REPORTE_DE_ROBO_CONSULTA POR FOLIO
     */
       
    REPORTE_DE_ROBO_FOLIO(
       	30,
        "REPORTE_DE_ROBO_FOLIO",
        "¡Esta credencial fue reportada como robada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
        true,
        false),
        

     /**
      * Catalogo REPORTE_DE_ROBO CANCELADO_FOLIO CONSULTA POR FOLIO
      */
    REPORTE_DE_ROBO_CANCELADO_FOLIO(
        31,
        "REPORTE_DE_ROBO_CANCELADO_FOLIO",
        "¡Esta credencial fue reportada como robada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
        true,
        true),
        
     /**
      * Catalogo REPORTE_DE_EXTRAVIO_TEMPORAL_FOLIO  CONSULTA POR FOLIO
      */
    REPORTE_DE_EXTRAVIO_TEMPORAL_FOLIO(
        32,
        "REPORTE_DE_EXTRAVIO_TEMPORAL_FOLIO",
        "¡Esta credencial fue reportada como extraviada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
        true,
        true),
        
     /**
      * Catalogo REPORTE_DE_EXTRAVIO_PERMANENTE_FOLIO  CONSULTA POR FOLIO
      */
     REPORTE_DE_EXTRAVIO_FOLIO(
        33,
        "REPORTE_DE_EXTRAVIO_FOLIO",
        "¡Esta credencial fue reportada como extraviada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
        true,
        false),
        
     /**
      * Catalogo REPORTE_DE_EXTRAVIO_CANCELADO_FOLIO CONSULTA POR FOLIO
      */
     REPORTE_DE_EXTRAVIO_CANCELADO_FOLIO(
       34,
       "REPORTE_DE_EXTRAVIO_CANCELADO_FOLIO",
       "¡Esta credencial fue reportada como extraviada! Por lo que este registro no se encuentra en el Padrón Electoral y ha sido excluido de la Lista Nominal de Electores.",
       true,
       true),
       
     /**
      * Catalogo NO_VIGENTE_EXTRANJERO EL CIUDADANO NO HA ACTIVADO SU CPV EN EL EXTRANJERO
      */
     ACTIVA_EXTRANJERO(
      35,
      "ACTIVA_EXTRANJERO",
      "No está vigente como medio de identificación, no puedes votar, tramitaste tu credencial en el extranjero y necesitas activarla para que sea vigente y así poder votar.",
      true,
      false),
      
      /**
       * Catalogo REINCORPORACION_EXTRANJERO EL CIUDADANO NO HA ACTIVADO SU CPV EN EL EXTRANJERO Y ES REINCORPORADO AL PADRÓN
       */
      REINCORPORACION_EXTRANJERO(
       36,
       "REINCORPORACION_EXTRANJERO",
       "tu registro ha sido reincorporado por notificación de una autoridad competente al padrón electoral pero no está en lista nominal de electores. tramitaste tu credencial en el extranjero y necesitas activarla para que sea vigente y así poder votar.",
       true,
       false),
       
       /**
        * Catalogo Tipo de Baja 6 CAMBIO_DE_DOMICILIO
        */
      CAMBIO_DE_DOMICILIO(
        37,
        "CAMBIO DE DOMICILIO",
        "CAMBIO DE DOMICILIO",
        true,
        false),
        
        /**
         * Catalogo Tipo de Baja 7 MENORES_DE_EDAD
         */
       MENORES_DE_EDAD(
         38,
         "MENORES DE EDAD",
         "MENORES DE EDAD",
         true,
         false),
         
         /**
          * Catalogo Tipo de Baja 8 MIGRACION
          */
        MIGRACION(
          39,
          "MIGRACION",
          "MIGRACION",
          true,
          false)
     
      ;
    
        
        
        

    private int id;
    private String nombre;
    private String descripcion;
    private boolean activo;
    private boolean vigente;

    /**
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    private TipoRespuestaSituacionRegistral(int id, String clave, String descripcion,
        boolean activo, boolean vigente) {
        this.id = id;
        this.nombre = clave;
        this.descripcion = descripcion;
        this.activo = activo;
        this.vigente = vigente;
    }

    /**
     * Metodo en el cual a partir de un id obtiene el enum
     * {@link tipoRespuestaSituacionRegistral} asociado
     * @param id Identificador a buscar
     * @return {@link tipoRespuestaSituacionRegistral}
     */
    public static TipoRespuestaSituacionRegistral valueOf(int id) {

        for (TipoRespuestaSituacionRegistral tipoRespuestaSituacionRegistral : values()) {
            if (tipoRespuestaSituacionRegistral.getId() == id) {
                return tipoRespuestaSituacionRegistral;
            }
        }

        throw new IllegalArgumentException(
            "id invalido para obtener enum tipoRespuestaSituacionRegistral: " + id);
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

	/**
	 * @return the vigente
	 */
	public boolean isVigente() {
		return vigente;
	}


    
}
