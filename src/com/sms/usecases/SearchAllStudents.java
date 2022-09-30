package com.sms.usecases;

import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;

public class SearchAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDao dao = new StudentDaoImpl();
		
		dao.searchAllStudent();
		
	}

}
