package com.sms.beans;

public class Courses {
	
	private int courseId;
	private String courseName;
	private int courseFees;
	
	public Courses() {
		super();
	}

	public Courses(int courseId, String courseName, int courseFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFees = courseFees;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getcourseFees() {
		return courseFees;
	}

	public void setcourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFees=" + courseFees + "]";
	}
	
	
	

}
