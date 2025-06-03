package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.bind.annotation.RequestMapping;

//http://localhost:8080/password/generate?length=12&upper=true&lower=true&special=true&digit=true

@SpringBootApplication

public class GeneratePasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneratePasswordApplication.class, args);
	}

}
