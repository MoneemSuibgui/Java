package com.studentroster.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.studentroster.moneem.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long>{
	
	List <Student> findAll();
	
}
