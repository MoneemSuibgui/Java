package com.ninja_gold_game.java_game.moneem.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/earn/gold")
	public String earnGold(
			@RequestParam(value="farm" ,required=false) String farm,
			@RequestParam(value="cave",required=false) String cave,
			@RequestParam(value="house" ,required=false) String house,
			@RequestParam(value="quest" ,required=false) String quest,
			HttpSession session
			) {
		int totalGold=0;
		ArrayList<String> activities=new ArrayList<String>();
		SimpleDateFormat sdf =new SimpleDateFormat("MMMM ,d, yyyy ,HH:mm a");
		String currentDate=sdf.format(new Date()); 
		
		
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", totalGold);
			session.setAttribute("activities", activities);
		}else {
			totalGold = (int) session.getAttribute("gold");
			activities = (ArrayList<String>) session.getAttribute("activities");
		}
		
		// Random number type int(min,max)  :  Min + (int)(Math.random() * ((Max - Min) + 1))
		if(farm !=null) {
			int farmGold=(10+(int)(Math.random()*((20-10)+1)));
			// System.out.println(farmGold);
			totalGold+=farmGold;
			activities.add("You entere a " +farm +"and earned "+farmGold+" gold. "+"("+currentDate+")");
		}
		if(cave !=null) {
			int caveGold=(5+(int)(Math.random()*((10-5)+1)));
			 totalGold+=caveGold;
			 activities.add("You entere a " +cave +"and earned "+caveGold+" gold "+currentDate);

		      
		}
		if(house !=null) {
			int houseGold=(2+(int)(Math.random()*((5-2)+1)));
			totalGold+=houseGold;
			activities.add("You entere a " +house +"and earned "+houseGold+" gold "+currentDate);
			
		    
		}
		if(quest !=null) {
			int questGold=(-50+(int)(Math.random()*((50)+1)));
			if(questGold>=0) {
				activities.add("You entere a " +quest +"and earned "+questGold+" gold "+currentDate);
			}else {
				activities.add("You failed a " +quest +"and lost "+questGold+" gold "+currentDate);

			}
			totalGold+=questGold;
		}
		session.setAttribute("gold", totalGold);
		session.setAttribute("activities",  activities);
		
		//System.out.println("total : "+totalGold);
		//for(int i=0 ;i<activities.size();i++) {
			//System.out.println(activities.get(i));
		//}
		
		return "redirect:/";
	}
	
	//extras: Create a reset button
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("activities", new ArrayList<String>());
		return "redirect:/";
	}
}
