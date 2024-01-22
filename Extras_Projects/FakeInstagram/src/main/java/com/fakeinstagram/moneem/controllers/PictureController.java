package com.fakeinstagram.moneem.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fakeinstagram.moneem.models.User;
import com.fakeinstagram.moneem.services.PictureService;
import com.fakeinstagram.moneem.services.UserService;

@Controller
public class PictureController {

	@Autowired
	private PictureService picService;
	
	@Autowired
	private UserService userServ;
	
	private static String uploaded_folder="src/main/resources/static/imgs/";
	// public final String uploaded_folder = Paths.get("src/main/resources/static/image").toAbsolutePath().toString();
	
	// Display route "/home" (render our home.jsp page)
		@GetMapping("/home")
		public String dashboard(Model modelView,HttpSession session) {
			// test if the userId in session or not
			if(session.getAttribute("userId")==null){
				return "redirect:/";
			}
			Long id=(Long)session.getAttribute("userId");
			User loggedUser=userServ.findUserById(id);
			modelView.addAttribute("loggedUser", loggedUser);	
			return "dashboard.jsp";
		}
		
	 // Action route upload picture and save it
		@PostMapping("/home")
		public String uploadPicture(@RequestParam("description") String desc,
									@RequestParam("picture") MultipartFile file,
									Model model, HttpSession session,
									RedirectAttributes redirectAttribute) {
			User user=userServ.findUserById((Long)session.getAttribute("userId"));
			
			if(file.isEmpty()) {
				redirectAttribute.addFlashAttribute("errorMessage", "* Please Upload a picture !!!");
				return "redirect:/home";
			}
			try {
				// get the file and through it into server folder imgs
				byte[] bytes=file.getBytes();
				Path path=Paths.get(uploaded_folder + file.getOriginalFilename());
				Files.write(path, bytes);
				// get the URL of the file we just uploaded
				String url="/imgs/"+file.getOriginalFilename();
				System.out.println(url);
				this.picService.uploadPicture(desc, user, url);
				
			}catch(IOException e){
				e.printStackTrace();
			}
			return "redirect:/home";
			
		}
}
