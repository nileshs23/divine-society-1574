package com.sms.menu;

import java.util.Scanner;


import com.sms.usecases.AddStudent;
import com.sms.usecases.AddStudentForCourses;
import com.sms.usecases.RemoveStudent;
import com.sms.usecases.SearchStudentById;
import com.sms.usecases.TotalStuInCourse;
import com.sms.usecases.TotalTables;


public class StudentMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

int choice=0;
		
		
		
		boolean userFlag = true;
		while(userFlag) {
			System.out.println("....Welcome TO Student Menu....");
			System.out.println("1.Add Student");
			System.out.println("2.Add Student For Course");
			System.out.println("3.Delete Studentt");
			System.out.println("4.Search Student");
			System.out.println("5.Students List");
			System.out.println("6.Total Student In course");
			System.out.println("7.Exit");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
//				 AddStudent add = new AddStudent();
				 AddStudent.main(args);
				 System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 2:{
//				AddStudentForCourses addCourse = new AddStudentForCourses();
				AddStudentForCourses.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 3:{
//				RemoveStudent remove = new RemoveStudent();
				RemoveStudent.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 4:{
//				SearchStudentById search = new SearchStudentById();
				SearchStudentById.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 5:{
//				TotalTables list3 = new TotalTables();
				TotalTables.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 6:{
//				TotalStuInCourse list4 = new TotalStuInCourse();
				TotalStuInCourse.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 7:{
				userFlag =false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}

}
