package com.wolken.wolkenapp.colleges.dto;




import lombok.Data;

@Data
public class SaveStudentDTO {
	private int id;
	private String studentName;
	private String dob;
	private String collegeName;
	private String emailId;
	private String address;
	private long phoneNo;
	private String cityName;
	

}
