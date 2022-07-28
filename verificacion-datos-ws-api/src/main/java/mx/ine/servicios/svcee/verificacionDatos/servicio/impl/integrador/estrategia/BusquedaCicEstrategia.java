/**
 * BusquedaCicEstrategia.java
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
@Service("busquedaCicEstrategia")
public class BusquedaCicEstrategia implements BusquedaEstrategia {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaCicEstrategia.class);
	
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
        return validaDatosObligatorios(obtenCIC(datosEntrada),datosEntrada.getIndice());
    }
    /**
     * Realiza la busqueda de la credencial con los datos requeridos por la estrategia
     * @param datosEntrada
     * @return List<DatosCiudadano>
     * @throws Exception
     */
    @Override
    public List<DatosCiudadano> busca(DatosEntrada datosEntrada)throws Exception {
        DatosCiudadano filtro = new DatosCiudadano();
        List<DatosCiudadano> datosCiudadanos = new ArrayList<>();
        List<Credencial> listCredencial = null;
        String cicStr=obtenCIC(datosEntrada);
        filtro.setCic(Long.valueOf(cicStr));
        listCredencial = credencialDAO.buscaPorCic(filtro); 
        for(Credencial credencial:listCredencial) {
        	DatosCiudadano ciudadano=ciudadanoDAO.busca(credencial.getCiudadanoId());
        	if(ciudadano!=null) {
        		datosCiudadanos.add(ciudadano);
        	}
        }
        
        return datosCiudadanos;
    }

    /**
     * Valida los datos obligatorios
     * @param cic
     */
    private boolean validaDatosObligatorios(String cic, String index) {
        if (!StringUtils.hasLength(cic)) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]validaDatosObligatorios,CIC necesario, indiceSolicitud:"+index);
        	return false;            
        }
        return true;
    }
    /**
     * Obtiene CIC
     * @param datosEntrada
     * @return String
     */
    private String obtenCIC(DatosEntrada datosEntrada) {
    	if (datosEntrada.getTipoRespuestaSolicitada() == null) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]esDatosConsulta,TipoRespuestaSolicitada nula");
            throw new RuntimeException("TipoRespuestaSolicitada nula");
        }     
        if (datosEntrada.getDatosComparacion() == null) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]esDatosConsulta,Datos de comparacion nulos");
            throw new RuntimeException("Datos de comparacion nulos");
        }
        return datosEntrada.getDatosComparacion().getCic();
    }
   
}
