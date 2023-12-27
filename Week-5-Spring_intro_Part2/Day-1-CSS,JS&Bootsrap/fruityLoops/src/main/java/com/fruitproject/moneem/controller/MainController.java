package com.fruitproject.moneem.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fruitproject.moneem.models.Item;

@Controller
public class MainController {
	

	@RequestMapping("/")
	public String home(Model model) {
		// create ArrayList of Item Object 
		ArrayList<Item> myFruits =new ArrayList<Item>();
		// Create items and store into myFruits ArrayList
		myFruits.add(new Item ("Kiwi",1.5));
		myFruits.add(new Item ("Mango",2.0));
		myFruits.add(new Item ("Goji Berries",4.0));
		myFruits.add(new Item ("Guava",0.75));
			
		// store our list into the model  to manipulate in jsp file and show us our fruits data in the browser 
		model.addAttribute("Fruits",myFruits);
	
		return "dashboard.jsp";
	}

}
