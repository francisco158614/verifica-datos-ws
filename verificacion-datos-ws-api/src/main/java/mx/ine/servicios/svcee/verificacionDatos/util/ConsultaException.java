/**
 * ConsultaException.java
 * Fecha de creación: 29/06/2015, 12:31:20
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
package mx.ine.servicios.svcee.verificacionDatos.util;


/**
 * Clase de excepciones personalizadas
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 */
public class ConsultaException extends RuntimeException {
    private static final long serialVersionUID = 6046584611347888818L;

    /**
     * Constructor para mensaje personalizado
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param message
     */
    public ConsultaException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param message
     * @param cause
     */
    public ConsultaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con causa específica
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param cause
     */
    public ConsultaException(Throwable cause) {
        super(generaMensajePersonalizado(cause), cause);
    }

    private static String generaMensajePersonalizado(Throwable cause) {
        String mensajeDefault = "Error inesperado!";

        if (isCause(ConsultaException.class, cause)) {
            return cause.getMessage();
        }

        return mensajeDefault;
    }

    private static boolean isCause(Class<? extends Throwable> expected, Throwable exc) {
        return expected.isInstance(exc) || (exc != null && isCause(expected, exc.getCause()));
    }

}
