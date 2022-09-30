package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.sms.beans.Students;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyStudentTableException;
import com.sms.exceptions.StudentNotFoundException;
import com.sms.utility.DButil;

public class StudentDaoImpl implements StudentDao {

    @Override
    public String registerStudent(Students student) {
       String msg = " Not Inserted !";
       
       try (Connection conn = DButil.provideConnection("student_mgmt")){
		PreparedStatement ps = conn.prepareStatement("INSERT INTO students VALUES (?,?,?,?)");
		
		ps.setInt(1, student.getstudentId());
		ps.setString(2, student.getFirstName());
		ps.setString(3, student.getLastName());
		ps.setString(4,student.getCity());

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
    public List<Students> searchAllStudent() throws EmptyStudentTableException{
        // TODO Auto-generated method stub
    	List<Students> students = new ArrayList<>();
    	
    	try (Connection conn = DButil.provideConnection("student_mgmt")) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String city = rs.getString(4);
				
				students.add(new Students(id, fname, lname, city));
	
			}
			
			
			
		} catch (SQLException e) {
			throw new EmptyStudentTableException(e.getMessage());
		}
    	
    	if(students.isEmpty())
			throw new EmptyStudentTableException("No student records to display...");
    	
    	
    	return students;
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
				
				student = new Students(id, fname, lname, city);
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

	@Override
	public String registerStudentCourse(int studentId,int courseId) throws StudentNotFoundException,CourseNotFoundException{
		String msg = "Not Inserted !";
		
		try (Connection conn = DButil.provideConnection("student_mgmt")){
			PreparedStatement ps = 
					conn.prepareStatement("SELECT * FROM students WHERE student_id=?");
			
			ps.setInt(1, studentId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				 PreparedStatement ps2 = 
						 conn.prepareStatement("SELECT * FROM course WHERE courseId = ?");
				
				ps2.setInt(1, courseId);
				
				ResultSet rs2 = ps2.executeQuery();
				
				
				if(rs2.next()) {
						
					PreparedStatement ps3 =  
							conn.prepareStatement
							("SELECT * FROM student_course WHERE student_id=? AND course_id = ? ");
					
					ps3.setInt(1, studentId);
					ps3.setInt(2, courseId);
					
					ResultSet rs3 = ps3.executeQuery();
					
					if(rs3.next()) {
						msg = "You are already Enrolled In this Course";
						
					}else {
						PreparedStatement ps4 = 
								conn.prepareStatement("INSERT INTO student_course VALUES (?,?)");
						
						ps4.setInt(1,studentId);
						ps4.setInt(2, courseId);
						
						int x = ps4.executeUpdate();
						
						if(x > 0)
							msg = "Student " 
								+studentId 
								+ " successfully enrolled in " 
								+ courseId;
					}
					
					
					
				}else {
					throw new CourseNotFoundException("Try Checking Courses again...");
				}
			}else {
				throw new StudentNotFoundException("Please Enroll Student First ...");
			}
			
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		return msg;
	}

}
