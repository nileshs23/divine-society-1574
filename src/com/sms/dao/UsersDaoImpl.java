package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.beans.Users;
import com.sms.exceptions.UserNotFoundException;
import com.sms.utility.DButil;

public class UsersDaoImpl implements UsersDao{

	@Override
	public String registerUsers(String username, String password) {
		String msg = "Not Inserted Any Record !";
		
		 try (Connection conn = DButil.provideConnection("userdetails_db")) {
			 
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO userdetails (username,password) VALUES(?,?) ");
			
			ps.setString(1,username);
			ps.setString(2, password);
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				msg = "User Registered Successfully !";
			 
			
		} catch (SQLException sqle) {
			// TODO: handle exception
			msg = sqle.getMessage();
		}
		
		
		
		return msg;
	}

	@Override
	public String registerUsers2(Users user) {

		String msg = "Not Inserted Any Record !";
		
		 try (Connection conn = DButil.provideConnection("userdetails_db")) {
			 
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO userdetails (username,password) VALUES(?,?) ");
			
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				msg = "User Registered Successfully !";
			 
			
		} catch (SQLException sqle) {
			// TODO: handle exception
			msg = sqle.getMessage();
		}
		 
		 
		return msg;
	}
	

	@Override
	public Users getUser(String username) throws UserNotFoundException {
		Users user = null;
		
		try (Connection conn = DButil.provideConnection("userdetails_db")) {
			
//			System.out.println("connected");
			
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM userdetails WHERE username = ?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				String un = rs.getString("username");
				String up = rs.getString("password");
				
				user = new Users(un,up);
				
			}else {
				throw new UserNotFoundException("User Not Found !");
			}
			
		} catch (SQLException e) {
//			e.getMessage();
			throw new UserNotFoundException(e.getMessage());
		}
		
		
		return user;
	}

}