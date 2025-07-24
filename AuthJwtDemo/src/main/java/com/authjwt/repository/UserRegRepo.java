package com.authjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.authjwt.entity.User;
import java.util.List;


@Repository
public interface UserRegRepo extends JpaRepository<User, String>{
	
	Optional<User> findByUsername(String username);
	boolean existsByEmailid(String emailid);
    List<User> findByEmailid(String emailid);
	

}
