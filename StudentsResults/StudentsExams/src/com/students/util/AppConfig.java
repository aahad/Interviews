package com.students.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

/*
 * This class loads Application configuration details form properties file
 * 
 */
public class AppConfig {

	public static final Properties prop = new Properties();
	private static AppConfig appConfig;
	private final static Logger LOGGER = Logger.getLogger(AppConfig.class .getName()); 
	
	
	static {
		getInstance();
	}
	
	private  AppConfig() {
		try (InputStream  appConfig= new FileInputStream("config.properties") ) {
	       // load properties
			prop.load(appConfig );
	 
		} catch (IOException io) {
			io.printStackTrace();
		}  
	}
	
	public static synchronized AppConfig getInstance() {
	    if (appConfig == null) {
	    	appConfig = new AppConfig();
	    }
	    LOGGER.info("loaded instance");
	    return appConfig;
	  }
	
	public static String getStudentsDataFile() {
		return prop.getProperty("filepath");
	}
	
	public static Date getFromDate() {
		return Utility.convertStringIntoDate( prop.getProperty("FromDate") );
	}
	
	public static Date getToDate() {
		return Utility.convertStringIntoDate( prop.getProperty("ToDate") );
	}
	
}
