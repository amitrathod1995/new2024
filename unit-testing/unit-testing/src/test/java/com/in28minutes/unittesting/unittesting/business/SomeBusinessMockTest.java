package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.in28minutes.unittesting.unittesting.data.SomeDataService;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

	@InjectMocks
	SomeBusinessImpl Business;
	// = new SomeBusinessImpl();
	
	@Mock
	SomeDataService dataServiceMock;
	//= mock(SomeDataService.class);
	// dataServiceMock retrieveAllData new int[]{1,2,3}
	
//	@Before
//	public void before() {
//	Business.setSomeDataService(dataServiceMock);
//	}
	
	
	@Test
	public void calculateSumUsingDataService_basic() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
//		Business.setSomeDataService(dataServiceMock);
		assertEquals(6, Business.calculateSumUsingDataService());
	}

	@Test
	public void CalculateSum_onevalue() {

		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });
		assertEquals(0, Business.calculateSumUsingDataService());
	}

	
	  @Test public void CalculateSum_zero() {
	    
	  when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{5});
	  assertEquals(5, Business.calculateSumUsingDataService()); }
	 

}
