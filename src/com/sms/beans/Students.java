package com.sms.beans;

public class Students {

    private int studentId;
    private String firstName;
    private String lastName;
    private String city;

    public Students() {
    }

    public Students(int studentId, String firstName, String lastName, String city) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }
    
    public int getstudentId() {
        return studentId;
    }

    public void setstudentId(int studentId) {
        this.studentId = studentId;
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


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Students [studentId=");
		builder.append(studentId);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

    

}
