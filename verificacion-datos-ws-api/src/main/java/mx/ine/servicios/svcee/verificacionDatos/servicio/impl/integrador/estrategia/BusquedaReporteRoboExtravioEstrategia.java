/**
 * BusquedaReporteRoboExtravioEstrategia.java
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
@Service("busquedaReporteRoboExtravioEstrategia")
public class BusquedaReporteRoboExtravioEstrategia implements BusquedaEstrategia {
	/**
	 * Logger de la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BusquedaReporteRoboExtravioEstrategia.class);

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
        return validaDatosObligatorios(obtenNumeroReporteRoboExtravio(datosEntrada));
    }
    /**
     * Realiza la busqueda de la credencial con los datos requeridos por la estrategia
     * @param datosEntrada
     * @return List<DatosCiudadano>
     */
    @Override
    public List<DatosCiudadano> busca(DatosEntrada datosEntrada)throws Exception {
        DatosCiudadano filtro = new DatosCiudadano();
        List<DatosCiudadano> datosCiudadanos = new ArrayList<DatosCiudadano>();
        List<Credencial> credenciales=null;
        filtro.setNumeroReporteRoboExtravio(obtenNumeroReporteRoboExtravio(datosEntrada));
        credenciales = credencialDAO.buscaPorReporteRoboExtr(filtro);
        for(Credencial credencial:credenciales) {
        	DatosCiudadano ciudadano=ciudadanoDAO.busca(credencial.getCiudadanoId());
        	if(ciudadano!=null) {
        		datosCiudadanos.add(ciudadano);
        	}
        }        
        if (datosCiudadanos.size() == 0) {
        	LOGGER.warn("[VERIFICA-DATOS-WS-ERROR]busca,datosCiudadanos:"+datosCiudadanos.size());
        }
        return datosCiudadanos;
    }
    /**
     * Valida los datos obligatorios
     * @param numeroReporteRoboExtravio
     */
    private boolean validaDatosObligatorios(Long numeroReporteRoboExtravio) {
        if (numeroReporteRoboExtravio == null || numeroReporteRoboExtravio < 0) {
        	LOGGER.error("[VERIFICA-DATOS-WS-ERROR]validaDatosObligatorios,Reporte Robo Extravío necesario");
        	return false;
        }
        return true;
    }
    /**
     * Obtiene Reporte de Robo o Extravío de la credencial para votar
     * @param datosEntrada
     * @return Long
     */
    private Long obtenNumeroReporteRoboExtravio(DatosEntrada datosEntrada) {
        if (validaDatosConsulta(datosEntrada)) {
        	return datosEntrada.getDatosComparacion().getNumeroReporteRoboExtravio();
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
