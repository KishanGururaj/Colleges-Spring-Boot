package com.wolken.wolkenapp.colleges.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolken.wolkenapp.colleges.entity.CollegeEntity;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer>{
	public List<CollegeEntity>getAllByCityName(String cityName);
	public CollegeEntity findByCollegeName(String collegeName);
	


}
