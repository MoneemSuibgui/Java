package com.admin_dashboard.security.controller;

import java.security.Principal;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin_dashboard.security.model.User;
import com.admin_dashboard.security.service.UserService;
import com.admin_dashboard.security.validator.UserValidator;

@Controller
public class MainController {

	// inject UserService using @Autowired annotation
	@Autowired
	private UserService userService;

	// inject UserValidator using @Autowired annotation
	@Autowired
	private UserValidator userValidator;

	
	// Display route for login & register user
	@RequestMapping("/login")
	public String login(@ModelAttribute("user") User user,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("errorMessage", "* Invalid Credentials, Please try again ");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "* Logout Successful !!!");
		}
		return "loginRegister.jsp";
	}

	// Action route for regsiter user
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "loginRegister.jsp";
		}
		if (userService.allUsers().size() == 0) {
			userService.saveUserWithRole(user, "ROLE_SUPER_ADMIN");
		} else {
			userService.saveUserWithRole(user, "ROLE_USER");
		}
		return "redirect:/";
	}

	// Display route for admin home
	@RequestMapping("/admin")
	public String adminPage(Principal principal, Model model) {
		String email = principal.getName();
		model.addAttribute("admin", userService.findByEmail(email));
		model.addAttribute("users", userService.allUsers());
		return "adminHome.jsp";
	}

	// make user as admin 
	@RequestMapping("/makeAdmin/{id}")
	public String makeAdmin(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		userService.upgradeUser(user);
		model.addAttribute("users", userService.allUsers());
		return "redirect:/admin";
	}

	// access level routes for user 
	@RequestMapping(value = { "/", "/home" })
	public String home(Principal principal, Model model) {
		String email = principal.getName();
		User user = userService.findByEmail(email);
		model.addAttribute("user", user);

		if (user != null) {
			Date lastLoginDate=new Date();
			model.addAttribute("lastLoginDate", lastLoginDate);
			userService.updateUser(user);
			// If the user is an ADMIN they will be redirected to the admin home
			if (user.getRoles().get(0).getName().contains("ROLE_ADMIN") || user.getRoles().get(0).getName().contains("ROLE_SUPER_ADMIN")) {
				model.addAttribute("admin", userService.findByEmail(email));
				model.addAttribute("users", userService.allUsers());
				return "adminHome.jsp";
			}
			// All other users are redirected to the dashboard
		}
		return "userHome.jsp";
	}

	// delete user and redirect to admin dashboard
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		User user = userService.findById(id);
		userService.deleteUser(user);
		model.addAttribute("users", userService.allUsers());
		return "redirect:/admin";
	}
}
