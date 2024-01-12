package com.book_club.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_club.moneem.models.Book;
import com.book_club.moneem.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	// create book
	public Book add(Book book) {
		return this.repository.save(book);
	}
	
	// update book
		public Book update(Book book) {
			return this.repository.save(book);
		}
	
	// get all books
	public List<Book> getAll(){
		return this.repository.findAll();
		
	}

}
