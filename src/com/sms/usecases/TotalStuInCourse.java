package com.sms.usecases;

import java.util.List;
import java.util.Scanner;

import com.sms.beans.CountStuds;
import com.sms.beans.Student_Course;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyStudentTableException;

public class TotalStuInCourse {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course Name:");
		
		
		StudentDao dao = new StudentDaoImpl();
		
		
		
		try {
			List<CountStuds> studCourseList = 
					dao.totalStudentsInCourse(sc.next());
			
			for(CountStuds studs:studCourseList) {
				System.out.println(studs);
			}
		} catch ( EmptyStudentTableException | CourseNotFoundException e) {
			System.out.println(e.getMessage());;
		}
		
		
		
		
	}
}
