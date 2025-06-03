package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Index;

@RestController
@RequestMapping("/password")
public class PasswordController {
	private PasswordGeneratorWithParameter passwordGenerator = new PasswordGeneratorWithParameter();
	public PasswordController() {
        this.passwordGenerator = new PasswordGeneratorWithParameter();
    }

	   @GetMapping("/generate")
	    public String generatePassword(
	        @RequestParam int length,
	        @RequestParam boolean upper,
	        @RequestParam boolean lower,
	        @RequestParam boolean special,
	        @RequestParam boolean digit
	    ) {
	        return passwordGenerator.generateRandomPassword(length, upper, lower, special, digit);
	    }

}
