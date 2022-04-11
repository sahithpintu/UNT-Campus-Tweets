package com.untcampustweets.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="login")
public class Login {

	@Id
	@NotBlank(message = "*UserName is mandatory")
	private String userName;
	
	@NotBlank(message = "*Password is mandatory")
	private String password;
	
	public Login() {}
     // Login Constructor
	public Login(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}