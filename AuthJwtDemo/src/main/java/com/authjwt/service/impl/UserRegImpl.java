package com.authjwt.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.authjwt.entity.User;
import com.authjwt.repository.UserRegRepo;
import com.authjwt.service.UserRegSevice;



@Service
public class UserRegImpl implements UserRegSevice {

	@Autowired
	private UserRegRepo repo;
	@Override
	public User create(User u) {	
		return repo.save(u);
	}
	@Override
	public boolean existsByUsername(String username) {
		Optional<User> existingUsername=repo.findByUsername(username);
		return existingUsername.isPresent();
	}
	@Override
	public Optional<User> getById(String id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public boolean existsByEmailId(String emailid) {
		// TODO Auto-generated method stub
		List<User> em=repo.findByEmailid(emailid);
		return !em.isEmpty();
	}



}
