package com.coding.bat;

import org.junit.Test;

public class CodingBatTest {
	
	@Test
	public void test() {
		
		CodingBat func = new CodingBat();
		
		System.out.println("paleto: " + func.notString("paleto"));
		
		System.out.println(func.missingChar("kitten", 5));
		
		System.out.println(func.nTwice("Code", 4)); 
		
		System.out.println(func.notReplace("isis"));
		
		System.out.println("hola".length());
		
		System.out.println("hola".substring(0,"hola".length() -1));
		
		
		
		int[]  aray = {1,2,3,2,2,2,2};
		
		System.out.println(func.sumArray(aray, 1, 3));
		
		String[] a = {"a", "c", "x"};
		String[] b ={"b", "c", "d", "x"};
		
		System.out.println(func.commonTwo(a, b));
		
		System.out.println(func.strDist("catcowcat", "cow"));
		
	}


}
