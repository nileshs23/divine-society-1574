package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.sms.beans.Courses;
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

}
