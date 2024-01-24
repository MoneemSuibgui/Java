package com.consuming_api_.moneem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.consuming_api_.moneem.models.People;

@Controller
@RequestMapping("/star_wars")
public class MainController {

	// Declare the base url of star wars api
	private String baseURL = "https://swapi.dev/api";

	// inject restTemplate
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("")
	public String home(Model model) {

		People people = restTemplate.getForObject(this.baseURL + "/people", People.class);
		model.addAttribute("people", people);
		return "home.jsp";
	}

	@GetMapping("/people")
	public String showCharacter(@RequestParam(value = "id") Long id, Model model) {

		Character character = restTemplate.getForObject(String.format("%s/people/%d", this.baseURL, id),
				Character.class);
		model.addAttribute("character", character);

		return "character.jsp";
	}

}
