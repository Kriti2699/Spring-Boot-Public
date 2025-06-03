package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.User;

@Repository
public interface UserLoginRepo extends JpaRepository<User, String> {
	
	Optional<User> findByEmailid(String emailid);
	void save(Optional<User> user);

	

}
