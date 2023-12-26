package com.receiptproject.moneem.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Render data from my Controller
@Controller
public class receiptController {
	
	@RequestMapping("/")
	public String showReceipt(Model model) {
		String customerName="Grace Hopper";
		String itemName="Copper wire";
		double price=5.25;
		String Description="Metal strips .Also an illustration of nanoseconds";
		String vendor="Little Corner Store";
		
		// To pass data to our view can be as simple as injecting a Model object to our method:
		model.addAttribute("customerfullName",customerName);
		model.addAttribute("itemName", itemName);
		model.addAttribute("price", price);
		model.addAttribute("description",Description);
		model.addAttribute("vendor", vendor);
		return "index.jsp";
	}

}
