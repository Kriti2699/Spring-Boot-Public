package com.authjwt.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.authjwt.entity.User;
import com.authjwt.service.UserRegSevice;

@RestController
@RequestMapping("/userReg")
public class UserRegController {
	
	@Autowired
	private UserRegSevice userregservice;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/createUser")
	Map<String, Object> createUser(@RequestBody User u){
		
		Map<String, Object> response=new HashMap<>();
		
		u.setUpdateon(LocalDateTime.now());
		u.setCreateon(LocalDateTime.now());
		u.setRole("USER");
		boolean userexist=userregservice.existsByUsername(u.getUsername());
		User users=new User();	
		try {
			if(userregservice.existsByUsername(u.getUsername())) {
				response.put("status", "Failure");
	            response.put("error", "Username already exists! Please choose another.");
	            return response;
			}
			else if(userregservice.existsByEmailId(u.getEmailid())) {
				response.put("status", "Failure");
	            response.put("error", "Email Id already exists! Please choose another.");
	            return response;
			}
			else {
				u.setPassword(passwordEncoder.encode(u.getPassword()));
				response.put("status", "Success");
				response.put("data",userregservice.create(u));
			}
			
		}
		catch(Exception e) {
			response.put("status", "Failure");
			response.put("data",e.fillInStackTrace());
		}
		return response;
	}
	
	@GetMapping("/getUser/{id}")
	Map<String, Object> getUser(@PathVariable String id){
		
		Map<String, Object> response=new HashMap<>();
		try {
			response.put("Status", "Success");
			response.put("Data",userregservice.getById(id));
		} catch (Exception e) {
			response.put("Status", "Failure");
			response.put("Error",e.getMessage());
		}
		return response;
	}
	@GetMapping("/getAllUser")
	Map<String, Object> getAllUser(){
		
		Map<String, Object> response=new HashMap<>();
		try {
			response.put("Status", "Success");
			response.put("Data",userregservice.getAllUser());
		} catch (Exception e) {
			response.put("Status", "Failure");
			response.put("Error",e.getMessage());
		}

		return response;
		
	}
	
	
}
