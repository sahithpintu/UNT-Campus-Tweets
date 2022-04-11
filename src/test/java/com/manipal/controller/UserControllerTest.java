package com.manipal.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.untcampustweets.controller.UserController;
import com.untcampustweets.service.LoginService;
import com.untcampustweets.service.UserService;

@WebMvcTest(UserController.class)
class UserControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserService userService;
	
	@MockBean
	private LoginService loginService;
	
	@Test
	void testUserDetails() throws Exception {	
		mvc.perform(get("/twitter/user/Pattri").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
