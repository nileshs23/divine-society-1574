package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class UpdateUserPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Username :");
		String username = sc.next();
		
		Users user = new Users(username);

		UsersDao dao = new UsersDaoImpl();

		String res;
		
		try {
			res = dao.updateUserPass(user);
			
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);

	}

}
