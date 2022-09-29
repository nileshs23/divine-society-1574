package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.beans.Courses;
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
	public void allCourses() throws EmptyCourseException {
		
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
				System.out.println(course);
				
			}
			
			if(flag != true)
				throw new EmptyCourseException("No Courses Found ...");
			
		} catch (SQLException e) {
			throw new EmptyCourseException(e.getMessage());
		}
		
	}

}
