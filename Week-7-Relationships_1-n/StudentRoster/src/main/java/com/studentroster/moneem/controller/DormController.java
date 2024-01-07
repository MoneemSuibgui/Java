package com.studentroster.moneem.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentroster.moneem.models.Dorm;
import com.studentroster.moneem.models.Student;
import com.studentroster.moneem.services.DormService;
import com.studentroster.moneem.services.StudentService;

@Controller
public class DormController {
	
	
	// inject DormService to DormController
	@Autowired
	private DormService dormService;
	
	// inject StudentService 
		@Autowired
		private StudentService studentService;
		
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}

	// "/" route for the dashboard page 
	@GetMapping("/dorms")
	public String Dashboard(Model modelView) {
		modelView.addAttribute("dorms", dormService.allDorms());
		return "dashboard.jsp";
	}
	
	// render the form jsp page to create new dorm
	@GetMapping("/dorms/new")
	public String formDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "FormDorm.jsp";
	}
	
	// add new dorm 
	@PostMapping("/create/dorm")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm) {
		dormService.addDorm(dorm);
		return "redirect:/";
	}
	
	// get one dorm 
	@GetMapping("/dorms/{dormId}")
	public String oneDorm(@PathVariable("dormId") Long id ,Model modelView) {
		
		Dorm dorm =dormService.getOneDorm(id);
		modelView.addAttribute("dorm", dorm);
		
		modelView.addAttribute("studentDorm", dorm.getStudents());
		modelView.addAttribute("allDorms", dormService.allDorms());
		
		List <Student> students =studentService.getAllStudents();
		modelView.addAttribute("allStudents", students);
		
		
		return "OneDorm.jsp";
	}	
}
