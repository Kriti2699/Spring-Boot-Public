package com.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
	
	UserEntity findByEmail(String email);

}
