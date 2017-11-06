package com.yash.sumofdigits;

import static org.junit.Assert.*;

import org.junit.Test;

public class sumofdigitstest {
private final String input="1+2+5+8+s+a+85";
	@Test
	public void test_no_input() {
		SumOfDigits sod = new SumOfDigits();
		int result=sod.calculate("");
		assertEquals(0, result);
	}

	@Test
	public void test_any_input() {
		SumOfDigits sod = new SumOfDigits();
		int result=sod.calculate(input);
		assertEquals(101, result);
	}
	
	
	
}
