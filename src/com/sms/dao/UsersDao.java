//use this code only for users related packages

package com.sms.dao;

import com.sms.beans.Users;

import com.sms.exceptions.NullUserException;
import com.sms.exceptions.UserNotFoundException;

public interface UsersDao {

	public String registerUsers(String username, String password);
	
	public String registerUsers2(Users user);
	
	public Users getUser(String username) throws UserNotFoundException;
	
	public void allUsers() throws NullUserException;
	
	public String deleteUser(String username);
	
	public static void useless() {
	}
	
	public String updateUserPass(Users user) throws UserNotFoundException ;
	
	public String updateUserUsername(Users user) throws UserNotFoundException;
	
	
	
}
