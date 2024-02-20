package com.in28minutes.unittesting.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;

@RunWith(SpringRunner.class)
@WebMvcTest(itemController.class)
public class itemControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	 private ItemBusinessService businessService;
	 
	@Test
	public void dummy_item_basic() throws Exception
	{   
	   
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
				.andReturn();
		
		// verify "Hello World"
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
	
	@Test
	public void ItemBusinessService() throws Exception
	{   
		//when(businessService.retreiveHardcodedItem()).thenReturn(
			//	new Item(2,"Item2",10,10));
		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:item2,price:10,quantity:100}"))
				.andReturn();
		
		// verify "Hello World"
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}
}
