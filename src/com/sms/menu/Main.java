package com.sms.menu;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		boolean menuFlag = true;
		
		while(menuFlag) {
			int n= 30;
			
			System.out.print((char)27+"[46m");
			
			for(int i=0;i<n+4;i++) {
				if(i==0 || i == n+3) {
					System.out.print("+");
				}else {
					System.out.print("-");
				}
			}
			System.out.println();
			
			System.out.println("|	"+"--Main Menu--"+"		 |");
			System.out.println("|	"+"1.User's Menu"+"		 |");
			System.out.println("|	"+"2.Course Menu"+"		 |");
			System.out.println("|	"+"3.Students Menu"+"		 |");
			System.out.println("|	"+"4.Exit Application"+"	 |");
			System.out.print((char)27+"[0m");
			System.out.println((char)27+"[5;46;30m|	"+" © Nilesh Solanki"+"	 |"+(char)27+"[0m");

			
			System.out.print((char)27+"[46m");
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
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				UsersMenu.main(args);
				break;
			}
			case 2: {
				CourseMenu.main(args);
				break;
			}
			case 3: {
				StudentMenu.main(args);
				break;
			}
			case 4: {
				menuFlag = false;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
			
			
		}
		
		if(menuFlag != true) {
			System.out.println("Thank You For Checking Out...");
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
