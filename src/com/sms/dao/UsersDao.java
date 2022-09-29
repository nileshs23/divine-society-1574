package com.sms.dao;

import com.sms.beans.Users;
import com.sms.exceptions.UserNotFoundException;

public interface UsersDao {

	public String registerUsers(String username, String password);
	
	public String registerUsers2(Users user);
	
	public Users getUser(String username) throws UserNotFoundException;
}