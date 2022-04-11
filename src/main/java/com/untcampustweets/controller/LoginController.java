package com.untcampustweets.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.untcampustweets.model.Login;
import com.untcampustweets.service.LoginService;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/twitter/login")
	public String login(@RequestBody Login login) {
	 
		// method for validating login 
		boolean isValidated = loginService.loginValidation(login);
		// checks if result is success or not.
		if(isValidated) {
			return "Success";
		}
		else
			return "Not Success";
	}

}
