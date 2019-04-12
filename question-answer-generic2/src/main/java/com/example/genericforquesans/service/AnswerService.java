package com.example.genericforquesans.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.genericforquesans.entities.Answer1;
import com.example.genericforquesans.repository.AnswerRepository1;

@Service
public class AnswerService {

	@Autowired
	private AnswerRepository1 answerRepository;
	
	public Page<Answer1> findAll(Pageable pageable){
		return answerRepository.findAll(pageable);
	}
	
	public Answer1 save(Answer1 answer) {
		return answerRepository.save(answer);
	}
	
	public Optional<Answer1> findById(Long answerId){
		return answerRepository.findById(answerId);
	}
	
	public void delete(Answer1 answer) {
		answerRepository.delete(answer);
	}
}
