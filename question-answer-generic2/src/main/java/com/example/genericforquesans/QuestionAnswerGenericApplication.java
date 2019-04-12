package com.example.genericforquesans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuestionAnswerGenericApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionAnswerGenericApplication.class, args);
	}

}
