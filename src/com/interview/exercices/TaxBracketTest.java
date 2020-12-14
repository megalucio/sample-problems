package com.interview.exercices;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/* Calculate tax given a particular tax range*/
public class TaxBracketTest {

	static double calculateTax(double income, double taxBracket[][]) {

		double totalTax = 0.0;
		double remainingIncomeToBeTaxaed = income;

		double bottom = taxBracket[taxBracket.length - 1][0];
		double taxPercentage = taxBracket[taxBracket.length - 1][1];

		// First calculates the taxes on biggest bracket
		if (remainingIncomeToBeTaxaed > bottom) {
			// Calculate tax for initial bracket
			Double taxable = remainingIncomeToBeTaxaed - bottom;
			totalTax += taxable * taxPercentage;

			// Update remaining income to be taxed
			remainingIncomeToBeTaxaed -= taxable;
		}

		// Second iterate brackets backwards to calculate remaining taxes
		for (int i = taxBracket.length - 1; i > 0; i--) {

			double top = taxBracket[i][0];
			bottom = taxBracket[i - 1][0];
			taxPercentage = taxBracket[i - 1][1];

			// Calculate tax remaining income only if it is in the appropriate bracket
			if (remainingIncomeToBeTaxaed > bottom && remainingIncomeToBeTaxaed <= top) {

				// Calculate tax for this bracket
				Double taxable = remainingIncomeToBeTaxaed - bottom;
				totalTax += taxable * taxPercentage;

				// Update remaining income to be taxed
				remainingIncomeToBeTaxaed -= taxable;

			}
		}

		return totalTax;
	}

	@Test
	public void test() {
		double taxBracket[][] = new double[4][2];

		taxBracket[0][0] = 0;
		taxBracket[0][1] = 0.10;
		taxBracket[1][0] = 10000;
		taxBracket[1][1] = 0.15;
		taxBracket[2][0] = 20000;
		taxBracket[2][1] = 0.20;
		taxBracket[3][0] = 40000;
		taxBracket[3][1] = 0.25;

		assertTrue(calculateTax(5000, taxBracket) == 500.0);
		assertTrue(calculateTax(16000, taxBracket) == 1900.0);
		assertTrue(calculateTax(20000, taxBracket) == 2500.0);
		assertTrue(calculateTax(21000, taxBracket) == 2700.0);
		assertTrue(calculateTax(26000, taxBracket) == 3700.0);
		assertTrue(calculateTax(56000, taxBracket) == 10500.0);
		assertTrue(calculateTax(72000, taxBracket) == 14500.0);
		assertTrue(calculateTax(172000, taxBracket) == 39500.0);

	}

}
