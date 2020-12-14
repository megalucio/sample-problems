package com.project.euler;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MultiplesOf3and5 {

	/**
	 * Problem 1 Multiples of 3 and 5. If we list all the natural numbers below 10
	 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
	 * multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.
	 */
	public int multiplesOf3and5(int value) {

		int i, val = 0;

		for (i = 0; i < value; i++)
			if (i % 3 == 0 || i % 5 == 0)
				val += i;
		return val;

	}

	@Test
	public void test() {
		
		assertTrue(multiplesOf3and5(10) == 23);
		assertTrue(multiplesOf3and5(1000) == 233168);

	}

}
