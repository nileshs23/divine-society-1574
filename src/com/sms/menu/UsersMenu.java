package com.sms.menu;

import java.util.Scanner;

import com.sms.dao.UsersDao;
import com.sms.usecases.AddUsers;
import com.sms.usecases.RemoveUser;
import com.sms.usecases.UpdateUserName;
import com.sms.usecases.UpdateUserPass;
import com.sms.usecases.UsersList;

public class UsersMenu {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice=0;
		
		
		boolean userFlag = true;
		while(userFlag) {

			int n = 30;
			
			System.out.print((char)27+"[40m");
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			System.out.println("|	"+"--User Menu--"+"	 	 |");
			System.out.println("|	"+"1.Add User"+"	 	 |");
			System.out.println("|	"+"2.Delete User"+"	 	 |");
			System.out.println("|	"+"3.Forgot Password"+"	 |");
			System.out.println("|	"+"4.Update UserName"+"	 |");
			System.out.println("|	"+"5.See User's List"+"	 |");
			System.out.println("|	"+"6.Exit"+"	 		 |");
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			
			System.out.println();
			System.out.print((char)27+"[0m");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
//				 AddUsers add = new AddUsers();
				 AddUsers.main(args);
				 System.out.println();
				break;
			}
			case 2:{
//				RemoveUser remove = new RemoveUser();
				RemoveUser.main(args);
				System.out.println();
				break;
			}
			case 3:{
//				UpdateUserPass pass = new UpdateUserPass();
				UpdateUserPass.main(args);
				System.out.println();
				break;
			}
			case 4:{
//				UpdateUserName name = new UpdateUserName();
				UpdateUserName.main(args);
				System.out.println();
				break;
			}
			case 5:{
//				UsersList list1 = new UsersList();
				UsersList.main(args);
				System.out.println();
				break;
			}
			case 6:{
				userFlag =false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
		
		
	}
	
	public static void boxString(String contents) {
		
		int n = contents.length();
		
		for(int i=0;i<n+4;i++) {
			if(i==0 || i == n+3) {
				System.out.print("+");
			}else {
				System.out.print("-");
			}
		}
		System.out.println();

		System.out.println("| " + contents + " |");
		
		for(int i=0;i<n+4;i++) {
			if(i==0 || i == n+3) {
				System.out.print("+");
			}else {
				System.out.print("-");
			}
		}
		
		System.out.println();
}

}
