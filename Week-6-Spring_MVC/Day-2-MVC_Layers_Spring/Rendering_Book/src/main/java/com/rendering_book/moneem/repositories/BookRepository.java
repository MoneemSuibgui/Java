package com.rendering_book.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rendering_book.moneem.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

	List<Book> findAll();
}
