package com.authjwt.service;

import java.util.List;
import java.util.Optional;

import com.authjwt.entity.User;


public interface UserRegSevice {
	
	User create(User u);
	boolean existsByUsername(String username);
	boolean existsByEmailId(String emailid);
	Optional<User> getById(String id);

	List<User> getAllUser();
	
	
}
