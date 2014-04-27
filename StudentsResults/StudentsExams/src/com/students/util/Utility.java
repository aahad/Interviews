package com.students.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Utility {

	private final static DateFormat formatter =  new SimpleDateFormat("yyyy-MM-dd");
	private final static Logger LOGGER = Logger.getLogger(Utility.class .getName()); 
	
	
	public static Date convertStringIntoDate(String date) {
		
		 Date dt= new Date();
		  try{
			   dt = formatter.parse(date);
		  }catch(ParseException e){
			  LOGGER.info("Exam Date format Exception: " + e.getStackTrace() ) ;
		  }

		  return dt;
		
	}
}
