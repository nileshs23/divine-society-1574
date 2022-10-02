package com.sms.menu;

import java.util.Scanner;

import com.sms.usecases.AddCourse;
import com.sms.usecases.CourseList;
import com.sms.usecases.RemoveCourse;
import com.sms.usecases.UpdateCourseFees;
import com.sms.usecases.UpdateCourseName;

public class CourseMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice=0;
	
		boolean userFlag = true;
		while(userFlag) {
			
			int n = 30;
			System.out.print((char)27+"[45m");
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			
			System.out.println("|	"+"-- Course Menu --"+"	 |");
			System.out.println("|	"+"1.Add Course"+"		 |");
			System.out.println("|	"+"2.Delete Course"+"		 |");
			System.out.println("|	"+"3.Update Course Name"+"	 |");
			System.out.println("|	"+"4.Update Course Fees"+"	 |");
			System.out.println("|	"+"5.See Course's List"+"	 |");
			System.out.println("|	"+"6.Exit"+"		 	 |");
			
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			System.out.print((char)27+"[0m");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
//				 AddCourse add = new AddCourse();
				 AddCourse.main(args);
				 System.out.println();
				break;
			}
			case 2:{
//				RemoveCourse remove = new RemoveCourse();
				RemoveCourse.main(args);
				System.out.println();
				break;
			}
			case 3:{
//				UpdateCourseName name = new UpdateCourseName();
				UpdateCourseName.main(args);
				System.out.println();
				break;
			}
			case 4:{
//				UpdateCourseFees fees = new UpdateCourseFees();
				UpdateCourseFees.main(args);
				System.out.println();
				break;
			}
			case 5:{
//				CourseList list2 = new CourseList();
				CourseList.main(args);
				System.out.println();
				break;
			}
			case 6:{
				userFlag =false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
	}
	
	public static void boxString(String contents) {
			
			int n = contents.length();
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
	
			System.out.println("| " + contents + " |");
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			
			System.out.println();
	}
}
