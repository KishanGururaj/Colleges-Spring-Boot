package com.wolken.wolkenapp.colleges.service;

import java.util.List;

import com.wolken.wolkenapp.colleges.dto.SaveStudentDTO;
import com.wolken.wolkenapp.colleges.entity.StudentEntity;

public interface StudentService {

	public boolean updateContactNoByEmailId(long phoneNo, String emailId);

	public StudentEntity updateNameByEmailId(String studentName, String emailId);

	public StudentEntity updateDetailsByEmailId(StudentEntity studentEntity);

	public List<StudentEntity> getAllByNameOrEmailOrPhoneNo(String studentName,String emailId,long phoneNo);

	public List<StudentEntity> getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(SaveStudentDTO dto);

	public String saveStudent(StudentEntity studentEntity);

	public StudentEntity saveAll(SaveStudentDTO dto);

}
