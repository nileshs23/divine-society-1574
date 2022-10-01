package com.sms.dao;

import java.util.List;

import com.sms.beans.Courses;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyCourseException;

public interface CourseDao {

	public String registerCourse(Courses course);

	public List<Courses> searchAllCourses() throws EmptyCourseException;

	public String deleteCourse(String courseName) throws CourseNotFoundException;
	
	public String updateCourseName(Courses course) throws CourseNotFoundException;
	
	public String updateCourseFees(Courses course) throws CourseNotFoundException;
	
}


//1.add course ~
//2.getStudentSInCourse --- use joins
//3.AllCourses ~
//4.Remove Course ~
//5.UpdateCourseName ~
//6.UpdateCourseFees ~