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
