package com.wolken.wolkenapp.colleges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.colleges.dto.SaveStudentDTO;
import com.wolken.wolkenapp.colleges.entity.StudentEntity;
import com.wolken.wolkenapp.colleges.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentResources {
	@Autowired
	StudentService studentService;
	@PutMapping("/updateContactNoByEmailId")
	public ResponseEntity<Boolean> updateContactNoByEmailId(@RequestBody StudentEntity studentEntity) {
		boolean status= studentService.updateContactNoByEmailId(studentEntity.getPhoneNo(),studentEntity.getEmailId());
		if(status==true) {
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(status, HttpStatus.FAILED_DEPENDENCY);
		}
	}
	@PutMapping("/updateNameByEmailId")
	public ResponseEntity<StudentEntity> updateNameByEmailId(@RequestBody StudentEntity studentEntity) {
		StudentEntity entity= studentService.updateNameByEmailId(studentEntity.getStudentName(),studentEntity.getEmailId());
		if(entity!=null) {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}else {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateDetailsByEmailId")
	public ResponseEntity<StudentEntity> updateDetailsByEmailId(@RequestBody StudentEntity studentEntity) {
		StudentEntity entity=studentService.updateDetailsByEmailId(studentEntity) ;
		if(entity!=null) {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}else {
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/getAllByNameOrEmail")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrEmailOrPhoneNo(@PathVariable String studentName,@PathVariable String emailId,@PathVariable long phoneNo) {
		List<StudentEntity> lists= studentService.getAllByNameOrEmailOrPhoneNo( studentName, emailId, phoneNo);
		if(lists==null) {
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.OK);
		}
	}
	@PostMapping("/getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(@RequestBody SaveStudentDTO dto){
		List<StudentEntity> lists= studentService.getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(dto);
		if(lists==null) {
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.OK);
		}
	}
}
