package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Students;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.exceptions.StudentNotFoundException;

public class GetStudentById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Id:");
		int sid = sc.nextInt();
		
		StudentDao dao = new StudentDaoImpl();
		
		try {
			Students stu = dao.searchStudentById(sid);
			System.out.println(stu);
		} catch (StudentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
