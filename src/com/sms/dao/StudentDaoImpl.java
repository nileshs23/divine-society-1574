package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sms.beans.Students;
import com.sms.exceptions.EmptyStudentTableException;
import com.sms.exceptions.StudentNotFoundException;
import com.sms.utility.DButil;

public class StudentDaoImpl implements StudentDao {

    @Override
    public String registerStudent(Students student) {
       String msg = " Not Inserted !";
       
       try (Connection conn = DButil.provideConnection("student_mgmt")){
		PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?,?)");
		
		ps.setInt(1, student.getstudentId());
		ps.setString(2, student.getFirstName());
		ps.setString(3, student.getLastName());
		ps.setString(4,student.getCity());
		ps.setInt(5, student.getCourseId());
		
		int x = ps.executeUpdate();
		
		if(x > 0)
			msg = "Student Record Successfully Inserted...";
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
       
       return msg;
    }

    @Override
    public void searchAllStudent() throws EmptyStudentTableException{
        // TODO Auto-generated method stub
    	Students student = null;
    	
    	try (Connection conn = DButil.provideConnection("student_mgmt")) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String city = rs.getString(4);
				int courseId = rs.getInt(5);
				
				student  = new Students(id, fname, lname, city, courseId);
				System.out.println(student);
	
			}
			if(flag != true)
				throw new EmptyStudentTableException("There are no student records to display...");
			
			
		} catch (SQLException e) {
			throw new EmptyStudentTableException(e.getMessage());
		}
    	
    	

    }

	@Override
	public Students searchStudentById(int studentId) throws StudentNotFoundException {
		Students student = null;
		
		try (Connection conn = DButil.provideConnection("student_mgmt")){
			
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM students WHERE student_id=?");
			
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String city = rs.getString(4);
				int courseId = rs.getInt(5);
				
				student = new Students(id, fname, lname, city, courseId);
			}else {
				throw new StudentNotFoundException("No Records Found !");
			}
			
		} catch (SQLException e) {
			throw new StudentNotFoundException(e.getMessage());
		}
		
		return student;
	}

	@Override
	public String removeStudent(int studentId) throws StudentNotFoundException {
		String msg = null;
		
		try (Connection conn = DButil.provideConnection("student_mgmt")){
			
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM students WHERE student_id=?");
			
			ps.setInt(1, studentId);
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				msg = "Record of "+studentId +" has been deleted !";
			}else {
				throw new StudentNotFoundException("No Records Found !");
			}
			
		} catch (SQLException e) {
			throw new StudentNotFoundException(e.getMessage());
		}
		
		return msg;
	}

}
