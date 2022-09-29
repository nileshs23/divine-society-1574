package com.sms.dao;

import com.sms.beans.Courses;
import com.sms.exceptions.EmptyCourseException;

public interface CourseDao {
	
	public String registerCourse(Courses course);
	
	public void allCourses() throws EmptyCourseException;

}
