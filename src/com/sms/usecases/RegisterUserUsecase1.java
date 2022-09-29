package com.sms.usecases;

import java.util.Scanner;

import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;

public class RegisterUserUsecase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username :");
		String uname = sc.next();

		System.out.println("Enter Passwrod :");
		String pass = sc.next();
		
		
		UsersDao dao = new UsersDaoImpl();
		
		
		String res = dao.registerUsers(uname,pass);
		
		System.out.println(res);
		
		
		
		
		
	}

}
