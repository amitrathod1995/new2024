package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import com.in28minutes.unittesting.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{1,2,3};
	}
	
}

class SomeDataServiceEmptyStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{};
	}
	
}

class SomeDataServiceOneElementStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		// TODO Auto-generated method stub
		return new int[]{5};
	}
	
}
public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingDataService_basic() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceStub());
		int actualresult = Business.calculateSumUsingDataService();
		int expectedresult =6;
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void CalculateSum_onevalue() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualresult = Business.calculateSumUsingDataService();
		int expectedresult =0;
		assertEquals(expectedresult, actualresult);
	}
	
	@Test
	public void CalculateSum_zero() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		Business.setSomeDataService(new SomeDataServiceOneElementStub());
		int actualresult = Business.calculateSumUsingDataService();
		int expectedresult =5;
		assertEquals(expectedresult, actualresult);
	}
	
}
