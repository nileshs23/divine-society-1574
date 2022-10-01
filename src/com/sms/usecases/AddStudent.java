package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Students;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;

public class AddStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Id :");
		int id = sc.nextInt();
		
		System.out.println("Enter Student First Name:");
		String fname = sc.next();
		
		System.out.println("Enter Student Last Name:");
		String lname = sc.next();
		
		System.out.println("Enter Student City:");
		String city = sc.next();
		
		Students student  = new Students(id, fname, lname, city);
		
		StudentDao dao = new StudentDaoImpl();
		
		String res = dao.registerStudent(student);
		System.out.println(res);

	}

}
