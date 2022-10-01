package com.sms.usecases;

import java.util.Scanner;

import com.sms.dao.CourseDao;
import com.sms.dao.CourseDaoImpl;
import com.sms.exceptions.CourseNotFoundException;

public class RemoveCourse {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter CourseName (DELETE):");
		String cName = sc.next();
		
		CourseDao dao = new CourseDaoImpl() ;
		
		String res;
		
		try {
			res = dao.deleteCourse(cName);
		} catch (CourseNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);
	}
	

}
