package com.book_api.moneem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.book_api.moneem.models.Book;
import com.book_api.moneem.services.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;
	
	
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id ,Model model) {
		Book book= bookService.findBook(id);
		// System.out.println("the books "+book.getTitle() +" "+book.getDescription());
		model.addAttribute("book", book);
		return "show.jsp";
	}

}
