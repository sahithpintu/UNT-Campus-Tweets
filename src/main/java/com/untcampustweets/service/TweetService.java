package com.untcampustweets.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untcampustweets.model.Tweet;
import com.untcampustweets.repository.TweetRepository;

@Service
public class TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;

	public List<Tweet> retrieveAllTweets(){
		// retrieve all tweets
		List<Tweet> tweets = tweetRepository.findAll();
		// sort tweets using tweet creation time
		Collections.sort( tweets, (Comparator<? super Tweet>) (t1, t2) -> {
			if(t1.getTweetCreationTime().isAfter(t2.getTweetCreationTime()))
				return -1;
			else
				return 1;
		});		
		return tweets;
	}
	
	public void addOrUpdateTweet(Tweet tweet) {
		// save tweet
		tweetRepository.save(tweet);
	}
	
	public List<Tweet> retrieveTweetsByUserName(String userName) {
		
		// retrieve tweets using username
		List<Tweet> tweets = tweetRepository.findByUserName(userName);
		// sort using tweets creation time
		Collections.sort( tweets, (Comparator<? super Tweet>) (t1, t2) -> {
			if(t1.getTweetCreationTime().isAfter(t2.getTweetCreationTime()))
				return -1;
			else
				return 1;
		});
		
		return tweets;
	}
	
	public void deleteTweetById(int tweetId) {
		// delete tweets by id
		tweetRepository.deleteById(tweetId);
	}
	
	public Tweet retrieveTweetsByTweetId(int tweetId) {
		// find tweet by id
		return tweetRepository.findById(tweetId).orElse(null);
	}
}
