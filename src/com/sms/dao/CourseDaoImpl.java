package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sms.beans.Courses;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyCourseException;
import com.sms.utility.DButil;

public class CourseDaoImpl implements CourseDao{

	@Override
	public String registerCourse(Courses course) {
		String msg = "Not Added yet !";
		
		try (Connection conn = DButil.provideConnection("student_mgmt")){
			
			PreparedStatement ps = 
					conn.prepareStatement("INSERT INTO course values(?,?,?)");
			
			ps.setInt(1, course.getCourseId());
			ps.setString(2, course.getCourseName());
			ps.setInt(3, course.getcourseFees());

			int x = ps.executeUpdate();
			
			if(x > 0)
				msg = "Course Added Successfully !";
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	
	@Override
	public List<Courses> searchAllCourses() throws EmptyCourseException {
		
		List<Courses> courseList = new ArrayList<>();
		
		try (Connection conn = DButil.provideConnection("student_mgmt")) {
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM course");
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int fee = rs.getInt(3);
				
				Courses course = new Courses(id,name,fee);
				
				courseList.add(course);
				
				
			}
			
			if(flag != true)
				throw new EmptyCourseException("No Courses Found ...");
			
		} catch (SQLException e) {
			throw new EmptyCourseException(e.getMessage());
		}
		
		
		return courseList;
	}


	@Override
	public String deleteCourse(String courseName) throws CourseNotFoundException {
		String msg = "No Records Found !";
		
		try (Connection conn = DButil.provideConnection("student_mgmt")) {
			
			PreparedStatement ps = 
					conn.prepareStatement(" DELETE FROM course WHERE courseName = ?");
			
			ps.setString(1,courseName);
			
			int x = ps.executeUpdate();
			
			boolean flag = false;
			
			if(x > 0)
				flag = true;
				msg = x + " Records Successfully Deleted...";
			
			if(flag != true)
				throw new CourseNotFoundException("No Course Found !");
			
		} catch (SQLException e) {
			throw new CourseNotFoundException(e.getMessage());
		}
		
		return msg;
	}


	@Override
	public String updateCourseName(Courses course) throws CourseNotFoundException {
		String msg = "Course Name not updated...";
		
		PreparedStatement ps;
		try(Connection conn = DButil.provideConnection("student_mgmt")) {
			
			ps = conn.prepareStatement(" SELECT * FROM course WHERE courseId =?");
			
			ps.setInt(1, course.getCourseId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = conn.prepareStatement("UPDATE course SET coursename=? WHERE courseId=? ");
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter new CourseName");
				
				ps.setString(1, sc.next());
				ps.setInt(2, course.getCourseId());
				
				int x = ps.executeUpdate();
				
				if(x > 0)
					msg = x+" Records Successfully updated...";
			}else {
				throw new CourseNotFoundException("Try Entering correct CourseId...");
			}

		} catch (SQLException e) {
			throw new CourseNotFoundException(e.getMessage());
		}
		
		return msg;
	}


	@Override
	public String updateCourseFees(Courses course) throws CourseNotFoundException {
		String msg = "Course Fees not updated...";
		
		PreparedStatement ps;
		try(Connection conn = DButil.provideConnection("student_mgmt")) {
			
			ps = conn.prepareStatement(" SELECT * FROM course WHERE coursename =?");
			
			ps.setString(1, course.getCourseName());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				ps = conn.prepareStatement("UPDATE course SET coursefee=? WHERE courseName=? ");
				
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter new Course Fees:");
				
				ps.setInt(1, sc.nextInt());
				ps.setString(2, course.getCourseName());
				
				int x = ps.executeUpdate();
				
				if(x > 0)
					msg = x+" Records Successfully updated...";
			}else {
				throw new CourseNotFoundException("Try Entering correct Course Name...");
			}

		} catch (SQLException e) {
			throw new CourseNotFoundException(e.getMessage());
		}
		
		return msg;
	}

}
