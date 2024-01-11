package com.book_club.moneem_advanced.one_to_many.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book_club.moneem_advanced.one_to_many.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

	List<Book> findAll();
	//List<Book> findAllNotInBorrowedBooks();
	
}
