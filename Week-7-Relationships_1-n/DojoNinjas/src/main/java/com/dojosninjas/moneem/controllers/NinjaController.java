package com.dojosninjas.moneem.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojosninjas.moneem.models.Dojo;
import com.dojosninjas.moneem.models.Ninja;
import com.dojosninjas.moneem.services.DojoService;
import com.dojosninjas.moneem.services.NinjaService;

@Controller
public class NinjaController {

	// inject NinjaService in our NinjaController
	@Autowired
	private NinjaService ninjaService;

	// inject DojoService in our NinjaController
	@Autowired
	private DojoService dojoService;

	// route for Ninja form (send empty ninja object to the form)
	@GetMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model modelView) {

		// send all dojos to the Ninjaform using dojoService
		List<Dojo> dojos = dojoService.allDojos();
		modelView.addAttribute("dojos", dojos);
		return "NinjaForm.jsp";
	}

	// route to submit the form
	@PostMapping("/create/ninja")
	public String createDojo(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model modelView) {
		if (result.hasErrors()) {
			// if we have errors validation we are showing to user the errors and send all
			// the dojos to the form again
			modelView.addAttribute("dojos", dojoService.allDojos());
			return "NinjaForm.jsp";
		}
		ninjaService.addNinja(ninja);
		return "redirect:/dojos";
	}

}
