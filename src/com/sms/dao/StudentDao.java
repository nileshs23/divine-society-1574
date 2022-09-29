package com.sms.dao;

import com.sms.beans.Student;

public interface StudentDao {

    public String registerStudent(Student student);

    public void searchAllStudent();

}
