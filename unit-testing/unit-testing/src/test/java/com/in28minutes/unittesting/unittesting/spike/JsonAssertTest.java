package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse="{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	@Test
	public void JsonAssert_StrictTrue_ExactMatchExceptionForSpaces() throws JSONException
	{
		String expectedResponse="{\"id\":1, \"name\":\"Ball\", \"price\":10,\"quantity\":100}";
	     JSONAssert.assertEquals(expectedResponse, actualResponse, true);	
	}
	
	@Test
	public void JsonAssert_WithoutEscapeCharacters() throws JSONException
	{
		String expectedResponse="{id:1, name:Ball, price:10}";
		//if wehave space in the values then we can simply use this:-"{id:1, name:\"Ball 2\", price:10}";
		
	     JSONAssert.assertEquals(expectedResponse, actualResponse, false);	
	}
}
