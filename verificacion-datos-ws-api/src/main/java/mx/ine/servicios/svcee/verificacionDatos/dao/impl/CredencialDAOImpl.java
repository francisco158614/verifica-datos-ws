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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import mx.ine.servicios.svcee.modelos.datos.bean.Credencial;
import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;
import mx.ine.servicios.svcee.verificacionDatos.dao.CredencialDAO;

/**
 * Implementacion de acceso a datos para datos del ciudadano
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Component("credencialDAO")
@Scope("singleton")
public class CredencialDAOImpl  implements CredencialDAO {
	/**
	 * Logger de la clase
	 */
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CredencialDAOImpl.class);

	@Autowired
	@Qualifier("mongoConnectionFactory")
	private MongoConnectionFactory connFactory;
	
	private JsonWriterSettings settings;
	
	@Autowired
	@Qualifier("collectionCredencial")
	private String credencialCollection;
	
	
	private static String COLUMN_CIC="cic";
	
	private static final String COLUMN_REPORTE_ROBO_EXTRAVIO_ID="numero_reporte_roboetravio";
	
	private static final String COLUMN_CLAVE_ELECTOR="clave_elector";
	
	private static final String COLUMN_OCR="ocr";
	
	private static final String COLUMN_NUM_EMISION_CREDENCIAL="num_emision_credencial";
	
	
	
	
	public CredencialDAOImpl() {
		 settings = JsonWriterSettings.builder()
                 .int64Converter((value, writer) -> writer.writeNumber(value.toString()))
                 .dateTimeConverter((value, writer) -> writer.writeString(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(new Date(value))))
                 .build();
		
	}


	/*
	 * (non-Javadoc)
	 * @see mx.ine.serviciosconsulta.servicios.entidadesexternas.dao.DatosCiudadanoDAO#buscaPorCic(mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.entidad.DatosCiudadano)
	 */
	@Override
	public List<Credencial> buscaPorCic(DatosCiudadano filtro) throws Exception {
		List<Credencial> listaCredencial=new ArrayList<>();
		MongoDatabase db=connFactory.getDataBase();	
		ObjectMapper mapper = new ObjectMapper();
		

		//busqueda por cic
		if(filtro.getCic()!=null){
			MongoCollection<Document> coll=db.getCollection(credencialCollection);
			Document filter= new Document(COLUMN_CIC, filtro.getCic());
			List<Document> resultado= coll.find(filter).into(new ArrayList<Document>());
			for(Document doc:resultado){				
				listaCredencial.add(mapper.readValue(doc.toJson(settings), Credencial.class));
			}		
		}		

		return listaCredencial;
	}
	/*
	 * (non-Javadoc)
	 * @see mx.ine.serviciosconsulta.servicios.entidadesexternas.dao.DatosCiudadanoDAO#buscaPorClave(mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.entidad.DatosCiudadano)
	 */
	@Override
	public List<Credencial> buscaPorClave(DatosCiudadano filtro) throws Exception {
		List<Credencial> lista=new ArrayList<>();
		MongoDatabase db=connFactory.getDataBase();
		ObjectMapper mapper=new ObjectMapper();
		//busqueda por clave de elector	
		if(filtro.getClaveElector()!=null || filtro.getOcr()!=null || filtro.getNumeroEmisionCredencial()!=null){
			MongoCollection<Document> coll=db.getCollection(credencialCollection);
			Document filter= new Document(COLUMN_CLAVE_ELECTOR, filtro.getClaveElector());
			filter.append(COLUMN_OCR, filtro.getOcr());
			filter.append(COLUMN_NUM_EMISION_CREDENCIAL, filtro.getNumeroEmisionCredencial());			
			List<Document> resultado= coll.find(filter).into(new ArrayList<Document>());
			for(Document doc:resultado){
				lista.add(mapper.readValue(doc.toJson(settings), Credencial.class));
			}

		}

		return lista;
	}

	/*
	 * (non-Javadoc)
	 * @see mx.ine.serviciosconsulta.servicios.entidadesexternas.dao.DatosCiudadanoDAO#buscaPorReporteRoboExtr(mx.ine.serviciosconsulta.servicios.entidadesexternas.modelo.entidad.DatosCiudadano)
	 */
	@Override
	public List<Credencial> buscaPorReporteRoboExtr(DatosCiudadano filtro) throws Exception {
		List<Credencial> lista=new ArrayList<>();
		MongoDatabase db=connFactory.getDataBase();
		ObjectMapper mapper=new ObjectMapper();
		//busqueda por curp
		if(filtro.getNumeroReporteRoboExtravio()!=null ){
			MongoCollection<Document> coll=db.getCollection(credencialCollection);
			Document filter= new Document(COLUMN_REPORTE_ROBO_EXTRAVIO_ID, filtro.getNumeroReporteRoboExtravio());
			List<Document> resultado= coll.find(filter).into(new ArrayList<Document>());
			for(Document doc:resultado){
				lista.add(mapper.readValue(doc.toJson(settings), Credencial.class));
			}		
		}
		return lista;
	}
	

}
