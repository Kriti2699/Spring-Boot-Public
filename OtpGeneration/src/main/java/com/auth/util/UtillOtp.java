package com.auth.util;

import java.util.Random;

public class UtillOtp {
	
	public static String generateOtp(int length) {
		
		String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        
        
        for(int i=0;i<length;i++) {
        	otp.append(numbers.charAt(random.nextInt(numbers.length())));
        }
		return otp.toString();
		
	}

}
