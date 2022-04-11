package com.manipal.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.untcampustweets.model.Tweet;
import com.untcampustweets.repository.TweetRepository;
import com.untcampustweets.service.TweetService;

@SpringBootTest
class TweetServiceTest {
	
	@Autowired 
	private TweetService tweetService;
	
	@MockBean
	private TweetRepository tweetRepository;

	@Test
	void testRetrieveAllTweets() {
		
		Tweet tweet = new Tweet(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		Tweet tweet2 = new Tweet(1,"Prateek", "Pjoshi", false, "#Holi", LocalDateTime.now(), "tweet image", "tweet Avatar",2);
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets.add(tweet);
		tweets.add(tweet2);

		when(tweetRepository.findAll()).thenReturn(tweets);
		assertEquals(2, tweetService.retrieveAllTweets().size());
	}

	@Test
	void testAddOrUpdateTweet() {
		Tweet tweet = new Tweet(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		tweetService.addOrUpdateTweet(tweet);
		verify(tweetRepository, times(1)).save(tweet);
	}

	@Test
	void testRetrieveTweetsByUserName() {
		Tweet tweet = new Tweet(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		Tweet tweet2 = new Tweet(2,"Param Attri", "Pattri", true, "#Holi", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		List<Tweet> tweets = new ArrayList<Tweet>();
		tweets.add(tweet);
		tweets.add(tweet2);
		
		when(tweetRepository.findByUserName("Pattri")).thenReturn(tweets);
		assertEquals(2, tweetService.retrieveTweetsByUserName("Pattri").size());
	}

	@Test
	void testDeleteTweetById() {
		Tweet tweet = new Tweet(1,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		tweetService.deleteTweetById(tweet.getTweetId());
		verify(tweetRepository, times(1)).deleteById(tweet.getTweetId());
	}

	@Test
	void testRetrieveTweetsByTweetId() {
		int tweetId = 10;
		Tweet tweet = new Tweet(10,"Param Attri", "Pattri", true, "#Diwali", LocalDateTime.now(), "tweet image", "tweet Avatar",1);
		when(tweetRepository.findById(tweetId)).thenReturn(Optional.of(tweet));
		assertEquals(tweet, tweetService.retrieveTweetsByTweetId(tweetId));
	}

}
