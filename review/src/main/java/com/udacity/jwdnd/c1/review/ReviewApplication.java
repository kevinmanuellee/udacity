package com.udacity.jwdnd.c1.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

//	@Bean
//	public String message(){
//		System.out.println("Creating message bean");
//		return "Hello, Spring";
//	}

//	@Bean
//	public String upperCaseMessage(MessageService messageService){
//		System.out.println("Creating uppercase message bean");
//		return messageService.upperCase(message);
//	}
//
//	@Bean
//	public String lowerCaseMessage(MessageService messageService){
//		System.out.println("Creating lowercase message bean");
//		return messageService.lowerCase(message);
//	}
}
