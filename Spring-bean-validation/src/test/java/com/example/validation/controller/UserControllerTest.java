package com.example.validation.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.validation.dto.UserRequest;
import com.example.validation.entity.User;
import com.example.validation.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@AutoConfigureMockMvc(addFilters = false)

class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	UserService userService;

	@DisplayName("User can be created")
	@Test
	void testCreateuser_whenValidUserDetailsProvided_returnCreatedUserDetails() throws Exception {
		// Arrange
		UserRequest userRequest = new UserRequest("Prabhakar", "32", "prabhakar.kumar@avaya.com", "9686987209");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/create").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsBytes(userRequest));
		User user = new User();
		user.setId(UUID.randomUUID().getLeastSignificantBits());

		BeanUtils.copyProperties(userRequest, user);

		// Act
		when(userService.saveUser(any())).thenReturn(user);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String responseAsString = mvcResult.getResponse().getContentAsString();
		User user1 = new ObjectMapper().readValue(responseAsString, User.class);

		// Assert
		assertNotNull(user1);
		assertNotNull(user1.getId());
		assertEquals(userRequest.getName(), user1.getName());
	}

	@DisplayName("Invalid age, user cannot be created")
	@Test
	void testCreateUser_whenInvalidDetailsProvided_400ErrorShouldBeThrown() throws Exception {
		// Arrange
		String errorMsg = "Age should be > 18.";
		UserRequest userRequest = new UserRequest("Prabhakar", "12", "prabhakar.kumar@avaya.com", "9686987209");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/create")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsBytes(userRequest));
		User user = new User();
		user.setId(UUID.randomUUID().getLeastSignificantBits());

		BeanUtils.copyProperties(userRequest, user);
		
		// Act
		when(userService.saveUser(any())).thenReturn(user);
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		String responseAsString = mvcResult.getResponse().getContentAsString();
		assertEquals(HttpStatus.BAD_REQUEST.value(), mvcResult.getResponse().getStatus());
		assertTrue(responseAsString.contains(errorMsg));
	}

}
