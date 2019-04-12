package com.example.genericforquesans.entities;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers2")
public class Answer1 extends AuditModel{
	
	private static final long serialVersionUID = 3416346972094741334L;
	
	
	/*@GeneratedValue(generator = "answer_generator")
	@SequenceGenerator(
			name = "answer_generator",
			sequenceName = "answer_sequence")*/
	@Id
	private Long id;
	
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY, optional= false)
	@JoinColumn(name = "questionId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Question1 question;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question1 getQuestion() {
		return question;
	}

	public void setQuestion(Question1 question) {
		this.question = question;
	}   
}
