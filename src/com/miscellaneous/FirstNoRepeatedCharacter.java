package com.miscellaneous;

import static org.junit.Assert.assertTrue;

import java.util.Hashtable;

import org.junit.Test;

public class FirstNoRepeatedCharacter {

	// O(n^2) Algorithm
	public char findFirstNonRepeatedCharacter(String str) {

		char array[] = str.toCharArray();
		int i, j;
		char firstnorepeated = 0;

		for (i = array.length - 1; i >= 0; i--) {
			for (j = 0; j < array.length; j++) {
				if (i != j && array[i] == array[j])
					break;
				if (j == array.length - 1)
					firstnorepeated = array[i];
			}

		}

		return firstnorepeated;
	}

	// O(2n) Algorithm using a hash table
	public Character findFirstNoRepeatedCharacter(String str) {

		Hashtable<Character, Boolean> hash = new Hashtable<Character, Boolean>();

		Character c;
		int i, length;
		length = str.length();

		// Build the hash table
		for (i = 0; i < length; i++) {

			c = new Character(str.charAt(i));

			if (hash.get(c) == null)
				hash.put(c, false);
			else
				hash.put(c, true);
		}

		// Search through the string and check if the value is repeated in the
		// hash table
		for (i = 0; i < length; i++) {

			c = new Character(str.charAt(i));

			if (!hash.get(c)) {
				return c;
			}

		}

		return null;
	}

	@Test
	public void test() {

		String str = new String("galatxpegamentoaltoxtotalp");

		assertTrue(findFirstNonRepeatedCharacter(str) == 'm');

		assertTrue(findFirstNoRepeatedCharacter(str) == 'm');

	}

}
