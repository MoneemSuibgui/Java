package com.book_api.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book_api.moneem.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

	List<Book> findAll();
}
