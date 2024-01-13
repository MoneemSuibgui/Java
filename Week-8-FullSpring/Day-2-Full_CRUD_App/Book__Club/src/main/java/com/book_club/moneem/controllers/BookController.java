package com.book_club.moneem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String createBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);

			return "newBook.jsp";
		}
		return "redirect:/";

	}

	// Action route add new book
	@PostMapping("/books/new")
	public String saveBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "newBook.jsp";
		}
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		book.setCreator(user);
		this.service.add(book);
		return "redirect:/home";
	}

	// Display route show one book
	@GetMapping("/books/{id}")
	public String showBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		if (session.getAttribute("userId") != null) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Book book = this.service.getOne(id);
			model.addAttribute("book", book);
			model.addAttribute("user", user);
			return "showOne.jsp";
		}
		return "redirect:/";
	}

	// Action route delete book
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id) {
		Book book = this.service.getOne(id);
		book.setCreator(null);
		this.service.delete(id);
		return "redirect:/home";
	}

	// Display route edit book page
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session,
			@ModelAttribute("book") Book book) {
		if(session.getAttribute("userId") != null) {
		Book editedBook = this.service.getOne(id);
		model.addAttribute("book", editedBook);
		return "editBook.jsp";
		} return "redirect:/";
	}

	// Action route update book
	@PutMapping("/books/{id}/edit")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session) {

		if (result.hasErrors()) {
			return "editBook.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		User user = userService.findUserById(userId);
		book.setCreator(user);
		this.service.update(book);
		return "redirect:/home";
	}

}
