package com.students.model;
import java.util.ArrayList;
import java.util.TreeSet;

/*
 * This is the main student class to hold each record entry
 * 
 */
public class Student {

		private int studentID;
		private ArrayList<StudentTest> testsCollections ;  
		
		public Student() {
			testsCollections  = new ArrayList<StudentTest>();
		}
		public void setStudentID(int id) {
			this.studentID = id;
		}
		
		public int getStudentID() {
			return this.studentID  ;
		}
		
		public void addStudentTest(StudentTest test) {
			  
			this.testsCollections.add(test);
		}
		
		public ArrayList<StudentTest> getStudentTestsCollection() {
			return this.testsCollections  ;
		}
		
		@Override
		public boolean equals(Object v) {
			
			return this.studentID == ((Student)v).studentID ;
		}
		
		@Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 89 + hash + (this.testsCollections != null ? this.testsCollections.hashCode() : 0);
	        hash += 89 + hash + this.studentID;
	        return hash;
	    }

	 

}
