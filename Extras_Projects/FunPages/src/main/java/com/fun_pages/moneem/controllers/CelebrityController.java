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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fun_pages.moneem.models.Celebrity;
import com.fun_pages.moneem.models.User;
import com.fun_pages.moneem.services.CelebrityService;
import com.fun_pages.moneem.services.UserService;

@Controller
public class CelebrityController {

	// inject our services
	@Autowired
	private CelebrityService celebServ;

	@Autowired
	private UserService userServ;

	

	// Display route for the new celebrity page
	@GetMapping("/celebrities/new")
	public String celebrityForm(@ModelAttribute("celebrity") Celebrity celebrity,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		return "newCelebrity.jsp";
	}
	
	// Action route submit the form & add the celebrity to database
	@PostMapping("/new/celebrity")
	public String saveCelebrity(@Valid @ModelAttribute("celebrity") Celebrity celebrity,BindingResult result,HttpSession session) {
	if(result.hasErrors()) {
		return "newCelebrity.jsp";
	}
	User user=userServ.findUserById((Long)session.getAttribute("userId"));
	celebrity.setCreator(user);
	celebServ.add(celebrity);
	return "redirect:/home";
	}
	
	//Display route show Celebrity
	@GetMapping("/celebrities/{id}")
	public String showCelebrity(Model model,@PathVariable("id") Long id,HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		Celebrity celebrity=celebServ.getOne(id);
		Long userId=(Long)session.getAttribute("userId");
		User loggedUser=userServ.findUserById(userId);
		model.addAttribute("loggedUser",loggedUser);
		model.addAttribute("celebrity", celebrity);
		
		return "showCelebrity.jsp";
	}
	
	// Display route for edit celebrity page
	@GetMapping("/celebrities/{id}/edit")
	public String editCelebrity(@ModelAttribute("celebrity") Celebrity celebrity,HttpSession session,@PathVariable("id") Long id,Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("user", userServ.findUserById((Long)session.getAttribute("userId")));
		model.addAttribute("celebrity", celebServ.getOne(id));
		return "editCelebrity.jsp";
	}
	
	// update Celebrity
	@PutMapping("/update/celebrity/{id}")
	public String updateCelebrity(@Valid @ModelAttribute("celebrity") Celebrity celebrity,BindingResult result,@PathVariable("id") Long id,HttpSession session) {
		if(result.hasErrors()) {
			return "editCelebrity.jsp";
		}
		Long userId=(Long)session.getAttribute("userId");
		User user=userServ.findUserById(userId);
		
		celebrity.setCreator(user);
		celebServ.update(celebrity);
		return "redirect:/home";
	}
	
	// delete celebrity 
	@GetMapping("/delete/{id}")
	public String destroyCelebrity(@PathVariable("id") Long id) {
		Celebrity celebrity=celebServ.getOne(id);
		// i am setting the creator of the celebrity in the service
		celebServ.deleteCelebrity(celebrity);	
		return "redirect:/home";
		
	}

	// search for celebrity
	@PostMapping("/search")
	public String searchByName(@RequestParam("name") String name,Model model,HttpSession session,RedirectAttributes redirectAttribute) {

		List <Celebrity> celebrities=celebServ.findAllByName(name);
		if(celebrities.size()>0) {
			session.setAttribute("celebritiesByName", celebrities);
			return "redirect:/search/celebrities";
		}
		redirectAttribute.addFlashAttribute("errorMesssage", "* This Celebrity name doesn't exist");
		return "redirect:/home";
		
		
	}
	// display searched celebrities
	@GetMapping("/search/celebrities")
	public String getAllCelebritiesByName(HttpSession session,Model model) {
	@SuppressWarnings("unchecked")
	List <Celebrity>celebrities=(List<Celebrity>)session.getAttribute("celebritiesByName");
	model.addAttribute("celebrities",celebrities);
	return "search.jsp";
	}
	
	
	//follow Celebrity by logged user

	@GetMapping("/follow/{id}")
	public String follow(@PathVariable("id") Long id,HttpSession session,Model model) {
		
		Celebrity celebrity=celebServ.getOne(id);
		User loggedUser=userServ.findUserById((Long)session.getAttribute("userId"));

		celebrity.getFollowers().add(loggedUser);
		celebServ.update(celebrity);
		return "redirect:/celebrities/"+celebrity.getId();
	}
	
}







