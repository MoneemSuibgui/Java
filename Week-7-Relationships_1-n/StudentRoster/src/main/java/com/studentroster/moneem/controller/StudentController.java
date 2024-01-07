package com.studentroster.moneem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentroster.moneem.models.Student;
import com.studentroster.moneem.services.DormService;
import com.studentroster.moneem.services.StudentService;

@Controller
public class StudentController {
	
	// inject StudentService 
	@Autowired
	private StudentService studentService;
	
	// inject DormService
	@Autowired
	private DormService dormService;
	
	@GetMapping("/students/new")
	public String studentForm(@ModelAttribute("student") Student student,Model modelView) {
		// send list of all dorms to the form 
		modelView.addAttribute("dorms",dormService.allDorms());
		return "StudentForm.jsp";
	}

	// save the student to the database
	@PostMapping("/create/student")
	public String createStudent(@Valid @ModelAttribute("student") Student student,BindingResult result,Model modelView) {
		if(result.hasErrors()) {
			// if the user have validation errors, we should send again all dorms 
			modelView.addAttribute("dorms", dormService.allDorms());
			return "StudentForm.jsp";
		}
		studentService.addStudent(student);
		return "redirect:/";
		
	}
	
	// delete student 
	@GetMapping("/delete/{id}/{dormId}")
	public String dstroyStudent(@PathVariable("id") Long id,@PathVariable("dormId") Long dormId) {
		Student student=studentService.getOneStudent(id);
		student.setDorm(null);
		studentService.deleteStudent(id);
	   
		return "redirect:/dorms/"+dormId ;
	}
	
	// edit(reassign) student to new dorm
	@PostMapping("/add/student/{dormId}")
	public String SaveStudentDorm(@RequestParam(value="studentId") Long StudentId, @PathVariable("dormId") Long dormId) {
		
		Student student=studentService.getOneStudent(StudentId);
		student.setDorm(dormService.getOneDorm(dormId));
		studentService.addStudent(student);
	   return "redirect:/dorms/"+dormId;
	}
	

}
