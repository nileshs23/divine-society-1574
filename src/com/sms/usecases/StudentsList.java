package com.sms.usecases;

import java.util.ArrayList;
import java.util.List;

import com.sms.beans.Students;
import com.sms.beans.Users;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.NullUserException;

public class StudentsList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		boxString2("Hello","Niels", "Str1" ,"Str2");
		
		StudentDao dao = new StudentDaoImpl();
		
		List<Students> studentList = new ArrayList<>();
		
		try {
			studentList = dao.AllStudents();
			boxString2(1,"First","Last","City") ;
			for(Students student:studentList) {
//				System.out.println(student);
				boxString2(student.getstudentId() 
						,student.getFirstName()
						,student.getLastName() 
						,student.getCity());
			}
			
			for(int i=0;i<4*16;i++) {
				if(i==0 || i == 4*16-1) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			
		}catch (Exception e) {
			// TODO: handle exception\
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void boxString2(int content1,String content2,String content3,String content4) {
		
		int n =16;
		for(int i=0;i<4*n;i++) {
			if(i==0 || i == 4*n-1) {
				System.out.print("+");
			}else {
				System.out.print("-");
			}
		}
		System.out.println();

		boolean p1flag = true;
		boolean p2flag = true;
		boolean p3flag = true;
		boolean p4flag = true;
		
		for(int i=0;i<4*n;i++) {
			if(i==0) {
				System.out.print("|");
			}else if(i< n/6 && i>0 && p1flag){
				p1flag = false;
				System.out.print("	"+content1+"	|");
			}else if(i>2*n/6 && i < 4*n && p2flag) {
				p2flag = false;
				System.out.print("	"+content2+"	|");
			}else if(i>3*n/6 && i < 4*n && p3flag) {
				p3flag = false;
				System.out.print("	"+content3+"	|");
			}else if(i>4*n/6 && i < 4*n && p4flag) {
				p4flag = false;
				System.out.print("	"+content4+"	|");
			}
		}
		System.out.println();
		
		
//		System.out.println();
	}
	

}
