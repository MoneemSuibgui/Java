package com.questions_answers_tags.moneem.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.questions_answers_tags.moneem.models.Answer;
import com.questions_answers_tags.moneem.models.Question;
import com.questions_answers_tags.moneem.models.Tag;
import com.questions_answers_tags.moneem.services.AnswerService;
import com.questions_answers_tags.moneem.services.QuestionService;
import com.questions_answers_tags.moneem.services.TagService;


@Controller
public class MainController {
	
	// inject our services into MainController
	private QuestionService questionService;
	private AnswerService answerService;
	private TagService tagService;
	
	public MainController( QuestionService questionService,
							AnswerService answerService,
							TagService tagService) {
		this.questionService=questionService;
		this.answerService=answerService;
		this.tagService=tagService;
	}
	
	//  Display route for home page (get all questions with their tags) 
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", questionService.allQuestions());
		return "home.jsp";
	}
	
	// Display route for question form
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "questionForm.jsp";
	}
	
	// Action route for submit the form
	@PostMapping("/create/question")
	public String addQuestion(@Valid @ModelAttribute("question") Question question,BindingResult result,@RequestParam("tagsList") String tagsList,RedirectAttributes redirectAttribute) {
		
		if(result.hasErrors()) {
			return "questionForm.jsp";
		}
		
		// create a method to manipulate tagsList String into List
		List<Tag> tags =checkAndAddtags(tagsList);
		if(tags == null || tags.size()>3) {
			redirectAttribute.addFlashAttribute("errorMassage", "* Tag must not be empty & not be more than 3 tags");
			return "redirect:/questions/new";
		}
		else {
			question.setTags(tags);
			questionService.addQuestion(question);
			return "redirect:/";
		}
		
	}
	
	
	// method for check tags and add to tags list into the question
	private List<Tag> checkAndAddtags(String tagsString){
		if(tagsString.length()>0) {
			ArrayList<Tag> tags=new ArrayList<Tag>();
			// put the tags field into a list of strings and split them with comma
			String[] tagsStrings = tagsString.split(",");
			for(String oneTag:tagsStrings) {
			  Tag optionalTag=tagService.findBySubject(oneTag.toLowerCase().strip());
			  if(optionalTag == null) {
				  // if the tag doesn't exist in db we saved into db & added to tags list
				  Tag tag = new Tag(oneTag.toLowerCase().strip());
				  tagService.addTag(tag);
				  tags.add(tag);
			  }
			  //if the tag exist we just added to the list 
			  tags.add(optionalTag);
			}
			return tags;
		}
			return null;		
	}
	
	
	// Display route for question answers page
	@GetMapping("/question/{questionId}")
	public String answerToQuestion(Model modelView,@ModelAttribute("answer") Answer answer,@PathVariable("questionId") Long questionId) {
		Question question=questionService.findById(questionId);
		modelView.addAttribute("question", question);
		return "questionAnswers.jsp";
	}
	
	// Action route submit the form and save the answer of specific question in the database
	@PostMapping("/question/{questionId}/answer/new")
	public String AddAnswer(@Valid @ModelAttribute("answer") Answer answer
							,BindingResult result,
							@PathVariable("questionId") Long questionId,Model modelView) {
		if(result.hasErrors()) {
			modelView.addAttribute("question",questionService.findById(questionId));
			return "questionAnswers.jsp";
		}
		
		Question question=questionService.findById(questionId);
		// set the answer to the question and save it to the database
		answer.setQuestion(question);
		answerService.addAnswer(answer);
		return "redirect:/question/"+questionId;
	}

}









