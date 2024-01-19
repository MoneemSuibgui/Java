package com.fun_pages.moneem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fun_pages.moneem.models.Celebrity;
import com.fun_pages.moneem.models.LoginUser;
import com.fun_pages.moneem.models.User;
import com.fun_pages.moneem.services.CelebrityService;
import com.fun_pages.moneem.services.UserService;

@Controller
public class UserController {
	
	// inject UserService & CelebrityService
	@Autowired
	private UserService userServ;
	
	@Autowired
	private CelebrityService celebServ;

	@GetMapping("/")
	public String home(Model modelView) {
		modelView.addAttribute("newUser", new User());
		modelView.addAttribute("loggedInUser", new User());
		return "index.jsp";
	}
	
	// Action route for register form
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute(name="newUser") User newUser,BindingResult result,HttpSession session,Model modelView) {
		// set all validations and and store the user if there is no errors
		userServ.registerUser(newUser, result);
		if(result.hasErrors()) {
			modelView.addAttribute("loggedInUser", new User());
			return "index.jsp";
		}
		// if there is no error we save user & store  userId into session
		userServ.saveUser(newUser);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/home";
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
		return "redirect:/home";
	}
	
	
	// Display route "/home" (render our home.jsp page)
	@GetMapping("/home")
	public String Dashboard(Model modelView,HttpSession session) {
		// test if the userId in session or not
		if(session.getAttribute("userId")==null){
			return "redirect:/";
		}
		Long id=(Long)session.getAttribute("userId");
		User loggedUser=userServ.findUserById(id);
		modelView.addAttribute("loggedUser", loggedUser);	
		List<Celebrity> celebrities=celebServ.all();
		modelView.addAttribute("celebrities",celebrities );
		return "dashboard.jsp";
	}
	
	// Guard route(clear session and redirect to login page)
	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

}
