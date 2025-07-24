package com.authjwt.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authjwt.Jwt.JwtUtil;
import com.authjwt.entity.User;
import com.authjwt.repository.UserLoginRepo;

import com.authjwt.service.Emailservice;
import com.authjwt.service.OTPService;


@RestController
@RequestMapping("/userlogin")
public class UserLoginController {
	
	@Autowired
	private Emailservice emailService;
	@Autowired
	private OTPService otpService;
	@Autowired
	private UserLoginRepo userLoginRepo;
	@Autowired
	private JwtUtil jwtutil;
	
	@PostMapping("/send")
	Map<String, Object> sendOtp(@RequestParam String email)
	{
		
		Map<String, Object> response=new HashMap<>();
		try {
			String otp=otpService.generateOtp(6);
			Optional<User> user=userLoginRepo.findByEmailid(email);
			System.out.println(">>>>>>>>>>>>>>"+userLoginRepo.findByEmailid(email));
			String data="";
			
			if(user.isPresent()) {
				
				User u=user.get();
				u.setEmailid(email);
				u.setOtp(otp);
				u.setOtpGenerationTime(System.currentTimeMillis());
				userLoginRepo.save(u);
				emailService.sendEmail(email, otp);
				data=otp;
			}
			else {
				data="User not found";
			}
									
			response.put("status", "Success");
			response.put("data", data);
		}
		catch(Exception e){
			response.put("status", "Failure");
			response.put("data", e.fillInStackTrace());
		}
		return response;
	}
	@PostMapping("/verify-otp")
	Map<String, Object> verifyOtp(@RequestParam String email,@RequestParam String otp){
		
		String data = null;
		Map<String,Object> response=new HashMap<>();
		try {
			Optional<User> user=userLoginRepo.findByEmailid(email);
			
			User u=user.get();
			if(otpService.isOtpExpired(u.getOtpGenerationTime())) {
				data="OTP expired";
				response.put("status","Failure");
				response.put("data", data);
			}
			if(u.getOtp().equals(otp)) {
				
				String token=jwtutil.generateToken(email);
				data="OTP verified Successfully";
				response.put("status","Success");
				response.put("data", data);
				response.put("token", token);
				
			}
			else {
				data="Invalid OTP";
				response.put("status","Failure");
				response.put("data", data);
			}

		}
		catch(Exception e) {
			response.put("status","Failure");
			response.put("data", e.fillInStackTrace());
		}
		return response;
		
	}
	

}
