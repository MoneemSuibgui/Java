// Assignment: Counter
// You need to keep track of how many times the same visitor visits a certain page. To do this, you will first need to write a basic counter. Create two pages, one that will show you how many times someone has visited the other.

package com.counterproject.moneem.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class MainControllers {
	
	// Increment the counter on each visit to http://your_server/
	// Counter must start at zero
	@GetMapping("")
	public String dashboard(HttpSession session) {
		
		int firstCount=0;
		
		
		
		if(session.getAttribute("counter")== null ) {
			session.setAttribute("counter", 0);
		// increment the counter by 1
		}else {
				firstCount=(int)session.getAttribute("counter")+1;
			    session.setAttribute("counter", firstCount);
		}	
		
		return "dashboard.jsp";
	}
	
	// Create and display a counter on http://your_server/counter
	@GetMapping("/counter")
	public String counter(HttpSession session) {
		// int firstCounter=(int)session.getAttribute("counter");
		// System.out.println("the first counter : "+firstCounter);
		return "counter.jsp";
	}
	
	
	
}




