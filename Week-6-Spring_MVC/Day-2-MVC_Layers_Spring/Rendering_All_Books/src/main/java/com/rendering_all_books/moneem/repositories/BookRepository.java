package com.rendering_all_books.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rendering_all_books.moneem.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book,Long> {

	List<Book> findAll();
}
