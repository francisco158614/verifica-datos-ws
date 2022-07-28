package mx.ine.servicios.svcee.verificacionDatos.dao.impl;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Component("mongoConnectionFactory")
@Scope("singleton")
public class MongoConnectionFactory {
	
	
	@Autowired
	@Qualifier("uriMongo")
	private String uriMongo;
	@Autowired
	@Qualifier("paramUriMongo")
	private String paramUriMongo;
	
	@Autowired
	@Qualifier("databaseMongo")
	private String database;
	
	
	private MongoClient mongoClient;
	
	/**
	 * Inicia la conexi�n con el Hbase
	 * @throws Exception
	 */
	@PostConstruct
	public void  createConnectionFactory()throws Exception{
		String params=paramUriMongo.replace(",","&");
		mongoClient=MongoClients.create(uriMongo+"&"+params);				
	}
	
	
	/**
	 * Obtiene el cliente de conexi�n
	 * @return
	 */
	public MongoClient getConnection(){
		
		return mongoClient;
	}
	
	/**
	 * Obtiene la conexi�n de la base en mongo
	 * @return
	 */
	public MongoDatabase getDataBase(){
		return mongoClient.getDatabase(database);
	}
	
	
	
	/**
	 * Cierra la conexi�n cuando se da de baja el bean 
	 * @throws IOException
	 */
	@PreDestroy
	private void cierraConnection() throws IOException{
		mongoClient.close();
	}
	
	

}
