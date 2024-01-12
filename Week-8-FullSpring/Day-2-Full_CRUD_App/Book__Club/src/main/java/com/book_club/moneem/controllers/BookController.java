package com.book_club.moneem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.book_club.moneem.models.Book;
import com.book_club.moneem.models.User;
import com.book_club.moneem.services.BookService;
import com.book_club.moneem.services.UserService;

@Controller
public class BookController {

	// inject BookService & UserService
	@Autowired
	private BookService service;
	
	@Autowired
	private UserService userService;
	
	// Display route book form 
	@GetMapping("/books/new")
	public String createBook(@ModelAttribute("book") Book book,Model model,HttpSession session) {
		User user =userService.findUserById((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		
		System.out.println();
		return "newBook.jsp";
	}
	
	
	// Action route add new book
	@PostMapping("/books/new")
	public String saveBook(@Valid @ModelAttribute("book") Book book,BindingResult result,HttpSession session) {
	
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		User user =userService.findUserById((Long)session.getAttribute("userId"));
		book.setCreator(user);
		this.service.add(book);
		return "redirect:/home";
	}
	
	
	
	
	
}
