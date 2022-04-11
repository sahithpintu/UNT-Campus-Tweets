package com.untcampustweets.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user")
public class User {
	
	@NotBlank(message = "*DisplayName is mandatory")
	private String displayName;
	
	@Id
	@NotBlank(message = "*UserName is mandatory")
	private String userName;
	
	@Email(message = "Enter a Valid EmailId!")
	@NotBlank(message = "*Email is mandatory")
	private String emailId;
	
	@NotBlank(message = "*Password is mandatory")
	private String password;
	
	private String avatar;
	
	public User() {}
	
	public User(@NotBlank(message = "*DisplayName is mandatory") String displayName,
			@NotBlank(message = "*UserName is mandatory") String userName,
			@Email(message = "Enter a Valid EmailId!") @NotBlank(message = "*Email is mandatory") String emailId,
			@NotBlank(message = "*Password is mandatory") String password, String avatar) {
		super();
		this.displayName = displayName;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.avatar = avatar;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
