package com.sms.menu;

import java.util.Scanner;


import com.sms.usecases.AddStudent;
import com.sms.usecases.AddStudentForCourses;
import com.sms.usecases.RemoveStudent;
import com.sms.usecases.SearchStudentById;
import com.sms.usecases.StudentsList;
import com.sms.usecases.TotalStuInCourse;
import com.sms.usecases.TotalTables;


public class StudentMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int choice=0;

		boolean userFlag = true;
		while(userFlag) {
			

			int n = 37;
			
			System.out.print((char)27+"[37;40m");
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			
			System.out.println("|	"+"--Student Menu--"+"	 	|");
			System.out.println("|	"+"1.Add Student "+"	 	   	|");
			System.out.println("|	"+"2.Add Student For Course"+" 	|");
			System.out.println("|	"+"3.Delete Student"+"	 	|");
			System.out.println("|	"+"4.Search Student"+"	 	|");
			System.out.println("|	"+"5.Students List"+"	 		|");
			System.out.println("|	"+"6.Students List With Course"+"	|");
			System.out.println("|	"+"7.Total Student In course"+"	|");
			System.out.println("|	"+"8.Exit"+"	 	 		|");
			
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
//				 AddStudent add = new AddStudent();
				 AddStudent.main(args);
				 System.out.println();
				break;
			}
			case 2:{
//				AddStudentForCourses addCourse = new AddStudentForCourses();
				AddStudentForCourses.main(args);
				System.out.println();
				break;
			}
			case 3:{
//				RemoveStudent remove = new RemoveStudent();
				RemoveStudent.main(args);
				System.out.println();
				break;
			}
			case 4:{
//				SearchStudentById search = new SearchStudentById();
				SearchStudentById.main(args);
				System.out.println();
				break;
			}
			case 5:{
//				StudentsList list4 = new StudentsList();
				StudentsList.main(args);
				System.out.println();
				break;
			}
			case 6:{
//				TotalTables list3 = new TotalTables();
				TotalTables.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 7:{
//				TotalStuInCourse list4 = new TotalStuInCourse();
				TotalStuInCourse.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 8:{
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
