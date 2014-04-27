package com.students.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.students.model.Student;
import com.students.model.StudentTest;
import com.students.util.AppConfig;
import com.students.util.Utility;


/*
 * This class is loading Student Data from a properties file via AppConfig.getStudentsDataFile()
 * 
 */
public class DataLoader {
	private final static Logger LOGGER = Logger.getLogger(DataLoader.class .getName()); 
	 
	public static ArrayList<Student> loadStudentsData() {
		
		ArrayList<Student> studentsCollection = new ArrayList<Student>(100);
		
			try (BufferedReader br = new BufferedReader(new FileReader( AppConfig.getStudentsDataFile()) ) )	{
				 
				String  recordLine = new String();
				String lineItems[] = new String[3];
				 
				
				 while  ((recordLine = br.readLine()) != null) {
					  
					 Student student = new Student();
					 StudentTest studentTest = new StudentTest();
						
					 lineItems = recordLine.split(",")   ;
					 System.out.println( lineItems[0]  + " " + lineItems[1] + " " + lineItems[2] );
					 student.setStudentID( Integer.parseInt(lineItems[1]) ); // second item is ID
					 
					 int index ;
					 
					 if (  (index = studentsCollection.indexOf(student) ) > -1  ) {
						 
						 student = studentsCollection.get(index);
						 
					 }
					 
					 studentTest.setTestDate( Utility.convertStringIntoDate( lineItems[0]  )  ); // first  item is Date
					 studentTest.setTestScore( Float.parseFloat(lineItems[2] )  ); // first  item is Score

					 student.addStudentTest(studentTest);
						 
					 
					 if ( index == -1)  {
						 studentsCollection.add(student);
					 }
				}
				 
		 
			
			} catch (IOException e) {
			 LOGGER.warning( e.getMessage() );
		  } 
		
		
		return studentsCollection;
	}
	
	
	
	
	public static String[] getStudentRecordInParts(String record) {
		
		
		if (record == null || record.length() < 1 )
			throw new IllegalArgumentException("");
		
		String items[] = new String[3];
		int index =0;
		 
		StringBuffer item =new StringBuffer();
		for(int i=0; i < record.length() ; i++  ) {  //one record looks like 10-04-2014,1,60
			 
			if (record.charAt(i) != ',') {
				item.append( record.charAt(i) );
			}else {
				 
				items[index] = item.toString() ; //add into array
			 
				item.delete(0, item.length()); //clear previous item
				 index++;
			}
 
		}
		if (item.length() > -1 ) { //Add last item into array
			items[index] = item.toString() ;  			
			 
		}
		
		//LOGGER.info(items.toString());
		return items;
	}
	

}
