package com.untcampustweets.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.untcampustweets.model.Login;
import com.untcampustweets.model.User;
import com.untcampustweets.service.LoginService;
import com.untcampustweets.service.UserService;

@CrossOrigin(origins = "http://localhost:4000")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/twitter/register")
	public String registration(@RequestBody User user) {
		// service call for registration of  user and return success or not
		String registrationResponse = userService.registation(user);
		// if registration is success then add username and password to Login 
		if(registrationResponse.equals("Success")) {
			Login login = new Login();
			login.setUserName(user.getUserName());
			login.setPassword(user.getPassword());
			// service call to login for adding login details
			loginService.addLoginDetails(login);
			return registrationResponse;
		}
		
		return registrationResponse;
	}
	
	@GetMapping("/twitter/user/{userName}")
	public User userDetails(@PathVariable String userName){
		// call for getting user details
		return userService.userDetails(userName);
	}

	@PostMapping("/twitter/user/{userName}/change-password/{newPassword}")
	public String changePassword(@PathVariable String userName,@PathVariable String newPassword) {
		
		          //call to get login details
		      Login loginDetail=loginService.loginDetails(userName);
		      // set new password
		      loginDetail.setPassword(newPassword);
		      // call to get user details
		      User user = userService.userDetails(userName);
		      // set new password for user table
		          user.setPassword(newPassword);
		      // save registered user and get response    
	        String registrationResponse= userService.registation(user);
		      // update login details
		   String loginResponse=loginService.updateLoginDetails(loginDetail);
		   // if both reponses are same then return success
		   if(loginResponse.equals(registrationResponse))
		       return loginResponse;
		   else
			   return loginResponse;
		      
		      
	}
	
	@PostMapping("/twitter/user/{userName}/edit-profile/{displayName}/{emailId}")
	public String editProfile(@PathVariable String userName,@PathVariable String displayName,@PathVariable String emailId) {
		
		      // get user details
		      User user = userService.userDetails(userName);
		             //set user details
		          user.setDisplayName(displayName);
		          user.setEmailId(emailId);
		          // save user details to db
	        String registrationResponse= userService.registation(user);
		     // return response
		   return registrationResponse;
		      
		      
	}
}
