package com.wolken.wolkenapp.colleges.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="student_table")
public class StudentEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="student_id")
	private int id;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "dob")
	private String dob;
	@Column(name="college_name")
	private String collegeName;
	@Column(name="email_id")
	private String emailId;
	@Column(name="address")
	private String address;
	@Column(name="phone_no")
	private long phoneNo;
	
	@OneToOne
	@JsonIgnoreProperties("studentEntity")
	CollegeEntity collegeEntity;
}
