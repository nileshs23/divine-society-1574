package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Courses;
import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;

public class AddCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course ID (100-500):");
		int id = sc.nextInt();
		
		System.out.println("Enter Course Name :");
		String name = sc.next();
		
		System.out.println("Enter Fees:");
		int fees = sc.nextInt();
		
		Courses course = new Courses(id,name,fees);
		
		CourseDao dao = new CourseDaoImpl() ; 
		
		String res = dao.registerCourse(course);
		System.out.println(res);
	}

}
