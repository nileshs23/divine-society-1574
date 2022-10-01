package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class UpdateUserName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter username:");

		Scanner sc = new Scanner(System.in);
		String uname = sc.next();

		Users user = new Users(uname);

		UsersDao dao = new UsersDaoImpl();

		String res;
		
		try {
			res = dao.updateUserUsername(user);
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);

	}

}
