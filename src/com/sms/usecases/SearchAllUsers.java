package com.sms.usecases;

import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.NullUserException;

public class SearchAllUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsersDao dao = new UsersDaoImpl();
		
		try {
			dao.allUsers();
		} catch (NullUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
