package com.rendering_book.moneem.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rendering_book.moneem.models.Book;
import com.rendering_book.moneem.services.BookService;

@RestController
public class MainCotntroller {
	
	private final BookService bookService;
	
	public MainCotntroller(BookService bookService) {
		this.bookService=bookService;
	}
	
	// Get all books
	@RequestMapping("/api/books")
	public List<Book> getAllBooks(){
		return bookService.allBooks();
	}
	
	// Create one book
	@RequestMapping(value="/api/books" ,method=RequestMethod.POST)
	public Book createBook(@RequestParam("title") String title,
			               @RequestParam("description") String description,
			               @RequestParam("language") String language,
			               @RequestParam("numberOfPages") Integer pages
			               ) {
		// instantiate new book full args and pass all full fields to it
		Book book=new Book(title,description,language,pages);
		// save our new book to db
		return bookService.createBook(book);	
	}
	
	// Delete one book
	@RequestMapping(value="/api/books/{id}",method=RequestMethod.DELETE)
	public String deleteOneBook(@PathVariable("id") Long id) {
		return bookService.deleteBook(id);
	}
	
	// Update one book
	@RequestMapping(value="/api/books/{id}" ,method=RequestMethod.PUT)
	public Book updateBook(@RequestParam("id") Long id,
			               @RequestParam("title") String title,
			               @RequestParam("description") String description,
			               @RequestParam("language") String language,
			               @RequestParam("numberOfPages") Integer pages
			               ) {
		// create temporary instance of book to update our book
		Book book=new Book(title,description,language,pages);
		book.setId(id);
		// update our book
		return bookService.updateBook(book);	
	}
	
	// Retrieve one book
	@RequestMapping("/api/books/{id}")
	public Book oneBook(@PathVariable(value="id") Long id) {
		return bookService.findBook(id);
	}

}
