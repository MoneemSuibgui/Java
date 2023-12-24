package com.daikichiproject.moneem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
// @RequestMapping class level annotation.
@RequestMapping("/daikichi")
public class DaikichiController {
	// Have a  GET request to 'http://localhost:8080/daikichi' display text that says 'Welcome!'
	@RequestMapping("")
	public String index() {
		return "Welcome!";
	}
	// Have a GET request to 'http://localhost:8080/daikichi/today' display text that says 'Today you will find luck in all your endeavors!'
	// method level @RequestMapping annotations
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	// Have a GET request to 'http://localhost:8080/daikichi/tomorrow' display text that says 'Tomorrow, an opportunity will arise, so be sure to be open to new ideas!'
	// Explicit GET request
	@RequestMapping(value="/tomorrow",method=RequestMethod.GET)
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
}
