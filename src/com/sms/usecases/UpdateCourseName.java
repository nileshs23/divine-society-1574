package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Courses;
import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;
import com.sms.exceptions.CourseNotFoundException;

public class UpdateCourseName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		Courses course  = new Courses();
		
		System.out.println("Enter CourseID :(UPDATE)");
		course.setCourseId(sc.nextInt());

		CourseDao dao = new CourseDaoImpl();
		
		String res;
		try {
			res = dao.updateCourseName(course);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);
		
				

	}

}
