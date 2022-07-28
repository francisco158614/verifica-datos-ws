/**
 * BusquedaDatosCiudadanoServiceImpl.java
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
