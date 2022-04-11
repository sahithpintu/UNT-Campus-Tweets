package com.untcampustweets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.untcampustweets.model.Login;

public interface LoginRepository extends JpaRepository<Login, String>{
	// abstract method to get user details by username
	Login findByUserName(String userName);
}
