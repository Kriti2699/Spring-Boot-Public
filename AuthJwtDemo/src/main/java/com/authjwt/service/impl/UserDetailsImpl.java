package com.authjwt.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.authjwt.entity.User;
import com.authjwt.repository.UserLoginRepo;


@Service
public class UserDetailsImpl implements UserDetailsService{

	@Autowired
	private UserLoginRepo userRepo; 
	   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	        User user = userRepo.findByUsername(username);
	        if (user != null) {
	            return org.springframework.security.core.userdetails.User.builder()
	                    .username(user.getUsername())
	                    .password(user.getPassword())
	                    .roles(user.getRole())
	                    .build();
	        }
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }
}
