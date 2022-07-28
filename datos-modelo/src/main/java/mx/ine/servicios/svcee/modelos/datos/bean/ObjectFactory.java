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

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated
 */
@XmlRegistry
public class ObjectFactory {
    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mx.ine.esb.modelo.hsm.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DatosComparacion }
     * 
     */
    public DatosComparacion createDatosComparacion() {
        return new DatosComparacion();
    }
    /**
     * Create an instance of {@link DatosEntrada }
     * 
     */
    public DatosEntrada createDatosEntrada() {
        return new DatosEntrada();
    }
    /**
     * Create an instance of {@link RespuestaBase }
     * 
     */
    public RespuestaBase createRespuestaBase() {
        return new RespuestaBase();
    }
    /**
     * Create an instance of {@link RespuestaIntegrador }
     * 
     */
    public RespuestaIntegrador createRespuestaIntegrador() {
        return new RespuestaIntegrador();
    }
    /**
     * Create an instance of {@link RespuestaSituacionRegistralExterna }
     * 
     */
    public RespuestaSituacionRegistralExterna createRespuestaSituacionRegistralExterna() {
        return new RespuestaSituacionRegistralExterna();
    }
    /**
     * Create an instance of {@link DatosCiudadano }
     * 
     */
    public DatosCiudadano createDatosCiudadano() {
        return new DatosCiudadano();
    }
}
