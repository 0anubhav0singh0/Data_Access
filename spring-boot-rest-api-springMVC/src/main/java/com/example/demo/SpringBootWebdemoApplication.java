package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

// solution to error "Not a managed type: class com.psl.training.model.Employee"
@EntityScan("com.psl.training.model") 
@SpringBootApplication
public class SpringBootWebdemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebdemoApplication.class, args);
	}

}
