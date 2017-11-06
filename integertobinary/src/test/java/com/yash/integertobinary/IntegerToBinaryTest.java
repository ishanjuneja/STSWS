package com.yash.integertobinary;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntegerToBinaryTest {

	@Test
	public void test_no_input() {
		IntegerToBinary intbin = new IntegerToBinary();
		String result = intbin.integerToBinary(2);
		assertEquals("10", result);
	
	}

}
