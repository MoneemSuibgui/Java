package com.daikichi_pathvariable.moneem;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/daikichi") // Request mapping class level to avoid writing into the url "/daikichi" of our Controller methods 
public class DaikichiController {
    
	//Pass information from the client using @RequestMapping
	// Have an http Verb GET request to 'http://localhost:8080/daikichi/travel/kyoto' where the url will take any string for the city, and display text that says for example, 'Congratulations! You will soon travel to Tokyo!'.
	@RequestMapping("/travel/{city}")
	public String travel (@PathVariable(value="city") String city) {
		return "Congratulations! You will soon travel to "+city +"!";
	}
	
	
	
	@RequestMapping("/lotto/{num}")
	public String message(@PathVariable("num") String num) {
		// If the number is even, display text that says 
		// "You will take a grand journey in the near future, but be weary of tempting offers"
		if(Integer.parseInt(num)%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		//  If it is odd, display text that says 
		//  "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends."
		return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
	}
	
}
