package com.rendering_all_books.moneem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rendering_all_books.moneem.models.Book;
import com.rendering_all_books.moneem.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	// retrieve one book
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id ,Model model) {
		Book book= bookService.findBook(id);
		// System.out.println("the books "+book.getTitle() +" "+book.getDescription());
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	// get all books
	@GetMapping("/books")
	public String allBooks(Model model) {
		List <Book> allBooks=bookService.allBooks();
		model.addAttribute("books", allBooks);
		return "index.jsp";
	}

}
