package com.sms.beans;

public class Student {

    private int studetnId;
    private String firstName;
    private String lastName;
    private String city;
    private int courseId;

    public Student() {
    }

    public Student(int studetnId, String firstName, String lastName, String city, int courseId) {
        this.studetnId = studetnId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.courseId = courseId;
    }

    public int getStudetnId() {
        return studetnId;
    }

    public void setStudetnId(int studetnId) {
        this.studetnId = studetnId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Student [city=" + city + ", courseId=" + courseId + ", firstName=" + firstName + ", lastName="
                + lastName + ", studetnId=" + studetnId + "]";
    }

}
