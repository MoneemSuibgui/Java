package com.questions_answers_tags.moneem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.questions_answers_tags.moneem.models.Answer;
import com.questions_answers_tags.moneem.repositories.AnswerRepository;


@Service
public class AnswerService {
	@Autowired
	private AnswerRepository answerRepository;
	
	public List<Answer> questionAnswers(Long questionId) {
		return answerRepository.findByQuestionIdIs(questionId);
	}
	
	public Answer addAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
}