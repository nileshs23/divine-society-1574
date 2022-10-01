package com.sms.beans;

public class CountStuds {

	private String courseName;
	private int courseId;
	private int numberOFStuds;
	
	
	
	public CountStuds() {
		super();
	}

	public CountStuds(String courseName, int courseId, int numberOFStuds) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.numberOFStuds = numberOFStuds;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getNumberOFStuds() {
		return numberOFStuds;
	}
	public void setNumberOFStuds(int numberOFStuds) {
		this.numberOFStuds = numberOFStuds;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CountStuds [courseName=");
		builder.append(courseName);
		builder.append(", courseId=");
		builder.append(courseId);
		builder.append(", numberOFStuds=");
		builder.append(numberOFStuds);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
