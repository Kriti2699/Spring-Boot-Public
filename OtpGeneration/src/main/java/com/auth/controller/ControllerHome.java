package com.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {
	
	   @GetMapping("/home")
	   public String home() {
		   return "index";
	   }

}
