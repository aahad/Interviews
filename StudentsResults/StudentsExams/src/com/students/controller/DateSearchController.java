package com.students.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

import com.students.model.Student;
import com.students.model.StudentTest;

/*
 * This class works as a controller to search records by date and populate Search Results collection
 * 
 */
public class DateSearchController {

	
	
	public static TreeSet<SearchResult> searchStudentScore(  Date frmDate, Date toDate) {
		ArrayList<Student> students = DataLoader.loadStudentsData();
		
		TreeSet<SearchResult> results =new TreeSet<SearchResult>() ;
		 
		for(Iterator<Student> iterator = students.iterator() ; iterator.hasNext(); ) {
			 Student st = iterator.next();
			 SearchResult  rs =new  SearchResult();
		 	for( Iterator<StudentTest> testItrator = st.getStudentTestsCollection().iterator(); testItrator.hasNext(); ) {
		 		StudentTest stest = testItrator.next();
		 		 if ( stest.getTestDate().compareTo(frmDate ) >=0  &&  stest.getTestDate().compareTo(toDate) <= 0 ) {
		 			 
		 			rs.setStudentID(st.getStudentID());
		 			rs.addScore( stest.getTestScore()  );
		 		 
		 		 }
		 	}
		 	results.add(rs);
		}
 
		return results;
	}
}
