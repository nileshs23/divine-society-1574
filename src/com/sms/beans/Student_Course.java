package com.sms.beans;

public class Student_Course{

	private int studentId;
    private String firstName;
    private String lastName;
    private String city;
    private int courseId;
	private String courseName;
	private int courseFees;

	public Student_Course() {
		super();
	}

	public Student_Course(int studentId, String firstName, String lastName, String city, int courseId,
			String courseName, int courseFees) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFees = courseFees;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public int getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(int courseFees) {
		this.courseFees = courseFees;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student_Course [studentId=");
		builder.append(studentId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", courseId=");
		builder.append(courseId);
		builder.append(", courseName=");
		builder.append(courseName);
		builder.append(", courseFees=");
		builder.append(courseFees);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
