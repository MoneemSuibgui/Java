package com.hellohuman.project2.moneem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/")
public class HumanControllers {
	
	

	@RequestMapping("")
	public String index(@RequestParam(value="name",required=false) String fname,
						@RequestParam(value="lname",required=false)String lname,
						@RequestParam(value="times",required=false)String times) {
		
		if(fname == null && lname == null) {
		// display into the browser a default value of "Hello Human" if first name and last name aren't typing into our request 
			return "Hello Human";
		// display "Hello+first name" without last name if the last name is null
		}
		else if(lname == null && times==null) {
				return "Hello "+fname;
			}
		// SENSEI BONUS: Add a "times" parameter and show the greeting with first name that many times.
		else if(lname ==null && Integer.valueOf(times)>0) {
			String timesFname = "";
				for(int i=0;i<Integer.valueOf(times);i++) {
					timesFname+= "Hello"+fname+" ";	
				}
				return timesFname;
		}
		//  NINJA BONUS: Include a "last_name" as a parameter and print out both the first and last names.
		else{
			return "Hello "+fname+" "+lname;
		}
	}
}
