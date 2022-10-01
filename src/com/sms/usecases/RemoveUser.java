package com.sms.usecases;

import java.util.Scanner;

import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class RemoveUser {
	
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username (DELETE):");
		String uname = sc.next();
		
		UsersDao dao = new UsersDaoImpl();

		
		String res;
		try {
			res = dao.deleteUser(uname);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			res = e.getMessage();
		}
		
		System.out.println(res);
		

		
		
	}

}
