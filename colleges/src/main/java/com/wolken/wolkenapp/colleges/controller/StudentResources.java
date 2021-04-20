package com.wolken.wolkenapp.colleges.controller;

import java.util.List;

import org.jboss.logging.Logger;
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
	Logger logger=Logger.getLogger("StudentResources");
	@PutMapping("/updateContactNoByEmailId")
	public boolean updateContactNoByEmailId(@RequestBody StudentEntity studentEntity) {
		logger.info("inside updateContactNoByEmailId inside student resources ");
		return studentService.updateContactNoByEmailId(studentEntity.getPhoneNo(),studentEntity.getEmailId());
		
	}
	@PutMapping("/updateNameByEmailId")
	public ResponseEntity<StudentEntity> updateNameByEmailId(@RequestBody StudentEntity studentEntity) {
		logger.info("inside updateNameByEmailId inside student resources ");
		StudentEntity entity= studentService.updateNameByEmailId(studentEntity.getStudentName(),studentEntity.getEmailId());
		if(entity!=null) {
			logger.info("entity is not null inside updateNameByEmailId inside student resources ");
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}else {
			logger.info("entity is  null inside updateNameByEmailId inside student resources ");
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateDetailsByEmailId")
	public ResponseEntity<StudentEntity> updateDetailsByEmailId(@RequestBody StudentEntity studentEntity) {
		logger.info("inside updateDetailsByEmailId inside student resources ");
		StudentEntity entity=studentService.updateDetailsByEmailId(studentEntity) ;
		if(entity!=null) {
			logger.info("entity is not null inside updateDetailsByEmailId inside student resources ");
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.OK);
		}else {
			logger.info("entity is null inside updateDetailsByEmailId inside student resources ");
			return new ResponseEntity<StudentEntity>(entity, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/getAllByNameOrEmail")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrEmailOrPhoneNo(@PathVariable String studentName,@PathVariable String emailId,@PathVariable long phoneNo) {
		logger.info("inside getAllByNameOrEmailOrPhoneNo inside student resources ");

		List<StudentEntity> lists= studentService.getAllByNameOrEmailOrPhoneNo( studentName, emailId, phoneNo);
		if(lists==null) {
			logger.info("lists is null inside getAllByNameOrEmailOrPhoneNo inside student resources ");
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			logger.info("lists is not null inside getAllByNameOrEmailOrPhoneNo inside student resources ");
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.OK);
		}
	}
	@PostMapping("/getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode")
	public ResponseEntity<List<StudentEntity>> getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(@RequestBody SaveStudentDTO dto){
		logger.info("inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student resources ");
		List<StudentEntity> lists= studentService.getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(dto);
		if(lists==null) {
			logger.info("lists is null inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student resources ");
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			logger.info("lists is not null inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student resources ");
			return new ResponseEntity<List<StudentEntity>>(lists, HttpStatus.OK);
		}
	}
	@PostMapping("/saveStudent")
	public ResponseEntity<String> save(@RequestBody StudentEntity studentEntity){
		logger.info("inside save of student inside student resources ");
		String res=studentService.saveStudent(studentEntity);
		if(res!=null) {
			logger.info("res is not null inside save of student inside student resources ");
			return new ResponseEntity<String>(res,HttpStatus.OK);
		}
		else {
			logger.info("res is null inside save of student inside student resources ");
			return new ResponseEntity<String>(res,HttpStatus.BAD_REQUEST);
			}
		}
	@PostMapping("/saveDto")
	public ResponseEntity<StudentEntity>saveAll(@RequestBody SaveStudentDTO dto) {
		logger.info("inside saveAll of student inside student resources ");
		StudentEntity res=studentService.saveAll(dto);
		if(res!=null) {
		logger.info("res is not null inside saveAll of student inside student resources ");
		return new ResponseEntity<StudentEntity>(res,HttpStatus.OK);
		}
		else {
			logger.info("res is null inside saveAll of student inside student resources ");
			return new ResponseEntity<StudentEntity>(res,HttpStatus.BAD_REQUEST);
		}
	}
}
