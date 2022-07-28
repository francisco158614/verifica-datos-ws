/**
 * BusquedaDatosCiudadanoService.java
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
import mx.ine.servicios.svcee.modelos.datos.bean.RespuestaIntegrador;

/**
 * Realiza la busqueda de los datos del ciudadano/credencial
 * @author INE
 * @version 1.0
 * @since SIIRFE 5.1
 */
public interface BusquedaDatosCiudadanoService {
    /**
     * Realiza la busqueda de los datos del ciudadano/credencial utilizando la informacion
     * contenida en los datos de entrada
     * @param datosEntrada
     * @return lista de registros encontrados
     * @throws Exception
     */
    public List<DatosCiudadano> buscaCiudadano(DatosEntrada datosEntrada,RespuestaIntegrador respuesta)throws Exception;
}
