package com.example.demo;

import java.security.SecureRandom;

public class PasswordGeneratorWithParameter {
	 private static final String upper="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String lower=upper.toLowerCase();
	    private static final String digit="0123456789";
	    private static final String schar="!@#$%^&*()_+{}[]";
	 //   private static final String All_Char=upper+lower+digit+schar;
	    private static final SecureRandom random=new SecureRandom();

	    public String generateRandomPassword(int length,boolean isUpper,boolean isLower,boolean isSpecial,boolean isDigit){
	        StringBuilder password=new StringBuilder(length);

	        String passwordCharacters=generatePassword(isUpper,isLower,isSpecial,isDigit);
	        if (passwordCharacters.isEmpty())
	        {
	            return "";
	        }
	        for (int i=0;i<length;i++){
	            password.append(passwordCharacters.charAt(random.nextInt(passwordCharacters.length())));
	        }
	        return password.toString();
	    }

	    private String generatePassword(boolean isUpper,boolean isLower,boolean isSpecial,boolean isDigit){
	        String availableCharacters = "";

	        if(isDigit) {
	        	availableCharacters+=digit;
	        }
	        if (isUpper){
	            availableCharacters+=upper;
	        }
	        if (isLower){
	            availableCharacters+=lower;
	        }
	        if (isSpecial){
	            availableCharacters+=schar;
	        }

	        return availableCharacters;
	    }
}
