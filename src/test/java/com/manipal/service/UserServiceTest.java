package com.manipal.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.untcampustweets.model.User;
import com.untcampustweets.repository.UserRepository;
import com.untcampustweets.service.UserService;

@SpringBootTest
class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	void testRegistation() {
		User user = new User("Param Attri","Pattri","attri@gmail.com","qwerty","param avatar");
		userService.registation(user);
		verify(userRepository, times(1)).save(user);
	}

	@Test
	void testUserDetails() {
		userService.userDetails("Param");
		verify(userRepository, times(1)).findByUserName("Param");
	}

}
