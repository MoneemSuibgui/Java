package com.login_registration.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login_registration.moneem.models.Student;
import com.login_registration.moneem.repositories.StudentRepository;

@Service
public class StudentService {
	// inject StudentRepository
	@Autowired
	private StudentRepository studRepo;

	// get all students
	public List<Student> all() {
		return studRepo.findAll();
	}

	// create student
	public Student add(Student student) {
		return studRepo.save(student);
	}

	// create student
	public Student update(Student student) {
		return studRepo.save(student);
	}

	// get one student
	public Student oneStudent(Long id) {
		Optional<Student> student = studRepo.findById(id);
		if (student.isPresent()) {
			return student.get();
		}
		return null;
	}

}
