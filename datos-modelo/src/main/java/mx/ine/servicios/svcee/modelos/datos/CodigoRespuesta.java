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
package mx.ine.servicios.svcee.modelos.datos;

/**
 * Enum para controlar los codigos de respuesta del Bus de comunicaciones 
 * @author Andres Lopez (andres.lopez@ine.mx)
 * @author Edgar Paz 
 */
public enum CodigoRespuesta {
	OK(0,"Resultado sin errores"),	
	ERROR_INESPERADO(201,"Error inesperado en el servicio de verificaci�n de datos, puede ser una falla en la conexi�n en la base de datos o un error al comparar la informaci�n"),
	ERROR_PARAMETROS_ENTRADA(202,"Error en los par�metros en el servicio de verificaci�n de datos, este error es lanzado cuando los par�metros de b�squeda son incorrectos o mal formados"),
//	ERROR_PARAMETROS_SIN_AVISO_PRIVACIDAD(203,"SIN AVISO DE PRIVASIDAD"),
	ERROR_TIPO_RESPUESTA_SOLICITADA_INVALIDA(204,"Las consultas al padr�n pueden realizarse por diversos sistemas y cada uno tiene asignado un identificador. En este caso es CONSULTA_EXTERNA, por lo que al enviar una solicitud al servicio de verificaci�n si se indica un tipo diferente de CONSULTA_EXTERNA se presenta este error"),
	ERROR_DATOS_BUSQEDA_INVALIDOS(205,"Datos de b�squeda incompletos o inv�lidos. Este error ocurre al determinar la estrategia de b�squeda, es decir, si es b�squeda por cic o por clave de elector (ocr+clave  de elector+n�mero de emisi�n) pero alguno de estos datos es incompleto o no cumple con el formato esperado"),
	JSON_ERROR_VERIFICACION_DATOS(136,"Error con la cadena JSON que recibe el proxy de verificaci�n de datos o en los datos que contiene"),
	ERROR_INESPERADO_VERIFICACION_DATOS(137,"Error inesperado en el proxy de verificaci�n de datos"),
	ERROR_COMUNICACION_DATOS(105,"Este error puede darse por la p�rdida de conexi�n entre el proxy y el servicio de verificaci�n de datos o porque se agot� el tiempo de espera de la respuesta del servicio (timeout)");
	
	/**
	 * Codifo del estatus
	 */
	private int id;
	/**
	 * Descripción larga.
	 */
	private String descripcion;

	private CodigoRespuesta(Integer id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	/**
	 * Valor del enum apartir de su id
	 * @param id
	 * @return
	 */
	public static CodigoRespuesta valueOf(int id){
		for(CodigoRespuesta err: values()){ 
			if (err.getId() == id) {
				return err;
			}
		}
		throw new IllegalArgumentException("Id invalido para obtener codigo de respuesta" + id);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
