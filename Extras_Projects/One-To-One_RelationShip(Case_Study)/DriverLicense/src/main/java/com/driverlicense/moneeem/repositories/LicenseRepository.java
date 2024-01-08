package com.driverlicense.moneeem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.driverlicense.moneeem.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	
	List<License> findAll();
	
}
