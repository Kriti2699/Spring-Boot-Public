package com.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.EmailService;
import com.auth.util.UtillOtp;


@RestController
@RequestMapping("/api/otp")
public class ControllerOtp {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	Map<String, Object> sendOtp(@RequestParam String email)
	{
		
		Map<String, Object> response=new HashMap<>();
		try {
			String otp=UtillOtp.generateOtp(6);
			emailService.sendEmail(email, otp);
			response.put("status", "Success");
		}
		catch(Exception e){
			response.put("status", "Failure");
		}
		return response;
	}
	
}


