package com.questions_answers_tags.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.questions_answers_tags.moneem.models.Question;
import com.questions_answers_tags.moneem.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

	// get all tags
	//List<Tag> findAll();
	
	// get all tags by question
	List<Tag> findAllByQuestions(Question question);
	
	// find tag by tagContent
	Tag findBySubjectIs(String subject);

}
