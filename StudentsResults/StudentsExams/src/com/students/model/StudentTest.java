package com.students.model;

import java.util.Date;
import java.util.TreeSet;

/*
 * This student Test class hold record details by date and score
 * 
 */
public class StudentTest {

	private Date date;
	private double score;
	
	public void setTestDate(Date date) {
		this.date = date;
	}
	
	public Date getTestDate() {
		return this.date  ;
	}
	
	public void setTestScore(double score) {
		this.score = score;
	}
	
	public double getTestScore() {
		return this.score  ;
	}
	
}
