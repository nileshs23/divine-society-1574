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
			boxString("USERNAME", "PASSWORD");
			for(Users user:userList) {
				boxString2(user.getUsername(), user.getPassword());
				
			}
			for(int i=0;i<54;i++) {
				if(i==0 || i == 54-1) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			
//			boxString("UserName");
			
		} catch (NullUserException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		

	}
	
public static void boxString(String contents1,String content2) {
		
		int n = 27;
		for(int i=0;i<n+n;i++) {
			if(i==0 || i == n+n-1) {
				System.out.print("+");
			}else {
				System.out.print("-");
			}
		}
		System.out.println();

		boolean p1flag = true;
		boolean p2flag = true;
		
		for(int i=0;i<4*n;i++) {
			if(i==0) {
				System.out.print("|");
			}else if(i< n/6 && i>0 && p1flag){
				p1flag = false;
				System.out.print("	 "+contents1+"	     |");
			}else if(i>2*n/6 && i < 4*n && p2flag) {
				p2flag = false;
				System.out.print("	 "+content2+"	     |");
			}
		}
		System.out.println();
		
	
	}

	
	public static void boxString2(String contents1,String content2) {
		
		int n = 27;
		for(int i=0;i<n+n;i++) {
			if(i==0 || i == n+n-1) {
				System.out.print("+");
			}else {
				System.out.print("-");
			}
		}
		System.out.println();

		boolean p1flag = true;
		boolean p2flag = true;
		
		for(int i=0;i<4*n;i++) {
			if(i==0) {
				System.out.print("|");
			}else if(i< n/6 && i>0 && p1flag){
				p1flag = false;
				System.out.print(" 		"+contents1+"	      |");
			}else if(i>2*n/6 && i < 4*n && p2flag) {
				p2flag = false;
				System.out.print("		"+content2+"	      |");
			}
		}
		System.out.println();
		
	
	}

}
