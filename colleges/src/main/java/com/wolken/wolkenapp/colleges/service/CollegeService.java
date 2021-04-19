package com.wolken.wolkenapp.colleges.service;

import java.util.List;

import com.wolken.wolkenapp.colleges.entity.CollegeEntity;

public interface CollegeService {

	public String save(CollegeEntity collegeEntity);

	public String updateByCollegeName(CollegeEntity collegeEntity);

	public String deleteByCollegeName(String collegeName);

	public List<CollegeEntity> getAll();

	public int saveAll(List<CollegeEntity> collegeEntities);

	public List<CollegeEntity> getAllByCityName(String cityName);

	public List<CollegeEntity> updateZipCodeByCityName(String cityName, int zipCode);

}
