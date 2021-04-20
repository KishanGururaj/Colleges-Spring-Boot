package com.wolken.wolkenapp.colleges.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolken.wolkenapp.colleges.entity.CollegeEntity;
import com.wolken.wolkenapp.colleges.service.CollegeService;

@RestController
@RequestMapping("/")
public class CollegeResources {
	@Autowired
	CollegeService collegeService;
	Logger logger =Logger.getLogger("CollegeResources");
	@GetMapping("/getAllCol")
	public ResponseEntity<List<CollegeEntity>> getAll(){
		logger.info("inside getall inside college controller");
		List<CollegeEntity>lists=collegeService.getAll();
		if(lists == null) {
		return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.BAD_REQUEST);
	}else {
		return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.ACCEPTED);
	}
	}
	@PostMapping("/saveCol")
	public ResponseEntity<String>  save(@RequestBody CollegeEntity collegeEntity) {
		logger.info("inside save inside college controller ");
		String msg= collegeService.save(collegeEntity);
		if(msg=="Data Saved") {
			logger.info("msg is data saved data successfull inside save inside college controller ");
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			logger.info("msg is not data saved data unsuccessfull  inside save inside college controller ");
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("/updateCol")
	public ResponseEntity<String>  updateById(@RequestBody CollegeEntity collegeEntity) {
		logger.info("inside update inside college controller");
		String msg= collegeService.updateByCollegeName(collegeEntity);
		if(msg=="Update SuccessFull") {
			logger.info("msg is Update SuccessFull inside update inside college controller");
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			logger.info("msg is Update UnSuccessFull inside update inside college controller");
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteCol")
	public ResponseEntity<String>  deleteByCollegeName(@RequestBody String collegeName) {
		logger.info("inside delete inside college controller");
		String msg=collegeService.deleteByCollegeName(collegeName);
		if(msg=="Delete Successfull") {
			logger.info("msg is Delete Successfull inside delete inside college controller");
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}else {
			logger.info(" msg is Delete UnSuccessfull inside delete inside college controller");
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/saveAll")
	public ResponseEntity<Integer> saveAll(@RequestBody List<CollegeEntity> collegeEntities) {
		logger.info("inside  save all inside controller ");
		int i=collegeService.saveAll(collegeEntities);
		if(i>0) {
			logger.info("i >0 inside  save all inside controller ");
			return new ResponseEntity<Integer>(i, HttpStatus.OK);
		}else {
			logger.info("i<0 inside  save all inside controller ");
			return new ResponseEntity<Integer>(i, HttpStatus.FAILED_DEPENDENCY);
		}
		
	}
	@GetMapping("/getAllByCityName")
	public ResponseEntity<List<CollegeEntity>> getAllByCityName(@RequestBody String cityName){
		logger.info("inside get all by city name inside controller");
		List<CollegeEntity> lists= collegeService.getAllByCityName(cityName);
		if(lists == null) {
			logger.info("lists is null inside get all by city name inside controller");
			return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			logger.info("lists is not null inside get all by city name inside controller");
			return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.ACCEPTED);
		}
	}
	@PutMapping("/updateZipCodeByCityName")
	public ResponseEntity<List<CollegeEntity>> updateZipCodeByCityName(@RequestBody CollegeEntity collegeEntity){
		logger.info("inside update zipcode city name inside controller");
		List<CollegeEntity> lists=collegeService.updateZipCodeByCityName(collegeEntity.getCityName(),collegeEntity.getZipCode());
		if(lists == null) {
			logger.info(" lists is null inside update zipcode city name inside controller");
			return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.BAD_REQUEST);
		}else {
			logger.info("lists is not null inside update zipcode city name inside controller");
			return new ResponseEntity<List<CollegeEntity>>(lists, HttpStatus.ACCEPTED);
		}
	}
}
