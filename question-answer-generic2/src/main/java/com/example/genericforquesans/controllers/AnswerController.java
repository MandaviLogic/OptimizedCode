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

import com.example.genericforquesans.entities.Answer1;
import com.example.genericforquesans.exception.ResourceNotFoundException;
import com.example.genericforquesans.service.AnswerService;
import com.example.genericforquesans.service.QuestionService;

@RestController
public class AnswerController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("questions2/{questionId}/answers2")
	public Page<Answer1> getAllAnswers(Pageable pageable){
		return answerService.findAll(pageable);
	}
	
	@PostMapping("questions2/{questionId}/answers2")
	public Answer1 postAnswers(@PathVariable Long questionId ,@Valid @RequestBody Answer1 answer) {
		return questionService.findById(questionId).map(question ->{
			answer.setQuestion(question);
			return answerService.save(answer);
		}).orElseThrow(() -> new ResourceNotFoundException("QuestionId " +questionId+ "not found"));
	}
	
	@PutMapping("questions2/{questionId}/answers2/{answerId}")
	public Answer1 updateAnswers(@PathVariable Long questionId ,@PathVariable Long answerId, @Valid @RequestBody Answer1 answer) {
		if(!questionService.existsById(questionId)) {
			throw new ResourceNotFoundException("Question with id " +questionId+ "not found");
		}
		
		Answer1 ans = answerService.findById(answerId).orElseThrow(() -> new ResourceNotFoundException("Anser with id " + answerId + " not found "));
		ans.setText(answer.getText());
		return answerService.save(ans);
	}
	
	@DeleteMapping("questions2/{questionId}/answers2/{answerId}")
	public ResponseEntity<?> deleteAnswers(@PathVariable Long answerId ,@PathVariable Long questionId){
		if(!questionService.existsById(questionId)) {
			throw new ResourceNotFoundException("Qustion with id " + questionId + " not found"); 
		}
		
		Answer1 ans = answerService.findById(answerId).orElseThrow(() -> new ResourceNotFoundException("Answer with id " +answerId+ "not found"));
           answerService.delete(ans);
           return ResponseEntity.ok().build();
	}
}
