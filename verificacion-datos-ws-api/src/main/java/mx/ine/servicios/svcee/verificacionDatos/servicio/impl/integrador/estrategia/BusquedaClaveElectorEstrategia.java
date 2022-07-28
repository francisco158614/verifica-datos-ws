/**
 * BusquedaClaveElectorEstrategia.java
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
*/
package mx.ine.servicios.svcee.verificacionDatos.servicio.impl.integrador.estrategia;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import mx.ine.servicios.svcee.modelos.datos.bean.Credencial;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;
import mx.ine.servicios.svcee.verificacionDatos.dao.CiudadanoDAO;
import mx.ine.servicios.svcee.verificacionDatos.dao.CredencialDAO;
import mx.ine.servicios.svcee.verificacionDatos.servicio.integrador.BusquedaEstrategia;

/**
 * Realiza validaciones y busqueda de los datos
 * @author INE
 * @version 1.0
 * @since SIIRFE 5.1
 */
@Service("busquedaClaveElectorEstrategia")
public class BusquedaClaveElectorEstrategia implements BusquedaEstrategia {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaClaveElectorEstrategia.class);

	/**
	 * Servicio para los datos
	 */
    @Resource
    private CredencialDAO credencialDAO;
    @Resource
    private CiudadanoDAO ciudadanoDAO;

    /**
     * Realiza validaciones de los datos obligatorios, longitudes y otras reglas de negocio
     * @param datosEntrada
     */
    @Override
    public boolean valida(DatosEntrada datosEntrada) {
       return  validaDatosObligatorios(obtenOCR(datosEntrada), obtenClaveElector(datosEntrada), obtenNumeroEmision(datosEntrada));
    }
    /**
     * Realiza la busqueda de la credencial con los datos requeridos por la estrategia
     * @param datosEntrada
     * @return List<DatosCiudadano>
     * @throws Exception
     */
    @Override
    public List<DatosCiudadano> busca(DatosEntrada datosEntrada)throws Exception {
        String ocr = obtenOCR(datosEntrada);
        String claveElector = obtenClaveElector(datosEntrada);
        Integer numeroEmisionCredencial = obtenNumeroEmision(datosEntrada);
        DatosCiudadano filtro = new DatosCiudadano();
        List<Credencial> credenciales = null;
        List<DatosCiudadano> datosCiudadanos = new ArrayList<>();
        
        filtro.setOcr(ocr);
        filtro.setClaveElector(claveElector);
        filtro.setNumeroEmisionCredencial(numeroEmisionCredencial);
        credenciales = credencialDAO.buscaPorClave(filtro);    
        
        for(Credencial credencial:credenciales) {
        	DatosCiudadano ciudadano=ciudadanoDAO.busca(credencial.getCiudadanoId());
        	if(ciudadano!=null) {
        		datosCiudadanos.add(ciudadano);
        	}
        }
        
        if (datosCiudadanos.size() == 0) {
        	LOGGER.warn("[VERIFICA-DATOS-WS-ERROR]busca,credenciales:"+datosCiudadanos.size());
        }
        
        return datosCiudadanos;
    }
    /**
     * Valida los datos obligatorios
     * @param ocr
     * @param claveElector
     * @param numeroEmision
     */
    private boolean validaDatosObligatorios(String ocr, String claveElector, Integer numeroEmision) {
    	
        if (!StringUtils.hasLength(claveElector)) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]validaDatosObligatorios,Clave de elector necesaria");
            return false;
        }
        if (numeroEmision == null || numeroEmision < 0) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]validaDatosObligatorios,Número de emisión necesario");
            return false;
        }
        if (!StringUtils.hasLength(ocr)) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]validaDatosObligatorios,OCR necesario");
            return false;
        }
        return true;
    }

    /**
     * Obtiene OCR
     * @param datosEntrada
     * @return String
     */
    private String obtenOCR(DatosEntrada datosEntrada) {
        if (validaDatosConsulta(datosEntrada)) {
            return datosEntrada.getDatosComparacion().getOcr();
        }
        return datosEntrada.getDatosComparacion().getOcr();
    }
    /**
     * Obtiene Numero de Emision
     * @param datosEntrada
     * @return Integer
     */
    private Integer obtenNumeroEmision(DatosEntrada datosEntrada) {
        if (validaDatosConsulta(datosEntrada)) {
            return datosEntrada.getDatosComparacion().getNumeroEmisionCredencial();
        }
        return null;
    }
    /**
     * Obtiene Clave de Elector
     * @param datosEntrada
     * @return String
     */
    private String obtenClaveElector(DatosEntrada datosEntrada) {
        if (validaDatosConsulta(datosEntrada)) {
            return datosEntrada.getDatosComparacion().getClaveElector();
        }
        return null;
        
    }
    /**
     * Verifica si la informacion va contenida en datos de consulta (situacion registral)
     * @param datosEntrada
     * @return boolean
     */
    private boolean validaDatosConsulta(DatosEntrada datosEntrada) {
        if (datosEntrada.getTipoRespuestaSolicitada() == null) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]esDatosConsulta,TipoRespuestaSolicitada nula");
            throw new RuntimeException("TipoRespuestaSolicitada nula");
        }
        
        if (datosEntrada.getDatosComparacion() == null) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]esDatosConsulta,Datos de comparacion nulos");
            throw new RuntimeException("Datos de comparacion nulos");
        }
        return true;
    }
}
