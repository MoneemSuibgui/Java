package com.fun_pages.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fun_pages.moneem.models.Celebrity;

@Repository
public interface CelebrityRepository extends CrudRepository<Celebrity, Long> {

	// find all celebrities
	List<Celebrity> findAll();
	
	// find celebrities by celebrityName
	List<Celebrity> findByCelebrityNameContains(String celebName);

	Long countByFollowers(Celebrity celebrity);
}
