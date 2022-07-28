/**
 * DatosCiudadanoDAOImpl.java
 * Fecha de creación: 07/08/2015, 17:16:13
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
package mx.ine.servicios.svcee.verificacionDatos.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.bson.Document;
import org.bson.json.JsonWriterSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.verificacionDatos.dao.CiudadanoDAO;

/**
 * Implementacion de acceso a datos para datos del ciudadano
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Component("ciudadanoDAO")
@Scope("singleton")
public class CiudadanoDAOImpl  implements CiudadanoDAO {
	/**
	 * Logger de la clase
	 */
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CiudadanoDAOImpl.class);

	@Autowired
	@Qualifier("mongoConnectionFactory")
	private MongoConnectionFactory connFactory;
	
	private JsonWriterSettings settings;
	
	@Autowired
	@Qualifier("collectionCiudadano")
	private String ciudadanoCollection;
	
	
	
	
	
	
	public CiudadanoDAOImpl() {
		 settings = JsonWriterSettings.builder()
                 .int64Converter((value, writer) -> writer.writeNumber(value.toString()))
                 .dateTimeConverter((value, writer) -> writer.writeString(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(value))))
                 .build();
		
	}






	@Override
	public DatosCiudadano busca(Long idCiudadano) throws Exception {
		DatosCiudadano ciudadano=null;
		MongoDatabase db=connFactory.getDataBase();	
		ObjectMapper mapper = new ObjectMapper();
		//busqueda por cic
		if(idCiudadano!=null){
			MongoCollection<Document> coll=db.getCollection(ciudadanoCollection);
			Document filter= new Document("_id", idCiudadano);
			Document resultado= coll.find(filter).first();	
			if(resultado!=null) {
				ciudadano=mapper.readValue(resultado.toJson(settings), DatosCiudadano.class);
			}
		}		

		return ciudadano;
	}


	
	

}
