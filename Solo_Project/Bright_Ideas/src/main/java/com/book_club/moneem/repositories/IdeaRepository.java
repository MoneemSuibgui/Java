package com.book_club.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book_club.moneem.models.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> {

	List<Idea> findAll();
}
