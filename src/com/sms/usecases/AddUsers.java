package com.sms.usecases;

import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.dao.UsersDao;
import com.sms.dao.UsersDaoImpl;

public class AddUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Username :");
		String uname = sc.next();
		
		System.out.println("Enter Password:");
		String pass = sc.next();
		
		Users user = new Users();
		
		user.setUsername(uname);
		user.setPassword(pass);
		
		UsersDao dao = new UsersDaoImpl();
		
		String res = dao.registerUsers2(user);
		System.out.println(res);
		
		
		

	}

}
