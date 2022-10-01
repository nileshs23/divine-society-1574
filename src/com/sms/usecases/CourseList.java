package com.sms.usecases;

import java.util.ArrayList;
import java.util.List;

import com.sms.beans.Courses;
import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;
import com.sms.exceptions.EmptyCourseException;

public class CourseList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CourseDao dao = new CourseDaoImpl();
		List<Courses> cL = new ArrayList<>();
		
		try {
			cL = dao.searchAllCourses();
			
			for(Courses c:cL) {
				System.out.println(c);
			}
		} catch (EmptyCourseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
