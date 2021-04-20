package com.wolken.wolkenapp.colleges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenapp.colleges.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	public StudentEntity findByEmailId(String emailId);
	public List<StudentEntity> findByStudentNameOrEmailIdOrPhoneNo(String studentName,String emailId,long phoneNo);
	public List<StudentEntity> findByStudentNameOrEmailIdOrDob(String studentName,String emailId, String dob);
}
