package com.fun_pages.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fun_pages.moneem.models.Celebrity;
import com.fun_pages.moneem.repositories.CelebrityRepository;

@Service
public class CelebrityService {

	
	// inject CelerityRepository
	@Autowired 
	private CelebrityRepository celebRepo;
	
	// create celebrity
	public Celebrity add(Celebrity celebrity) {
		return celebRepo.save(celebrity);
	}
	
	// create celebrity
		public Celebrity update(Celebrity celebrity) {
			return celebRepo.save(celebrity);
		}
		
	// get one celebrity
		public Celebrity getOne(Long id) {
			Optional<Celebrity> optionalCelebrity=celebRepo.findById(id);
			if(optionalCelebrity.isPresent()) {
				return optionalCelebrity.get();
			}
			return null;
		}
		
	// get all celebrities
		public List<Celebrity> all(){
			return celebRepo.findAll();
		}
		
	// delete celebrity
		public void deleteCelebrity(Celebrity celebrity) {
			celebrity.setCreator(null);
			celebRepo.delete(celebrity); 
		}
		
	// find celebrities by name
		public List<Celebrity> findAllByName(String name){			
			return celebRepo.findByCelebrityNameContains(name);
		}
		
	// count by follwers
		public Long countFollwers(Celebrity celebrity) {
			return celebRepo.countByFollowers(celebrity);
		}
	
}
