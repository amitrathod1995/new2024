package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HelloWorldController.class)
public class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloworld_basic() throws Exception
	{   
		RequestBuilder request = MockMvcRequestBuilders.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"))
				.andReturn();
		
		// verify "Hello World"
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
}
