package com.burger_tracker1.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger_tracker1.moneem.models.Burger;
import com.burger_tracker1.moneem.repositories.BurgerRepository;

@Service
public class BurgerService {
	
	//  inject my repository interface as a dependency
	@Autowired
	private BurgerRepository burgerRepo;
	
	
	//  create burger
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}
	
	// get all burgers
	public List<Burger> getAllBurgers(){
		return burgerRepo.findAll();
	}
	

}
