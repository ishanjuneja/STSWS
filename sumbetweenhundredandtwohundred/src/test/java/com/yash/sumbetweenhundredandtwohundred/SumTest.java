package com.yash.sumbetweenhundredandtwohundred;

import static org.junit.Assert.*;

import org.junit.Test;

public class SumTest {
private final int start = 105;
private final int end = 105;
	@Test
	public void test_any_input() {
		Sum sum= new Sum();
		int result = sum.evaluate(start,end);
		assertEquals(0, result);
		
	}

}
