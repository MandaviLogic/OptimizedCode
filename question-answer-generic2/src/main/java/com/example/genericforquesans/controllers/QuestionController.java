package com.example.genericforquesans.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.genericforquesans.entities.Question1;
import com.example.genericforquesans.service.QuestionService;
import com.example.genericforquesans.exception.ResourceNotFoundException;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/questions2")
	public Page<Question1> readQuestion(Pageable pageable){
		return questionService.findAll(pageable);
	}
	
	@PostMapping("/questions2")
	public Question1 createQuestion(@Valid @RequestBody Question1 question) {
		return questionService.save(question);
	}
	
	@PutMapping("/questions2/{questionId}")
	public Question1 updateQuestion(@PathVariable Long questionId, 
			@Valid @RequestBody Question1 question) {
		Question1 ques = questionService.findById(questionId)
				.orElseThrow(() -> new ResourceNotFoundException("Question with id " +questionId +"not found"));
		  ques.setId(question.getId());
		  ques.setTitle(question.getTitle());
		  ques.setDescription(question.getDescription());
		  return questionService.save(ques);
	}
	
	@DeleteMapping("/questions2/{questionId}")
	public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId){
		Question1 ques = questionService.findById(questionId).orElseThrow(() -> new ResourceNotFoundException("Question with id " +questionId + "not found"));
		  questionService.delete(ques);
		  return ResponseEntity.ok().build();
	}
}
