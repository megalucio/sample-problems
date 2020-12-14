package com.miscellaneous;

import static org.junit.Assert.assertTrue;

import java.util.Hashtable;
import java.util.Set;

import org.junit.Test;

public class FindDuplicatesInArray {

	public static int findDuplicates(Integer[] vector) {

		Hashtable<Integer, Boolean> hash = new Hashtable<Integer, Boolean>();

		int i;

		// Build the hash table
		for (i = 0; i < vector.length; i++) {

			if (hash.get(vector[i]) == null)
				hash.put(vector[i], false);
			else
				hash.put(vector[i], true);
		}

		// Search through the hash and check if the value is repeated
		int count = 0;

		Set<Integer> keys = hash.keySet();

		for (Integer key : keys) {
			if (hash.get(key))
				count++;
		}

		return count;
	}

	@Test
	public void test() {

		Integer[] vector = { 1, 2, 3, 3, 3, 4, 5, 2, 4, 5, 6, 2, 1, 7, 8, 9 };

		assertTrue(findDuplicates(vector) == 5);

	}

}
