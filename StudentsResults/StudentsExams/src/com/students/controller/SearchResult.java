package com.students.controller;

import java.util.TreeSet;

/*
 * This class will hold all results score and will return final score
 * 
 */

public class SearchResult implements Comparable{

	private int student;
	private TreeSet<Double> scores = new TreeSet<Double>();
 
	
	public void setStudentID(int student) {
		this.student = student;
	}
	
	public int getStudentID() {
		return this.student  ;
	}
 
	public double getFinalScore() {
		
		Object[] arr = scores.toArray();
		double finalScore = 0;
		int index = 0;
		for(int i=arr.length - 1; i >= 0; i--) {
			finalScore += (double)arr[i];
			index++;
			if( index == 5 ) break;
		}
		return finalScore / index;//
	}
	
	public void addScore(double dl) {
		scores.add(dl);
	}
	
	@Override
	public String toString() {
		
		return this.student + " - " + getFinalScore();
		 
	}
	
	@Override
	public boolean equals(Object v) {
		
		return this.student == ((SearchResult)v).student ;
	}
	
	@Override
    public int hashCode() {
        int hash = 5;
        hash = 89 + hash + (this.scores != null ? this.scores.hashCode() : 0);
        hash += 89 + hash + this.student;
        return hash;
    }
	
 
	

	@Override
	public int compareTo(Object v) {
		 
		return (this.student - ((SearchResult)v).student);
	} 
	
}
