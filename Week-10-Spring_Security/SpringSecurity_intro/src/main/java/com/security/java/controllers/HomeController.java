package com.security.java.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.java.models.User;
import com.security.java.services.UserService;
import com.security.java.validator.UserValidator;

@Controller
public class HomeController {

	// inject UserService & UserValidator
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;

	
	// Display route Register page
	@GetMapping("/register")
	public String register(@ModelAttribute("user") User user) {
		return "register.jsp";
	}

	// Action route Register form submit the form and sav user with specific roles
	// into the database
	@PostMapping("/register")
	public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "register.jsp";
		}
		// userService.saveUserWithUserRole(user);
		userService.saveUserWithAdminRole(user);
		return "redirect:/login";
	}

	// Display route Login page
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		// set a couple of optional request parameters, check for their existence
		if (error != null) {
			model.addAttribute("errorMsg", "* Invalid Credentials, Please try again ");
		}
		if (logout != null) {
			model.addAttribute("logoutMsg", "* You are successfuly logout ");
		}
		return "login.jsp";
	}

	// Display routes for 2 routes of user have role user
	@GetMapping({ "/", "/home" })
	public String home(Principal principal, Model model) {
		String username = principal.getName();
		User user = userService.findByName(username);
		model.addAttribute("currentUser", user);
		return "home.jsp";
	}

	// Dislay route for admin page
	@GetMapping("/admin")
	public String adminHome(Principal principal, Model model) {
		String username = principal.getName();
		model.addAttribute("currentAdmin", userService.findByName(username));
		return "adminHome.jsp";
	}

}
