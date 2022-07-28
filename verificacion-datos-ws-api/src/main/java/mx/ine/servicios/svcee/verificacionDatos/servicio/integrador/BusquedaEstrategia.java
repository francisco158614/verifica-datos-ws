/**
 * BusquedaDatosCiudadanoServiceImpl.java
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
package mx.ine.servicios.svcee.verificacionDatos.servicio.integrador;

import java.util.List;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosEntrada;

/**
 * Realiza validaciones y busqueda de los datos
 * @author INE
 * @version 1.0
 * @since SIIRFE 5.1
 */
public interface BusquedaEstrategia {
    /**
     * Realiza validaciones de los datos obligatorios, longitudes y otras reglas de negocio
     * @param datosEntrada
     */
    public boolean valida(DatosEntrada datosEntrada);
    /**
     * Realiza la busqueda de la credencial con los datos requeridos por la estrategia
     * @param datosEntrada
     * @return List<DatosCiudadano>
     * @throws Exception
     */
    public List<DatosCiudadano> busca(DatosEntrada datosEntrada)throws Exception;
}
