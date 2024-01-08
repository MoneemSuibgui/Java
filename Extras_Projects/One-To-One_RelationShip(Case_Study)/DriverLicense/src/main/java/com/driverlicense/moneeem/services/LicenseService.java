package com.driverlicense.moneeem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driverlicense.moneeem.models.License;
import com.driverlicense.moneeem.repositories.LicenseRepository;

@Service
public class LicenseService {
	
	// inject LicenseRepository
	@Autowired
	LicenseRepository licenseRepo;
	
	// create license
	public License createLicense(License license) {
		return licenseRepo.save(license);
	}
	
	// get all licenses
	public List<License> getAllLicenses(){
		return licenseRepo.findAll();
	}

}
