package com.todo.service;

import java.util.Optional;

import com.todo.entity.User;

public interface UserService {
	
	User create(User u);
	
	Optional<User> getById(Long id);
	
	boolean existsByUsername(String username);

	
	
	
	
	

}
