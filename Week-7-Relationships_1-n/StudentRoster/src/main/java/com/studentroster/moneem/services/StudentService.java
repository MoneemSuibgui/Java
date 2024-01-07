package com.studentroster.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentroster.moneem.models.Student;
import com.studentroster.moneem.repositories.StudentRepository;

@Service
public class StudentService {

	// inject StudentRepository
		@Autowired
		private StudentRepository studentRepo;
		
		
		// create Student
		public Student addStudent(Student student) {
			return studentRepo.save(student);
		}
		
		
		// delete one student
		public void deleteStudent(Long id) {
			studentRepo.deleteById(id);
		}
		
		// get all students
		public List <Student> getAllStudents() {
			return studentRepo.findAll();
		}
		
		// get one student
		public Student getOneStudent(Long id) {
			Optional <Student> student =studentRepo.findById(id);
			if(student.isPresent()) {
				return student.get();
			}
			return null;
		}
		
		
}

