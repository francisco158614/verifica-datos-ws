/**
 * Utils.java
 * Fecha de creaciï¿½n: 24/07/2015, 17:52:57
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcciï¿½n
 * Ejecutiva del Registro Federal de Electores.
 * Perifï¿½rico Sur 239, Mï¿½xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaciï¿½n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaciï¿½n confidencial
 * no deberï¿½ ser divulgada y solo se podrï¿½ utilizar de acuerdo
 * a los tï¿½rminos que determine el propio Instituto.
 */
package mx.ine.servicios.svcee.verificacionDatos.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.ine.servicios.svcee.modelos.datos.bean.DatosCiudadano;

/**
 * Utilierias
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @author andres-lopez (andres.lopez@ine.mx) mantenimiento y cambios 2017
 * @version 6.5
 * @since SIIRFE 6.1
 */
public class Utils {
	
	private static Logger logger=LoggerFactory.getLogger(Utils.class);

    /**
     * mï¿½todo que regresa un valor booleano al comparar dos valores de tipo string que no sean
     * nulos, en caso contrario regresa null
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @author Andres Lopez(andres.lopez@ine.mx) mantenimiento 2017
     * @param valorRecibido valor enviado 
     * @param valorBase valor base
     * @return
     */
    public static Boolean comparaString(String valorRecibido,String valorBase) {
    	boolean band=false;
    	if (valorRecibido == null){
    		return null;
    	}else if (valorBase == null && valorRecibido != null) {
    		band=false;  	            
        }else{    	
        	band=valorBase.equalsIgnoreCase(valorRecibido);
        }
        return band;
    }
    /**
     * mï¿½todo que regresa un valor booleano al comparar dos valores de tipo entero con las reglas de negocio
     * del servicio de verificación de la credencial.
     * @author Andres Lopez (andres.lopez@ine.mx) 2017
     * @param valorRecibido
     * @param valorBase
     * @return
     */
    public static Boolean comparaInteger(Integer valorRecibido, Integer valorBase) {
    	
    	Boolean band=null;
    	if (valorRecibido == null) {
    		band=null; 		
    	      
        }else if (valorBase == null && valorRecibido!=null) {
        	band=false;    	
        }else{
        	band=valorBase.equals(valorRecibido);
        }
        return band;
    }

    
    /**
     * Obtiene el año de una cadena con la fecha en el formato yyyy-MM-dd
     * @author Andres Lopez (andres.lopez@ine.mx)
     * @param date
     * @return anio
     */
    public static Integer obtieneAnio(String date) {
    	Integer anio=null;
        if (date != null) {
        	String arg[]=date.split("-");        	
        	anio=Integer.parseInt(arg[0]);          
        }
        return anio;
    }
    

    /**
     * Convierte una fecha tipo string a un tipo Date
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param dateInString
     * @return newDate
     */
    public static Date strToDate(String dateInString) {
        Date newDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (dateInString != null) {
            try {
                newDate = sdf.parse(dateInString);
            } catch (ParseException ex) {
            	logger.error("Error al parsear la fecha:" + dateInString,ex);
            }
        }

        return newDate;
    }
    
    public static String toCSV(List<DatosCiudadano> list)throws Exception {
    	StringBuilder cadenaFinal =  new StringBuilder();
    	
    	//cadenaFinal.append("\n").append("ID CIUDADANO,CAUSA_ROBO_EXTRAVIO,TIPO_EXTATUS,Numero reporte robo extravio");
    	if(list != null){
			for(DatosCiudadano datos:list){				
				if(datos.getCiudadanoId()!=null){
					cadenaFinal.append(datos.getCiudadanoId());
				}
				cadenaFinal.append(",");
				if(datos.getTipoCausaRoboExtravio() != null){
					cadenaFinal.append(datos.getTipoCausaRoboExtravio());
				}
				cadenaFinal.append(",");
				if(datos.getTipoEstatusRoboExtravio() != null){
					cadenaFinal.append(datos.getTipoEstatusRoboExtravio());
				}
				cadenaFinal.append(",");
				if(datos.getNumeroReporteRoboExtravio() != null){
					cadenaFinal.append(datos.getNumeroReporteRoboExtravio());
				}
				cadenaFinal.append("\n");
			}
    	}
    	return cadenaFinal.toString();
    }
    /**
	 * Configuracion basica del mapper
	 * @return
	 */
	public static ObjectMapper getMapper1() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE,true);
		mapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE,true);
		mapper.setSerializationInclusion(Inclusion.NON_NULL);
		mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return mapper;
	}
}
