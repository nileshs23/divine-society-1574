package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Courses;
import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;
import com.sms.exceptions.CourseNotFoundException;

public class UpdateCourseFees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Courses course  = new Courses();
		
		System.out.println("Enter Course Name :(UPDATE)");
		course.setCourseName(sc.next());

		CourseDao dao = new CourseDaoImpl();
		
		String res;
		try {
			res = dao.updateCourseFees(course);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);
		
				

	}
}
