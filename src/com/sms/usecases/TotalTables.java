package com.sms.usecases;

import java.util.List;

import com.sms.beans.Student_Course;
import com.sms.beans.Students;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;

public class TotalTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentDao dao = new StudentDaoImpl();
		
		List<Student_Course> sc = dao.searchAllStudentWithCourse();
		
		for(Student_Course s:sc) {
			System.out.println(s);
		}
				

	}

}
