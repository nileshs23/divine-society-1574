package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Students;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.StudentNotFoundException;

public class RegisterStudentForCourses {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Id:");
		int sId = sc.nextInt();
		
		System.out.println("Enter Course Id:");
		int cId = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			String res = dao.registerStudentCourse(sId,cId);
			System.out.println(res);
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
}
