package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class UpdateUserPass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username:");
		String username = sc.next();
		
		Users user = new Users(username);
		
		UsersDao dao = new UsersDaoImpl();
		
		
		try {
			String msg = dao.updateUserPass(user);
			System.out.println(msg);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
