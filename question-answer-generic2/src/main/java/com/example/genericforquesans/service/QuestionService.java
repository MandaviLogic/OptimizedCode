package com.example.genericforquesans.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.genericforquesans.entities.Question1;
import com.example.genericforquesans.repository.QuestionRepository1;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository1 questionRepository;
	
	public Page<Question1> findAll(Pageable pageable){
		return questionRepository.findAll(pageable);
	}
	
	public Question1 save(Question1 question) {
		return questionRepository.save(question);
	}
	
	public Optional<Question1> findById(Long questionId){
		return questionRepository.findById(questionId);
	}
	
	public void delete(Question1 question) {
		questionRepository.delete(question);
	}

	public boolean existsById(Long questionId) {
		return questionRepository.existsById(questionId);
	}
}
