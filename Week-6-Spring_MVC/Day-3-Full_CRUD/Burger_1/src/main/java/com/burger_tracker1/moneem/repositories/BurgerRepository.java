package com.burger_tracker1.moneem.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.burger_tracker1.moneem.models.Burger;


public interface BurgerRepository extends CrudRepository<Burger,Long>{
	
	List<Burger> findAll();
	
}
