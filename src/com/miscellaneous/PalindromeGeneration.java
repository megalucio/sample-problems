package com.miscellaneous;

import java.util.Hashtable;

import org.junit.Test;

public class PalindromeGeneration {

	public PalindromeGeneration() {
		super();
	}

	/*
	 * This recursive function calculates if a string is a Palindorme or not. If the
	 * first and last character are the same, it will be a Palindorme if what is in
	 * the middle is a Palindrome.
	 */
	private static boolean isPalindrome(String str) {
		if (str.length() == 0 || str.length() == 1)
			return true;
		else if (str.charAt(0) == str.charAt(str.length() - 1))
			return isPalindrome(str.substring(1, str.length() - 1));
		else
			return false;
	}

	/*
	 * This recursive function generate all the possible combinations of a string.
	 * If the string is a palindrome it gets printed. We need to use a hashtable to
	 * make sure we are not repeating any combinations of the string
	 */
	private void printPalindromeCombinations(String head, String tail, Hashtable<String, Boolean> palindromes) {

		if (tail.length() <= 1 && isPalindrome(head + tail)) {
			if (palindromes.get(head + tail) == null)
				System.out.println(head + tail);
			palindromes.put(head + tail, true);
		} else {
			for (int i = 0; i < tail.length(); i++) {
				String n = tail.substring(0, i) + tail.substring(i + 1);
				printPalindromeCombinations(head + tail.charAt(i), n, palindromes);
			}
		}
	}

	/*
	 * This function encapsulates the recursive printPalindromeCombinations to
	 * abstract the caller from the details of the iteration of the vector as well
	 * as the hastable declaration needed for the palindormes not to repeat.
	 */
	public void printPalindromeCombinations(String[] vector) {

		int i;

		for (i = 0; i < vector.length; i++) {
			Hashtable<String, Boolean> hash = new Hashtable<String, Boolean>();
			printPalindromeCombinations("", vector[i], hash);
		}
	}

	@Test
	public void test() {

		String[] v = { "pla", "gato", "lol", "holaloha", "1010101", "87686" };

		printPalindromeCombinations(v);

	}

}
