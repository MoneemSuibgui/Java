package com.login_registration.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login_registration.moneem.models.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long>{

	// find all courses
	List<Course> findAll();
}
