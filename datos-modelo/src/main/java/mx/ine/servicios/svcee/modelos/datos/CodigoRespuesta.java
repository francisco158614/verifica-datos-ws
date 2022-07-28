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
package mx.ine.servicios.svcee.modelos.datos;

/**
 * Enum para controlar los codigos de respuesta del Bus de comunicaciones 
 * @author Andres Lopez (andres.lopez@ine.mx)
 * @author Edgar Paz 
 */
public enum CodigoRespuesta {
	OK(0,"Resultado sin errores"),	
	ERROR_INESPERADO(201,"Error inesperado en el servicio de verificación de datos, puede ser una falla en la conexión en la base de datos o un error al comparar la información"),
	ERROR_PARAMETROS_ENTRADA(202,"Error en los parámetros en el servicio de verificación de datos, este error es lanzado cuando los parámetros de búsqueda son incorrectos o mal formados"),
//	ERROR_PARAMETROS_SIN_AVISO_PRIVACIDAD(203,"SIN AVISO DE PRIVASIDAD"),
	ERROR_TIPO_RESPUESTA_SOLICITADA_INVALIDA(204,"Las consultas al padrón pueden realizarse por diversos sistemas y cada uno tiene asignado un identificador. En este caso es CONSULTA_EXTERNA, por lo que al enviar una solicitud al servicio de verificación si se indica un tipo diferente de CONSULTA_EXTERNA se presenta este error"),
	ERROR_DATOS_BUSQEDA_INVALIDOS(205,"Datos de búsqueda incompletos o inválidos. Este error ocurre al determinar la estrategia de búsqueda, es decir, si es búsqueda por cic o por clave de elector (ocr+clave  de elector+número de emisión) pero alguno de estos datos es incompleto o no cumple con el formato esperado"),
	JSON_ERROR_VERIFICACION_DATOS(136,"Error con la cadena JSON que recibe el proxy de verificación de datos o en los datos que contiene"),
	ERROR_INESPERADO_VERIFICACION_DATOS(137,"Error inesperado en el proxy de verificación de datos"),
	ERROR_COMUNICACION_DATOS(105,"Este error puede darse por la pérdida de conexión entre el proxy y el servicio de verificación de datos o porque se agotó el tiempo de espera de la respuesta del servicio (timeout)");
	
	/**
	 * Codifo del estatus
	 */
	private int id;
	/**
	 * DescripciÃ³n larga.
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
