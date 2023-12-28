package com.omikujiform.javaproject.moneem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	// Make a request mapping for the url /omikuji to render the main page showing the Omikuji form.
	@GetMapping("/omikuji")
	// Otherwise: @RequestMapping(value="/omikuji",method=RequestMethod.GET)
	public String Omikuji() {
		return "index.jsp";
	}
	
	//  Include a request mapping to handle processing the information from the form, 
	@PostMapping("/create/omikuji")
	// Or :@RequestMapping(value="/create/omikuji",method=RequestMethod.POST)
	public String create(
			@RequestParam(value="num") int number,
			@RequestParam(value="city") String city,
			@RequestParam(value="personName") String personName,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="mammal") String mammal,
			@RequestParam(value="message") String message,
			HttpSession session) {
		//store the form input into session and redirect to the /omikuji/show route.
		session.setAttribute("randomNumber",number);
		session.setAttribute("city", city);
		session.setAttribute("personName", personName);
		session.setAttribute("hobby", hobby);
		session.setAttribute("mammal", mammal);
		session.setAttribute("message", message);
		
		// System.out.println(number + " "+city +" "+ personName+" "+ hobby+" "+mammal+" "+message);
		
		return "redirect:/omikuji/show";
	}
	
	// Make a request mapping for the url /omikuji/show that renders a page with a blue box with a message. Include an anchor tag that goes back to /omikuji.
	@GetMapping("/omikuji/show")
	public String showOmikuji() {
		// Dynamically render the template for the /omikuji/show route using the information saved in session.
		return "home.jsp";
	}
	
	

}
