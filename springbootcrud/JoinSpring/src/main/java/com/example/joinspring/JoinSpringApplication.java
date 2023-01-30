package com.example.joinspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.joinspring.v1.model")
@EnableJpaRepositories("com.example.joinspring.v1.repository")
public class JoinSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoinSpringApplication.class, args);
	}

}
