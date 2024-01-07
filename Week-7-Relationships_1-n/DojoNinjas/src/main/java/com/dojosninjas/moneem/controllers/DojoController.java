package com.dojosninjas.moneem.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.moneem.models.Dojo;
import com.dojosninjas.moneem.services.DojoService;

@Controller
public class DojoController {

	// another Way to inject Dojo Service
	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	// redirect route to "/dojos/new" route
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}

	// render the form dojo page & send empty object dojo to the jsp file
	@GetMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "DojoForm.jsp";
	}

	// create dojo and get back full object from the jsp to saved into the database
	// and redirect to the main page
	@PostMapping("/create/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "DojoForm.jsp";
		}
		dojoService.addDojo(dojo);
		return "redirect:/dojos";
	}
	
	// show all ninjas info for one dojo
	@GetMapping("/dojo/{id}")
	public String dojoInfo(@PathVariable("id") Long id,Model modelView) {
		Dojo dojo=dojoService.getDojo(id);
		modelView.addAttribute("dojo", dojo);
		return "DojoDetails.jsp";
	}
	
	// show all dojos 
	@GetMapping("/dojos")
	public String dojosInfo(Model modelView) {
		modelView.addAttribute("dojos", dojoService.allDojos());
		return "Dojos.jsp";
	}

}
