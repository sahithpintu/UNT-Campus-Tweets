package com.manipal.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.untcampustweets.controller.LoginController;
import com.untcampustweets.model.Login;
import com.untcampustweets.service.LoginService;

@WebMvcTest(LoginController.class)
class LoginControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private LoginService loginService;
	
	@Test
	void testLogin() throws JsonProcessingException, Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		Login login = new Login("Pattri","qwerty");
		
		mvc.perform(post("/twitter/login")
				.content(objectMapper.writeValueAsString(login))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
