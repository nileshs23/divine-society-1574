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
			boxString1("ID", "CourseName", "Fees");
			for(Courses c:cL) {
				boxString2(c.getCourseId(),
						c.getCourseName(),
						c.getcourseFees());
			}
			
			for(int i=0;i<4*13;i++) {
				if(i==0 || i == 4*13-1) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			
			System.out.println();
		} catch (EmptyCourseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
public static void boxString1(String content1,String content2,String content3) {
		
		int n =13;
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
		
		for(int i=0;i<4*n;i++) {
			if(i==0) {
				System.out.print("|");
			}else if(i< n/6 && i>0 && p1flag){
				p1flag = false;
				System.out.print("	"+content1);
			}else if(i>2*n/6 && i < 4*n && p2flag) {
				p2flag = false;
				System.out.print("	"+content2);
			}else if(i>3*n/6 && i < 4*n && p3flag) {
				p3flag = false;
				System.out.print("	"+content3);
			}
		}
		System.out.println();
	}
	
	public static void boxString2(int content1,String content2,int content3) {
		
		int n =13;
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
		
		for(int i=0;i<4*n;i++) {
			if(i==0) {
				System.out.print("|");
			}else if(i< n/6 && i>0 && p1flag){
				p1flag = false;
				System.out.print("	"+content1);
			}else if(i>2*n/6 && i < 4*n && p2flag) {
				p2flag = false;
				System.out.print("	"+content2);
			}else if(i>3*n/6 && i < 4*n && p3flag) {
				p3flag = false;
				System.out.print("	"+content3);
			}
		}
		System.out.println();
	}

}
