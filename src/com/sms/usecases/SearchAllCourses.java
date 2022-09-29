package com.sms.usecases;

import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;
import com.sms.exceptions.EmptyCourseException;

public class SearchAllCourses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CourseDao dao = new CourseDaoImpl();
		try {
			dao.allCourses();
		} catch (EmptyCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
