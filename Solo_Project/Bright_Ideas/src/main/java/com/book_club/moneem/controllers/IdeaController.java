package com.book_club.moneem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.book_club.moneem.models.Idea;
import com.book_club.moneem.models.User;
import com.book_club.moneem.services.IdeaService;
import com.book_club.moneem.services.UserService;

@Controller
public class IdeaController {

	// inject our services
	private final IdeaService ideaService;
	private final UserService userService;
	
	public IdeaController(IdeaService ideaService,UserService userService) {
		this.ideaService=ideaService;
		this.userService=userService;
	}
	
	// Display route "/bright_ideas" (render our bright_ideas.jsp page)
		@GetMapping("/bright_ideas")
		public String Dashboard(Model modelView,HttpSession session) {
			if(session.getAttribute("userId")==null){
				return "redirect:/";
			}
			Long id=(Long)session.getAttribute("userId");
			User loginUser=userService.findUserById(id);
			modelView.addAttribute("loginUser", loginUser);
			modelView.addAttribute("idea", new Idea());
			List<Idea> allIdeas=this.ideaService.all();
			modelView.addAttribute("ideas", allIdeas);
			return "dashboard.jsp";
		}
	
		// Action route create bright idea
	@PostMapping("/bright_ideas")
	public String create(@Valid @ModelAttribute("idea")Idea idea,BindingResult result,HttpSession session,Model model) {
		Long id=(Long)session.getAttribute("userId");
		User loginUser=this.userService.findUserById(id);
		if(result.hasErrors()) {
			List<Idea> allIdeas=this.ideaService.all();
			model.addAttribute("ideas", allIdeas);
			model.addAttribute("loginUser", loginUser);
			return "dashboard.jsp";
		}
		
		idea.setCreator(loginUser);
		this.ideaService.add(idea);
		return "redirect:/bright_ideas";
	}
	
	// delete route : delete idea
	@DeleteMapping("/delete/{IdeaId}")
	public String destroy(@PathVariable("IdeaId") Long IdeaId) {
		this.ideaService.delete(IdeaId);
		return "redirect:/bright_ideas";
	}
	
	// display route show details of creator of the idea 
	@GetMapping("/users/{userId}")
	public String showCreator(@PathVariable("userId") Long id,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null){
			return "redirect:/";
		}
		User user=userService.findUserById(id);
		model.addAttribute("creator", user);
		return "showCreator.jsp";
	}

	// display route show idea info and all users likes it
	@GetMapping("/bright_ideas/{id}")
	public String ideaDetails(@PathVariable("id") Long id,Model model,HttpSession session) {
		if(session.getAttribute("userId")==null){
			return "redirect:/";
		}
		Idea idea=ideaService.oneIdea(id);
		model.addAttribute("idea", idea);
		return "ideaDetails.jsp";
	}




}
