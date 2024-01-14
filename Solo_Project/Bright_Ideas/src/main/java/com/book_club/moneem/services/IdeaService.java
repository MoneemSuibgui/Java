package com.book_club.moneem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book_club.moneem.models.Idea;
import com.book_club.moneem.repositories.IdeaRepository;

@Service
public class IdeaService {

	@Autowired
	private IdeaRepository repository;

	// create idea
	public Idea add(Idea idea) {
		return this.repository.save(idea);
	}

	// update idea
	public Idea update(Idea idea) {
		return this.repository.save(idea);
	}

	// find idea by id
	public Idea oneIdea(Long id) {
		Optional<Idea> optionalIdea = this.repository.findById(id);
		if (optionalIdea.isPresent()) {
			return optionalIdea.get();
		}
		return null;
	}

	// get all ideas
	public List<Idea> all() {
		return this.repository.findAll();
	}

	// delete idea
	public void delete(Long id) {
		Optional<Idea> idea = this.repository.findById(id);
		if (idea != null) {
			idea.get().setCreator(null);
			this.repository.deleteById(id);
		}
	}

}
