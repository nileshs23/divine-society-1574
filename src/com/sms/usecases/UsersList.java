package com.sms.usecases;

import java.util.ArrayList;
import java.util.List;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.NullUserException;

public class UsersList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsersDao dao = new UsersDaoImpl();
		
		List<Users> userList = new ArrayList<>();
		
		try {
			userList = dao.searchAllUsers();

			for(Users user:userList) {
				System.out.println(user);
			}
			
		} catch (NullUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
