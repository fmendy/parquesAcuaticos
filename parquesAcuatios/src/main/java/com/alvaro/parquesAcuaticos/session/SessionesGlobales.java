/**
 * 
 */
package com.alvaro.parquesAcuaticos.session;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author alvaro
 *
 */
public class SessionesGlobales  {
	public static String SUCCESS = "SUCCESS";
	public static String FAILED = "FAILED";
	public static String LOGEADO = "LOGEADO";
	public static String NO_LOGEADO = "NO_LOGEADO";
	public static String OPERATION_STATUS_CORRECT = "CORRECT";
	public static String OPERATION_STATUS_FAIL = "FAILED";

	
	public static java.sql.Date getDateSQL() {
	    java.util.Date date = new java.util.Date();  
	    java.sql.Date da = new java.sql.Date(date.getTime());
	    return da;
	    
	}
}
