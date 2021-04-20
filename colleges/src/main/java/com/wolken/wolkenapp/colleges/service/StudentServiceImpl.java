package com.wolken.wolkenapp.colleges.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.colleges.dto.SaveStudentDTO;
import com.wolken.wolkenapp.colleges.entity.CollegeEntity;
import com.wolken.wolkenapp.colleges.entity.StudentEntity;
import com.wolken.wolkenapp.colleges.repository.CollegeRepository;
import com.wolken.wolkenapp.colleges.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;
	@Autowired
	CollegeRepository collegeRepository;
	Logger logger = Logger.getLogger("StudentServiceImpl");

	@Override
	public boolean updateContactNoByEmailId(long phoneNo, String emailId) {
		// TODO Auto-generated method stub
		logger.info("inside update contact no by email id");
		if (emailId != null) {
			logger.info("emailId is not null inside update contact no by email id");
			StudentEntity studentEntity = repository.findByEmailId(emailId);
			if (studentEntity != null) {
				logger.info("student entity is found inside update contact no by email id");
				studentEntity.setPhoneNo(phoneNo);
				repository.save(studentEntity);
				return true;
			} else {
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
		if (emailId != null) {
			logger.info("emailId is not null inside update name by email id");
			StudentEntity studentEntity = repository.findByEmailId(emailId);
			if (studentEntity != null) {
				logger.info("student entity is found inside update name by email id");
				studentEntity.setStudentName(studentName);
				repository.save(studentEntity);
				return studentEntity;
			} else {
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
		if (studentEntity.getEmailId() != null) {
			logger.info("emailId is not null inside update details by email id");
			StudentEntity entity = repository.findByEmailId(studentEntity.getEmailId());
			if (entity != null) {
				logger.info("student entity is found inside update details by email id");
				entity.setPhoneNo(studentEntity.getPhoneNo());
				entity.setAddress(studentEntity.getAddress());
				entity.setDob(studentEntity.getDob());
				repository.save(studentEntity);
				return studentEntity;
			} else {
				logger.info(" student entity is not found inside update details by email id");
			}
		}
		logger.info("email id is null inside update details by email id");
		return null;
	}

	@Override
	public List<StudentEntity> getAllByNameOrEmailOrPhoneNo(String studentName, String emailId, long phoneNo) {
		// TODO Auto-generated method stub
		logger.info("inside getall by name or email or phone no inside student service");
		if (studentName != null || emailId != null || phoneNo > 0) {
			logger.info(
					"student name is not null or email is not null or phoneno >0 inside getall by name or email or phone no inside student service");
			return repository.findByStudentNameOrEmailIdOrPhoneNo(studentName, emailId, phoneNo);
		}
		logger.info(
				"student name is  null or email is  null or phoneno not  >0 inside getall by name or email or phone no inside student service");

		return null;
	}

	@Override
	public List<StudentEntity> getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode(SaveStudentDTO dto) {
		// TODO Auto-generated method stub
		logger.info("inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student service");
		if (dto != null) {
			logger.info(" dto is not null inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student service");
			return repository.findByStudentNameOrEmailIdOrDob(dto.getStudentName(), dto.getEmailId(), dto.getDob());
		} else {
			logger.info(" dto is null inside getAllByNameOrCityNameOrEmailOrDobOrContactNumberOrZipCode inside student service");
			return null;
		}
	}

	@Override
	public String saveStudent(StudentEntity studentEntity) {
		// TODO Auto-generated method stub
		logger.info("inside save student inside student service");
		if (studentEntity != null) {
			logger.info("student entity is not null inside save student inside student service");
			repository.save(studentEntity);
			return "Saved";
		}
		logger.info("student entity is  null inside save student inside student service");
		return "not saved";
	}

	@Override
	public StudentEntity saveAll(SaveStudentDTO dto) {
		// TODO Auto-generated method stub
		logger.info("inside save all for dto inside student service");
		CollegeEntity entity = collegeRepository.findByCollegeName(dto.getCollegeName());
		if (entity != null) {
			logger.info(" college entity inside save all for dto inside student service");
			StudentEntity studentEntity = new StudentEntity();
			logger.info("setting student entity inside save all for dto inside student service");
			studentEntity.setEmailId(dto.getEmailId());
			studentEntity.setAddress(dto.getAddress());
			studentEntity.setPhoneNo(dto.getPhoneNo());
			studentEntity.setCollegeName(dto.getCollegeName());
			studentEntity.setDob(dto.getDob());
			studentEntity.setStudentName(dto.getStudentName());
			studentEntity.setCollegeEntity(entity);
			logger.info("save both entites inside save all for dto inside student service");
			repository.save(studentEntity);
			collegeRepository.save(entity);
			return studentEntity;

		}
		logger.info("college name not found inside college entity inside save all for dto inside student service");
		return null;
	}

}
