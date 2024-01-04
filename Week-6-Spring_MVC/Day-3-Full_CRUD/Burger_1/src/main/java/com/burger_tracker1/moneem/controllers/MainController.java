package com.burger_tracker1.moneem.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.burger_tracker1.moneem.models.Burger;
import com.burger_tracker1.moneem.services.BurgerService;

@Controller
public class MainController {
	
	// we can use annotation @Autowired or inject the bugerService manually into the constructor (Dependency injection)
	private final BurgerService burgerService;
	
	public MainController(BurgerService burgerService) {
		this.burgerService=burgerService;
	}
	
	// Display route render the page show get all burgers and add burger form
	@GetMapping("/")
	public String home(@ModelAttribute("burger") Burger burger ,Model model) {
		//  retrieve all the records from the database and render them on the page using the model object
		model.addAttribute("burgers",burgerService.getAllBurgers());
		return "index.jsp";
	}
	
	// ACction route save burger 
	@PostMapping("/")
	public String addBurger(@Valid @ModelAttribute("burger") Burger burger,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("burgers",burgerService.getAllBurgers());
			// if result object has error we are going to render the page to displayed
			return "index.jsp";
		}
		// else (all fields match the validation we save the burger object and redirect to the "/"route )
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	
	

}
