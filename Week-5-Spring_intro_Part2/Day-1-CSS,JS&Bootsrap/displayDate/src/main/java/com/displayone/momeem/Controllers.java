package com.displayone.momeem;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
	
	Date date=new Date();
	
	@RequestMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String getDate(Model model) {
		SimpleDateFormat formatDate= new SimpleDateFormat("EEEE,MMM d,yyyy ");
		String currentDate=formatDate.format(date);
		model.addAttribute("currentDate", currentDate);
		return "date.jsp";
	}
	
	
	@RequestMapping("/time")
	public String getTime(Model model) {
		SimpleDateFormat formatDate=new SimpleDateFormat("h:mm a");
		String currentTime=formatDate.format(date);
		model.addAttribute("currentTime", currentTime);
		return "time.jsp";
	}
}
