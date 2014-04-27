package com.students.view;

 
import java.util.Iterator;
import java.util.TreeSet;

import com.students.controller.DateSearchController;
import com.students.controller.SearchResult;
import com.students.util.AppConfig;

/*
 * Here is the main Class with main method , it is just going to search all loaded recorded and show final results
 * 
 */
public class Command {

	public static void main(String[] arg) {
	 
		 
		TreeSet<SearchResult> sr = DateSearchController.searchStudentScore(  AppConfig.getFromDate(), AppConfig.getToDate());
		
		for(Iterator<SearchResult> it = sr.iterator(); it.hasNext();) {
			SearchResult st = it.next();
			System.out.println( st  );
		}
		
		 
	}
}
