package com.rendering_book.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rendering_book.moneem.models.Book;
import com.rendering_book.moneem.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo=bookRepo;
	}
	
	// return all the books
	public List<Book> allBooks(){
		return bookRepo.findAll();
	}
	
	// create one book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
	
	// update one book
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}
	
	// retrieve one book
	public Book findBook(Long id) {
		Optional<Book> optionalBook=bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
	
	// delete one book
	public String deleteBook(Long id) {
		Optional<Book> optinalBook=bookRepo.findById(id);
		if(optinalBook.isPresent()) {
			bookRepo.deleteById(id);
			return "Book Successfuly deleted ";
		}else {
			return "This book is not in the database";
		}
	}
	
	// we could delete one book other way just passing the id and the method return nothing
	
	//public void deleteOneBook(Long id) {
	//	 bookRepo.deleteById(id);
	//}
	
	
	
	
	

}
