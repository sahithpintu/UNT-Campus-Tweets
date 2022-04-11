package com.untcampustweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.untcampustweets.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	// get method for finding user by username
	User findByUserName(String userName);
}
