package com.sms.usecases;

import java.util.Scanner;

import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.StudentNotFoundException;

public class RemoveStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Id (delete):");
		int id = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			System.out.println(dao.removeStudent(id));;
		} catch (StudentNotFoundException | CourseNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
