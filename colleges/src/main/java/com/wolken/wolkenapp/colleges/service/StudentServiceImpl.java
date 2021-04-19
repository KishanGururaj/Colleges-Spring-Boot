package com.wolken.wolkenapp.colleges.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.colleges.dto.SaveStudentDTO;
import com.wolken.wolkenapp.colleges.entity.StudentEntity;
import com.wolken.wolkenapp.colleges.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository repository;
	Logger logger=Logger.getLogger("StudentServiceImpl");
	@Override
	public boolean updateContactNoByEmailId(long phoneNo, String emailId) {
		// TODO Auto-generated method stub
		logger.info("inside update contact no by email id");
		if(emailId!=null) {
			logger.info("emailId is not null inside update contact no by email id");
			StudentEntity studentEntity=repository.findByEmailId(emailId);
			if(studentEntity!=null) {
				logger.info("student entity is found inside update contact no by email id");
				studentEntity.setPhoneNo(phoneNo);
				repository.save(studentEntity);
				return true;
			}else {
				logger.info(" student entity is not found inside update contact no by email id");
			}
		}
		logger.info("email id is null inside update contact no by email id");
		return false;
	}
	@Override
	public StudentEntity updateNameByEmailId(String studentName, String emailId) {
		// TODO Auto-generated method stub
		logger.info("inside update name by email id");
		if(emailId!=null) {
			logger.info("emailId is not null inside update name by email id");
			StudentEntity studentEntity=repository.findByEmailId(emailId);
			if(studentEntity!=null) {
				logger.info("student entity is found inside update name by email id");
				studentEntity.setStudentName(studentName);
				repository.save(studentEntity);
				return studentEntity;
			}else {
				logger.info(" student entity is not found inside update name by email id");
			}
		}
		logger.info("email id is null inside update name by email id");
		return null;
	}
	@Override
	public StudentEntity updateDetailsByEmailId(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		logger.info("inside update details by email id");
		if(studentEntity.getEmailId()!=null) {
			logger.info("emailId is not null inside update details by email id");
			StudentEntity entity=repository.findByEmailId(studentEntity.getEmailId());
			if(entity!=null) {
				logger.info("student entity is found inside update details by email id");
				entity.setPhoneNo(studentEntity.getPhoneNo());
				entity.setAddress(studentEntity.getAddress());
				entity.setDob(studentEntity.getDob());
				repository.save(studentEntity);
				return studentEntity;
			}else {
				logger.info(" student entity is not found inside update details by email id");
			}
		}
		logger.info("email id is null inside update details by email id");
		return null;
	}
	@Override
	public List<StudentEntity> getAllByNameOrEmailOrPhoneNo(String studentName,String emailId,long phoneNo) {
		// TODO Auto-generated method stub
		if(studentName!=null||emailId!=null||phoneNo>0) {
			return repository.getAllByStudentNameOrEmailIdOrPhoneNo(studentName,emailId,phoneNo);
		}
		return null;
	}
	@Override
	public List<StudentEntity> getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(SaveStudentDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
