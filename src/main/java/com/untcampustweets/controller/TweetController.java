package com.untcampustweets.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.untcampustweets.model.Tweet;
import com.untcampustweets.service.TweetService;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/twitter/tweets")
	public List<Tweet> retriveAllTweets(){
		// service call for retrieving all tweets
		return tweetService.retrieveAllTweets();
	}
	
	@PostMapping("/twitter/tweet")
	public void addTweet(@RequestBody Tweet tweet) {
		//sets the tweet creation time
		tweet.setTweetCreationTime(LocalDateTime.now());
		// service call adding and updating tweet
		tweetService.addOrUpdateTweet(tweet);
	}
	
	@GetMapping("/twitter/tweets/user/{userName}")
	public List<Tweet> retrieveTweetsByUserName(@PathVariable String userName){
		// service call for retrieving tweets by username
		return tweetService.retrieveTweetsByUserName(userName);
	}
	
	@DeleteMapping("/twitter/tweets/{id}")
	public void deleteEmployee(@PathVariable int id){
		//service call for deleting tweet for id
		tweetService.deleteTweetById(id);
	}
	
	@GetMapping("/twitter/tweets/{id}")
	public Tweet getTweetById(@PathVariable int id) {
		// service call by retrieving tweets by id
		return tweetService.retrieveTweetsByTweetId(id);
	}
	
	@PutMapping("/twitter/tweets/{id}")
	public void updateTweet(@PathVariable int id, @RequestBody Tweet tweetDetails){
		// service call for retrieve twweets by id and retuen tweet object
		Tweet tweet = tweetService.retrieveTweetsByTweetId(id);
		
		// set tweetbody and tweet image
		tweet.setTweetBody(tweetDetails.getTweetBody());
		tweet.setTweetImage(tweetDetails.getTweetImage());
		
		// call for adding or updating tweet
		tweetService.addOrUpdateTweet(tweet);
	}
	
	@PutMapping("/twitter/tweets/like/{id}")
	public void updateTweetLikes(@PathVariable int id, @RequestBody Tweet tweetDetails) {
		// retrive tweet object by id
		Tweet tweet = tweetService.retrieveTweetsByTweetId(id);
		// set tweet likes
		tweet.setLikes(tweetDetails.getLikes());
		// add or update tweet
		tweetService.addOrUpdateTweet(tweet);
	}
}
