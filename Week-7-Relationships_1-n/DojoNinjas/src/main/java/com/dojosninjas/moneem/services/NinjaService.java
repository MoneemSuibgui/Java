package com.dojosninjas.moneem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojosninjas.moneem.models.Ninja;
import com.dojosninjas.moneem.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepo;
	
	// create
	public Ninja addNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
}
