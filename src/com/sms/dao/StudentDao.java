package com.sms.dao;

import java.util.List;

import com.sms.beans.Students;
import com.sms.exceptions.CourseNotFoundException;
import com.sms.exceptions.EmptyStudentTableException;
import com.sms.exceptions.StudentNotFoundException;

public interface StudentDao {

    public String registerStudent(Students student);
    
    public String registerStudentCourse(int studentId,int courseId) throws StudentNotFoundException, CourseNotFoundException;
    
    public Students searchStudentById(int studentId) throws StudentNotFoundException;

    public List<Students> searchAllStudent() throws EmptyStudentTableException;
    
    public String removeStudent(int studentId) throws StudentNotFoundException;

}
