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
			System.out.println("....Welcome TO Course Menu....");
			System.out.println("1.Add Course");
			System.out.println("2.Delete Course");
			System.out.println("3.Update Course Name");
			System.out.println("4.Update Course Fees");
			System.out.println("5.See Course's List");
			System.out.println("6.Exit");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
//				 AddCourse add = new AddCourse();
				 AddCourse.main(args);
				 System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 2:{
//				RemoveCourse remove = new RemoveCourse();
				RemoveCourse.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 3:{
//				UpdateCourseName name = new UpdateCourseName();
				UpdateCourseName.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 4:{
//				UpdateCourseFees fees = new UpdateCourseFees();
				UpdateCourseFees.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 5:{
//				CourseList list2 = new CourseList();
				CourseList.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
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

}
