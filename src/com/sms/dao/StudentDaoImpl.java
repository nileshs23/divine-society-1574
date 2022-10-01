package com.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;
import com.sms.beans.CountStuds;
import com.sms.beans.Student_Course;
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
    public List<Student_Course> searchAllStudentWithCourse() throws EmptyStudentTableException{
        // TODO Auto-generated method stub
    	List<Student_Course> stuCourse = new ArrayList<>();
    	
    	try (Connection conn = DButil.provideConnection("student_mgmt")) {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT s.student_id,s.first_name,s.last_name,s.city,"
							+ "sc.course_id, "
							+ "c.courseName,c.courseFee "
							+ "FROM ((students s "
							+ "INNER JOIN student_course sc ON s.student_id = sc.student_id) "
							+ "INNER JOIN course c ON sc.course_id = c.courseID);");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int stu_id = rs.getInt(1);
				String stu_fname = rs.getString(2);
				String stu_lname = rs.getString(3);
				String stu_city = rs.getString(4);
				int courseId = rs.getInt(5);
				String courseName = rs.getString(6);
				int courseFee = rs.getInt(7);
				
				
				stuCourse.add(new Student_Course(stu_id, stu_fname, stu_lname, stu_city,courseId,courseName,courseFee));
	
			}
			
			
			
		} catch (SQLException e) {
			throw new EmptyStudentTableException(e.getMessage());
		}
    	
    	if(stuCourse.isEmpty())
			throw new EmptyStudentTableException("No student records to display...");
    	
    	
    	return stuCourse;
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
	public String removeStudent(int studentId) throws StudentNotFoundException,CourseNotFoundException {
		String msg = "No Records Found !";
		
		try (Connection conn = DButil.provideConnection("student_mgmt")){
			
			PreparedStatement ps = 
					conn.prepareStatement("DELETE FROM students WHERE student_id=?");
			
			ps.setInt(1, studentId);
			
			int x = ps.executeUpdate();
			
			if(x > 0)
				msg = "Record of "+studentId +" has been deleted !";
			
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

	
	@Override
	public List<CountStuds> totalStudentsInCourse(String courseName)  throws EmptyStudentTableException{
		
		ArrayList<CountStuds> stuList = new ArrayList<>();

    	try (Connection conn = DButil.provideConnection("student_mgmt")) {
			PreparedStatement ps = 
					conn.prepareStatement("SELECT COUNT(*),sc.course_id,c.courseName "
							+ "FROM ((students s INNER JOIN student_course sc ON s.student_id = sc.student_id) "
							+ "INNER JOIN course c ON sc.course_id = c.courseID  AND c.courseName=?)");
							
			
			ps.setString(1, courseName);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int totals = rs.getInt(1);
				int id = rs.getInt(2);
				String course = rs.getString(3);
				

				stuList.add(new CountStuds(course, id, totals));
	
			}
			
			
			
		} catch (SQLException e) {
			throw new EmptyStudentTableException(e.getMessage());
		}
    	
    	if(stuList.isEmpty())
			throw new EmptyStudentTableException("No student records to display...");

		
		return stuList;
	}

}
