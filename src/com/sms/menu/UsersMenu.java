package com.sms.menu;

import com.sms.usecases.AddUsers;

public class UsersMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("....Welcome TO User Menu....");
		
		AddUsers reg = new AddUsers();
		reg.main(args);
		
	}

}
