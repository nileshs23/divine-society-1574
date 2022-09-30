package com.sms.dao;

import com.sms.beans.Students;
import com.sms.exceptions.EmptyStudentTableException;
import com.sms.exceptions.StudentNotFoundException;

public interface StudentDao {

    public String registerStudent(Students student);
    
    public Students searchStudentById(int studentId) throws StudentNotFoundException;

    public void searchAllStudent() throws EmptyStudentTableException;
    
    public String removeStudent(int studentId) throws StudentNotFoundException;

}
