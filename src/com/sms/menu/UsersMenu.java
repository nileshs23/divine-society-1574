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
		
//		System.out.println("....Welcome TO User Menu....");
//		System.out.println("1.Add User");
//		System.out.println("2.Delete User");
//		System.out.println("3.Forgot Password");
//		System.out.println("4.Forgot UserName");
//		System.out.println("5.See User's List");
//		System.out.println("6.Exit");
		
		
		
		boolean userFlag = true;
		while(userFlag) {
			System.out.println("....Welcome TO User Menu....");
			System.out.println("1.Add User");
			System.out.println("2.Delete User");
			System.out.println("3.Forgot Password");
			System.out.println("4.Update UserName");
			System.out.println("5.See User's List");
			System.out.println("6.Exit");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				 AddUsers add = new AddUsers();
				 add.main(args);
				 System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 2:{
				RemoveUser remove = new RemoveUser();
				remove.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 3:{
				UpdateUserPass pass = new UpdateUserPass();
				pass.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 4:{
				UpdateUserName name = new UpdateUserName();
				name.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
				break;
			}
			case 5:{
				UsersList list1 = new UsersList();
				list1.main(args);
				System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
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

}
