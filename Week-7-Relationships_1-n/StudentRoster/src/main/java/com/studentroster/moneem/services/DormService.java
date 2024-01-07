package com.studentroster.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentroster.moneem.models.Dorm;
import com.studentroster.moneem.repositories.DormRepository;

@Service
public class DormService {
	
	// inject DormRepository 
	@Autowired
	private DormRepository dormRepo;
	
	
	// create dorm
	public Dorm addDorm(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	// updateDorm (the same of addDorm)
	public Dorm updateDorm(Dorm dorm) {
		return dormRepo.save(dorm);
	}
	
	//get all dorms
	public List<Dorm> allDorms(){
		return dormRepo.findAll();
	}
	
	// get one dorm
	public Dorm getOneDorm(Long id) {
		Optional <Dorm> dorm =dormRepo.findById(id);
		if(dorm.isPresent()) {
			return dorm.get();
		}
		return null;
	}
	
	

}
