package com.sms.dao;

import java.util.List;

import com.sms.beans.CountStuds;
import com.sms.beans.Student_Course;
import com.sms.beans.Students;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyStudentTableException;
import com.sms.exceptions.StudentNotFoundException;

public interface StudentDao {

    public String registerStudent(Students student);
    
    public String registerStudentCourse(int studentId,int courseId) throws StudentNotFoundException, CourseNotFoundException;
    
    public Students searchStudentById(int studentId) throws StudentNotFoundException;

    public List<Student_Course> searchAllStudentWithCourse() throws EmptyStudentTableException;
    
    public List<Students> AllStudents() throws EmptyStudentTableException;
    
    public List<CountStuds> totalStudentsInCourse(String courseName)  throws EmptyStudentTableException,CourseNotFoundException;
    
    public String removeStudent(int studentId) throws StudentNotFoundException,CourseNotFoundException;

    
}

//1.add student ~
//2.addStudentSInCourse --- used nested if else ~
//3.AllStudents ~
//4.Remove Student -- added constraints ~
//5. search by id ~
//6.UpdateStudentName 
//7.UpdateStudentFees
//total students in course  ~