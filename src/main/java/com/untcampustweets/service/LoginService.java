package com.untcampustweets.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.untcampustweets.model.Login;
import com.untcampustweets.model.User;
import com.untcampustweets.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
		
	public void addLoginDetails(Login login) {
		// method to save login details
		loginRepository.save(login);
	}
	
	public boolean loginValidation(Login login) {
		// call to get login info of specific user
		Login loginInfo = loginRepository.findByUserName(login.getUserName());
		//getting password
		String password = loginInfo.getPassword();
		//if password matches return true
		if(password.equals(login.getPassword()))
			return true;
		else
			return false;
	}
	
	public Login loginDetails(String userName) {
		// call to get login details
		return loginRepository.findByUserName(userName);
	}
	
	public String updateLoginDetails(Login login) {
		// building validator using factory
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		//validate login object 
		Set<ConstraintViolation<Login>> violations = validator.validate(login);
		String errorMessage = "";
		for (ConstraintViolation<Login> violation : violations) {
		    errorMessage = violation.getMessage();
		}
		// if no error message then save login details to db
		if(errorMessage.equals("")) {
			loginRepository.save(login);
			return "Success";
		}
		else {
			return errorMessage;
		}
      
	}
}
