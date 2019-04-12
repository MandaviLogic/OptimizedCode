package com.example.genericforquesans.entities;

import javax.persistence.*;

@Entity
@Table(name = "questions2")
public class Question1 extends AuditModel{

	private static final long serialVersionUID = 5893624696273079481L;
	
	
	/*@GeneratedValue(generator = "question_generator")
	@SequenceGenerator(
			name = "question_generator",
			sequenceName = "question_sequence",
			initialValue = 100)*/
	@Id
	private Long id;
    
	
	private String title;
	
	
	private String description;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
      
}
