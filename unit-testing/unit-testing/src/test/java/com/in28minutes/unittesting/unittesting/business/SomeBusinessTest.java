package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class SomeBusinessTest {

	@Test
	public void CalculateSum_basic() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		int actualresult = Business.calculateSum(new int[]{1,2,3});
		int expectedresult =6;
		assertEquals(expectedresult, actualresult);
	}

	@Test
	public void CalculateSum_onevalue() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		int actualresult = Business.calculateSum(new int[]{1});
		int expectedresult =1;
		assertEquals(expectedresult, actualresult);
	}
	
	@Test
	public void CalculateSum_zero() {
		
		SomeBusinessImpl Business = new SomeBusinessImpl();
		int actualresult = Business.calculateSum(new int[]{});
		int expectedresult =0;
		assertEquals(expectedresult, actualresult);
	}
	
}
