package com.wolken.wolkenapp.colleges.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolken.wolkenapp.colleges.entity.CollegeEntity;
import com.wolken.wolkenapp.colleges.exception.CollegeEntitesExpection;
import com.wolken.wolkenapp.colleges.exception.CollegeEntityException;
import com.wolken.wolkenapp.colleges.exception.StudentEntityException;
import com.wolken.wolkenapp.colleges.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {
	@Autowired
	CollegeRepository repository;
	Logger logger = Logger.getLogger("CollegeServiceImpl");

	@Override
	public String save(CollegeEntity collegeEntity) {
		// TODO Auto-generated method stub
		logger.info("inside save method inside college service ");
		try {
			logger.info("inside try block inside save method inside college service ");
			if (collegeEntity != null) {
				logger.info("college entity is not null inside save inside college service");
				repository.save(collegeEntity);
				return "Data Saved";
			} else {
				logger.info("student entity exception inside save method inside college service");
				throw new StudentEntityException();
			}

		} catch (Exception e) {
			logger.error("inside catch block inside save method inside college service ");
			e.printStackTrace();
		}

		logger.info("college enitity is null inside save inside college service");
		return "Data Unsaved";
	}

	@Override
	public String updateByCollegeName(CollegeEntity collegeEntity) {
		// TODO Auto-generated method stub
		logger.info("inside update method inside college service");
		try {
			logger.info("inside try block inside update method inside college service");
			if (collegeEntity != null) {
				logger.info("college entity is not null inside update inside college service");
				CollegeEntity entity = repository.findByCollegeName(collegeEntity.getCollegeName());
				if (entity != null) {
					logger.info("entity found and updating data inside college service ");
					entity.setCityName(collegeEntity.getCityName());
					entity.setZipCode(collegeEntity.getZipCode());
					repository.save(entity);
					return "Update SuccessFull";
				} else {
					logger.info("entity not found or not present in college table in college service ");
					return "College  not present";
				}
			} else {
				logger.info("throwing exception inside updateByCollegeName method inside college service");
				throw new CollegeEntityException();
			}
		} catch (Exception e) {
			logger.error("inside catch block inside update method inside college service ");
			e.printStackTrace();
		}

		logger.info("college name passed to college service is null inside update");
		return "Entity passed is null";
	}

	@Override
	public String deleteByCollegeName(String collegeName) {
		// TODO Auto-generated method stub
		logger.info("inside delete method inside college service ");
		try {
			logger.info("inside try block inside delete method inside college service ");
			if (collegeName != null) {
				logger.info(" college name is not null inside delete method inside college service ");
				CollegeEntity collegeEntity = repository.findByCollegeName(collegeName);
				if (collegeEntity != null) {
					logger.info("college entity is found inside delete method inside college service ");
					repository.delete(collegeEntity);
					return "Delete Successfull";
				} else {
					logger.info("college entity is not found inside delete method inside college service ");
					throw new CollegeEntityException();
				}
			}
		} catch (Exception e) {
			logger.error("inside catch block inside delete method inside college service");
			e.printStackTrace();
		}
		logger.info("college name inside delete method inside college service ");
		return "College Name is null ";
	}

	@Override
	public List<CollegeEntity> getAll() {
		// TODO Auto-generated method stub
		logger.info("inside college service getall method ");
		return repository.findAll();
	}

	@Override
	public int saveAll(List<CollegeEntity> collegeEntities) {
		// TODO Auto-generated method stub
		logger.info("inside save all inside college service");
		try {
			logger.info(" inside catch block inside save all inside college service");
			if (collegeEntities != null) {
				logger.info("list ia not null inside save all inside college service ");
				int n = collegeEntities.size();
				repository.saveAll(collegeEntities);
				return n;
			} else {
				logger.info("throwing exception inside save all inside college service");
				throw new CollegeEntitesExpection();
			}
		} catch (Exception e) {
			logger.error("inside catch block inside save all inside college service");
			e.printStackTrace();
		}
		logger.info("list is null inside save all method inside college service");
		return 0;
	}

	@Override
	public List<CollegeEntity> getAllByCityName(String cityName) {
		// TODO Auto-generated method stub
		logger.info("inside get All by city name inside college service ");
		return repository.getAllByCityName(cityName);
	}

	@Override
	public List<CollegeEntity> updateZipCodeByCityName(String cityName, int zipCode) {
		// TODO Auto-generated method stub
		logger.info("inside update zipcode by city name");
		try {
			logger.info("inside try block inside update zipcode by city name");
			if (cityName != null) {
				logger.info("city is not null inside update zipcode by city name");
				List<CollegeEntity> collegeEntities = repository.getAllByCityName(cityName);
				if (collegeEntities != null) {
					logger.info("college entites inside update zipcode by city name");
					for (CollegeEntity entity : collegeEntities) {
						entity.setZipCode(zipCode);
						repository.save(entity);
					}
					logger.info("Update Successfully");
					return repository.findAll();
				} else {
					logger.info("throwing exception inside update zipcode by city name ");
					throw new CollegeEntitesExpection();
				}

			}
			logger.info("city name not found inside update zipcode by city name ");
		} catch (Exception e) {
			logger.error("inside catch block inside update zipcode by city name");
			e.printStackTrace();
		}
		logger.info("city name is null inside update zipcode by city name ");
		return null;
	}

}
