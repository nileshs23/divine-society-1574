package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class GetUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Username:");
		String username = sc.next();
		
		UsersDao dao = new UsersDaoImpl();
		
		try {
			Users user = dao.getUser(username);
			System.out.println(user);
		} catch (UserNotFoundException unfe) {
			// TODO Auto-generated catch block
			System.out.println(unfe.getMessage());
		}

	}

}
