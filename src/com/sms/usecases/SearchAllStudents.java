package com.sms.usecases;

import java.util.List;

import com.sms.beans.Students;
import com.sms.dao.StudentDao;
import com.sms.dao.StudentDaoImpl;

public class SearchAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentDao dao = new StudentDaoImpl();
		
		List<Students> studs = dao.searchAllStudent();
		for(Students s:studs) {
			System.out.println(s);
		}
		
	}

}
