package com.questions_answers_tags.moneem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions_answers_tags.moneem.models.Tag;
import com.questions_answers_tags.moneem.repositories.TagRepository;


@Service
public class TagService {
	@Autowired
	private TagRepository tagRepository;
	
	public Tag findBySubject(String subject) {
		return tagRepository.findBySubjectIs(subject);
	}
	
	public Tag addTag(Tag tag) {
		return tagRepository.save(tag);
	}
}