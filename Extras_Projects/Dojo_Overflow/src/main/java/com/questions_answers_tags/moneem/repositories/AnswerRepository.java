package com.questions_answers_tags.moneem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.questions_answers_tags.moneem.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByQuestionIdIs(Long id);
}
