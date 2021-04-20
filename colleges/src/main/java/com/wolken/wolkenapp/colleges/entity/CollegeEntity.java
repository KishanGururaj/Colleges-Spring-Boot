package com.wolken.wolkenapp.colleges.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="college_table")
public class CollegeEntity {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name ="college_id")
	private int id;
	@Column(name ="college_name")
	private String collegeName;
	@Column(name="city_name")
	private String cityName;
	@Column(name="zip_code")
	private int zipCode;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	@JsonIgnoreProperties("collegeEntity")
	StudentEntity studentEntity;
}
