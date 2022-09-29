package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sms.beans.Users;
import com.sms.exceptions.NullUserException;
import com.sms.exceptions.UserNotFoundException;
import com.sms.utility.DButil;

public class UsersDaoImpl implements UsersDao {

	@Override
	public String registerUsers(String username, String password) {
		String msg = "Not Inserted Any Record !";

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username,password) VALUES(?,?) ");

			ps.setString(1, username);
			ps.setString(2, password);

			int x = ps.executeUpdate();

			if (x > 0)
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

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			PreparedStatement ps = conn.prepareStatement("INSERT INTO users (username,password) VALUES(?,?) ");

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());

			int x = ps.executeUpdate();

			if (x > 0)
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

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			// System.out.println("connected");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				String un = rs.getString("username");
				String up = rs.getString("password");

				user = new Users(un, up);

			} else {
				throw new UserNotFoundException("User Not Found !");
			}

		} catch (SQLException e) {
			// e.getMessage();
			throw new UserNotFoundException(e.getMessage());
		}

		return user;
	}

	@Override
	public String deleteUser(String username) {
		String msg = "No Track Record Found";

		try (Connection conn = DButil.provideConnection("student_mgmt")) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE username=?");
			ps.setString(1, username);

			int x = ps.executeUpdate();

			if (x > 0)
				msg = "Successfully Deleted...";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

		return msg;
	}

	@Override
	public void allUsers() throws NullUserException {

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");

			ResultSet rs = ps.executeQuery();
			boolean flag = false;

			while (rs.next()) {
				System.out.println("as");
				flag = true;

				String username = rs.getString(1);
				String password = rs.getString(2);

				Users user = new Users(username, password);
				System.out.println(user);
			}

			if (flag != true)
				throw new NullUserException("Trying To access Empty Database.");

		} catch (SQLException e) {
			throw new NullUserException(e.getMessage());
		}

	}

	@Override
	public String updateUserPass(Users user) throws UserNotFoundException {
		String msg = " Password Not Changed !";

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

			ps.setString(1, user.getUsername());

			ResultSet rs = ps.executeQuery();

			boolean flag = false;

			while (rs.next()) {

				flag = true;

				System.out.println("'" + user.getUsername().toUpperCase() + "'" + " has Found...");

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Password (change pass):");
				String pass = sc.next();

				PreparedStatement ps2 = conn.prepareStatement("UPDATE users SET password=? WHERE username=?");

				ps2.setString(1, pass);
				ps2.setString(2, user.getUsername());

				int x2 = ps2.executeUpdate();

				if (x2 > 0)
					msg = "Password Has Changed Successfully !";

			}

			if (flag != true)
				throw new UserNotFoundException("User Not Found !");

		} catch (SQLException e) {
			// e.getMessage();
			throw new UserNotFoundException(e.getMessage());
		}

		return msg;

	}

	@Override
	public String updateUserUsername(Users user) throws UserNotFoundException {
		String msg = " Username Not Changed !";

		try (Connection conn = DButil.provideConnection("student_mgmt")) {

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");

			ps.setString(1, user.getUsername());

			ResultSet rs = ps.executeQuery();

			boolean flag = false;

			while (rs.next()) {

				flag = true;

				System.out.println("'" + user.getUsername().toUpperCase() + "'" + " has Found...");

				Scanner sc = new Scanner(System.in);
				System.out.println("Enter username (change username):");
				String un = sc.next();

				PreparedStatement ps2 = conn.prepareStatement("UPDATE users SET username=? WHERE username=?");

				ps2.setString(1, un);
				ps2.setString(2, user.getUsername());

				int x2 = ps2.executeUpdate();

				if (x2 > 0)
					msg = "Username Has Changed Successfully !";

			}

			if (flag != true)
				throw new UserNotFoundException("User Not Found !");

		} catch (SQLException e) {
			// e.getMessage();
			throw new UserNotFoundException(e.getMessage());
		}

		return msg;
	}

}
