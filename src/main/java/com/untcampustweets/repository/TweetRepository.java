package com.untcampustweets.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.untcampustweets.model.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Integer>{
	//method to get List of tweets of specific user
	List<Tweet> findByUserName(String userName);
}
