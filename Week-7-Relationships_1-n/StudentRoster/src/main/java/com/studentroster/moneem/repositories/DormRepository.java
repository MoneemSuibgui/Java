package com.studentroster.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentroster.moneem.models.Dorm;

@Repository
public interface DormRepository extends CrudRepository<Dorm,Long> {

	// list of all dorms
	List<Dorm> findAll();
}
