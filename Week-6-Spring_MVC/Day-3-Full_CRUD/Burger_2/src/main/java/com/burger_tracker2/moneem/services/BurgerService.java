package com.burger_tracker2.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burger_tracker2.moneem.models.Burger;
import com.burger_tracker2.moneem.repositories.BurgerRepository;

@Service
public class BurgerService {

	// inject my repository interface as a dependency
	@Autowired
	private BurgerRepository burgerRepo;

	// create burger
	public Burger createBurger(Burger burger) {
		return burgerRepo.save(burger);
	}

	// get all burgers
	public List<Burger> getAllBurgers() {
		return burgerRepo.findAll();
	}

	// find one burger
	public Burger getOneBurger(Long id) {
		Optional<Burger> burger = burgerRepo.findById(id);
		if (burger.isPresent()) {
			return burger.get();
		}
		return null;
	}

     //  update burger
	public Burger updateBurger(Burger burger) {
		return burgerRepo.save(burger);
	}

}
