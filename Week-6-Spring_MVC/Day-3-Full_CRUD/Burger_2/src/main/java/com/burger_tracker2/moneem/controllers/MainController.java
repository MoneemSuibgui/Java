package com.burger_tracker2.moneem.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.burger_tracker2.moneem.models.Burger;
import com.burger_tracker2.moneem.services.BurgerService;

@Controller
public class MainController {

	// we can use annotation @Autowired or inject the bugerService manually into the
	// constructor (Dependency injection)
	private final BurgerService burgerService;

	public MainController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}

	@RequestMapping("/")
	public String home(@ModelAttribute("burger") Burger burger, Model model) {
		// retrieve all the records from the database and render them on the page using
		// the model object
		model.addAttribute("burgers", burgerService.getAllBurgers());
		return "index.jsp";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String addBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// if result object has error we are going to render the page to displayed and
			// show us the list of all burgers again
			model.addAttribute("burgers", burgerService.getAllBurgers());
			return "index.jsp";
		}
		// else (all fields match the validation we save the burger object and redirect
		// to the "/"route )
		burgerService.createBurger(burger);
		return "redirect:/";
	}

	// Display route edit burger form
	@RequestMapping(value = "/burgers/{id}", method = RequestMethod.GET)
	public String editBurger(@PathVariable("id") Long id, Model model, @ModelAttribute("updatedBurger") Burger burger) {
		// get all info of the specific burger and passed into view page
		model.addAttribute("editBurger", burgerService.getOneBurger(id));
		return "edit.jsp";
	}

	// Action route update burger
	@RequestMapping(value = "/edit/burger/{id}", method = RequestMethod.PUT)
	public String updateBurger(@Valid @ModelAttribute("updatedBurger") Burger burger, BindingResult result,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		burgerService.updateBurger(burger);
		return "redirect:/";
	}

}
