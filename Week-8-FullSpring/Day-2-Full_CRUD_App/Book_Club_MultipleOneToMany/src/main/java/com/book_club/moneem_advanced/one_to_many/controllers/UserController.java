package com.book_club.moneem_advanced.one_to_many.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.book_club.moneem_advanced.one_to_many.models.LoginUser;
import com.book_club.moneem_advanced.one_to_many.models.User;
import com.book_club.moneem_advanced.one_to_many.services.UserService;

@Controller
public class UserController {
	
	// inject userService
	@Autowired
	private UserService userServ;
	

	@GetMapping("/")
	public String home(Model modelView) {
		modelView.addAttribute("newUser", new User());
		modelView.addAttribute("loggedInUser", new User());
		return "index.jsp";
	}
	
	// Action route for register form
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,BindingResult result,HttpSession session,Model modelView) {
		// set all validations and and store the user if there is no errors
		userServ.registerUser(newUser, result);
		if(result.hasErrors()) {
			modelView.addAttribute("loggedInUser", new User());
			return "index.jsp";
		}
		// if there is no error we save user & store  userId into session
		userServ.saveUser(newUser);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/books";
	}
	
	
	// Action route for login form
	@PostMapping("/login")
	public String Login(@Valid @ModelAttribute("loggedInUser") LoginUser loggedInUser,BindingResult result,HttpSession session,Model modelView) {
		User LoggedUser=userServ.login(loggedInUser, result);
		if(result.hasErrors()) {
			// Bind empty User object to the JSP
			modelView.addAttribute("newUser", new User());
			return "index.jsp";
		}
		session.setAttribute("userId", LoggedUser.getId());
		return "redirect:/books";
	}
	
	

	
	// Guard route(clear session and redirect to login page)
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

}
