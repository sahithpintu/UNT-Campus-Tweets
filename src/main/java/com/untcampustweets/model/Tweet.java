package com.untcampustweets.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tweet")
public class Tweet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tweetId;
	
	private String displayName;
	private String userName;
	private boolean verified = false;
	
	@NotBlank(message = "*Cannot Post Empty Tweet")
	@Size(max=300)
	private String tweetBody;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime tweetCreationTime; 
	
	private String tweetImage;
	private String avatar;
	private int likes = 0;
	
	public Tweet() {}
	
	public Tweet(int tweetId, String displayName, String userName, boolean verified, String tweetBody,
			LocalDateTime tweetCreationTime, String tweetImage, String avatar, int likes) {
		
		super();
		this.tweetId = tweetId;
		this.displayName = displayName;
		this.userName = userName;
		this.verified = verified;
		this.tweetBody = tweetBody;
		this.tweetCreationTime = tweetCreationTime;
		this.tweetImage = tweetImage;
		this.avatar = avatar;
		this.likes = likes;
	}

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public String getTweetBody() {
		return tweetBody;
	}

	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}

	public LocalDateTime getTweetCreationTime() {
		return tweetCreationTime;
	}

	public void setTweetCreationTime(LocalDateTime tweetCreationTime) {
		this.tweetCreationTime = tweetCreationTime;
	}

	public String getTweetImage() {
		return tweetImage;
	}

	public void setTweetImage(String tweetImage) {
		this.tweetImage = tweetImage;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
}
