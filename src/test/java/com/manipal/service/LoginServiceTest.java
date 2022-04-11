package com.manipal.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.untcampustweets.model.Login;
import com.untcampustweets.repository.LoginRepository;
import com.untcampustweets.service.LoginService;

@SpringBootTest
class LoginServiceTest {
	
	@Autowired
	private LoginService loginService;
	
	@MockBean
	private LoginRepository loginRepository;
	
	@Test
	void testAddLoginDetails() {
		Login login = new Login("Pattri","qwerty");
		loginService.addLoginDetails(login);
		verify(loginRepository, times(1)).save(login);
	}

	@Test
	void testLoginValidation() {
		Login login = new Login("Pattri","qwerty");
		when(loginRepository.findByUserName(login.getUserName())).thenReturn(login);
		loginService.loginValidation(login);
		verify(loginRepository, times(1)).findByUserName(login.getUserName());
	}

}
