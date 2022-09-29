package com.sms.usecases;

import java.util.Scanner;

import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;
import com.sms.exceptions.UserNotFoundException;

public class RemoveUser {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username (delete):");
		String uname = sc.next();
		
		UsersDao dao = new UsersDaoImpl();

		
		String res = dao.deleteUser(uname);
		System.out.println(res);

		
		
	}

}
