package com.coding.bat;

public class CodingBat {

	public CodingBat() {
		super();
	}

	/**
	 * Given a string, return a new string where "not " has been added to the
	 * front. However, if the string already begins with "not", return the
	 * string unchanged. Note: use .equals() to compare 2 strings.
	 * notString("candy") → "not candy" notString("x") → "not x"
	 * notString("not bad") → "not bad"
	 */
	public String notString(String str) {
		if (str.length() >= 3 && str.substring(0, 3).equals("not"))
			return str;
		else
			return "not ".concat(str);

	}

	/**
	 * Given a non-empty string and an int n, return a new string where the char
	 * at index n has been removed. The value of n will be a valid index of a
	 * char in the original string (i.e. n will be in the range
	 * 0..str.length()-1 inclusive).
	 * 
	 * missingChar("kitten", 1) → "ktten" missingChar("kitten", 0) → "itten"
	 * missingChar("kitten", 4) → "kittn"
	 */
	public String missingChar(String str, int n) {

		return str.substring(0, n).concat(str.substring(n + 1));

	}

	/**
	 * Given a string, return a new string where the first and last chars have
	 * been exchanged.
	 * 
	 * frontBack("code") → "eodc" frontBack("a") → "a" frontBack("ab") → "ba"
	 */
	public String frontBack(String str) {

		if (str.length() <= 1)
			return str;

		return str.substring(str.length() - 1)
				.concat(str.substring(1, str.length() - 1))
				.concat(str.substring(0, 1));
	}

	/**
	 * Given a string and a non-negative int n, return a larger string that is n
	 * copies of the original string.
	 * 
	 * stringTimes("Hi", 2) → "HiHi" stringTimes("Hi", 3) → "HiHiHi"
	 * stringTimes("Hi", 1) → "Hi"
	 */

	public String stringTimes(String str, int n) {
		int i;
		String aux = "";
		for (i = 0; i < n; i++) {
			aux = aux.concat(str);
		}
		return aux;
	}

	/**
	 * Given a string and an int n, return a string made of the first and last n
	 * chars from the string. The string length will be at least n.
	 * 
	 * nTwice("Hello", 2) → "Helo" nTwice("Chocolate", 3) → "Choate"
	 * nTwice("Chocolate", 1) → "Ce"
	 */
	public String nTwice(String str, int n) {
		if (str.length() < n)
			return "";
		return str.substring(0, n).concat(str.substring(str.length() - n));
	}

	/**
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another
	 * 'g' immediately to its left or right. Return true if all the g's in the
	 * given string are happy.
	 * 
	 * gHappy("xxggxx") → true gHappy("xxgxx") → false gHappy("xxggyygxx") →
	 * false
	 */
	public boolean gHappy(String str) {
		int i;
		boolean happy = true;
		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'g') {
				happy = false;
				if (i + 1 < str.length() && str.charAt(i + 1) == 'g')
					happy = true;
				if (i - 1 >= 0 && str.charAt(i - 1) == 'g')
					happy = true;
			}
		}

		return happy;

	}

	/**
	 * Given a string, return a string where every appearance of the lowercase
	 * word "is" has been replaced with "is not". The word "is" should not be
	 * immediately preceeded or followed by a letter -- so for example the "is"
	 * in "this" does not count. (Note: Character.isLetter(char) tests if a char
	 * is a letter.)
	 * 
	 * notReplace("is test") → "is not test" notReplace("is-is") →
	 * "is not-is not" notReplace("This is right") → "This is not right"
	 */
	public String notReplace(String str) {
		int i;

		for (i = 0; i < str.length(); i++) {
			if ((str.charAt(i) == 'i') // Find an i
					&& (str.length() != i + 1 && str.charAt(i + 1) == 's') 
					&& (i == 0 || !Character.isLetter(str.charAt(i - 1))) 
					&& (str.length() == i + 2 || !Character.isLetter(str
							.charAt(i + 2)))) { 
				str = str.substring(0, i).concat("is not")
						.concat(str.substring(i + 2));
			}
		}

		return str;

	}

	/**
	 * Consider the leftmost and righmost appearances of some value in an array.
	 * We'll say that the "span" is the number of elements between the two
	 * inclusive. A single value has a span of 1. Returns the largest span found
	 * in the given array. (Efficiency is not a priority.)
	 * 
	 * maxSpan({1, 2, 1, 1, 3}) → 4 maxSpan({1, 4, 2, 1, 4, 1, 4}) → 6
	 * maxSpan({1, 4, 2, 1, 4, 4, 4}) → 6
	 */

	public int maxSpan(int[] nums) {

		int i, j;
		int maxSpan = 0;

		if (nums.length == 0)
			return 0;

		for (i = 0; i < nums.length; i++) {
			for (j = nums.length - 1; j >= 0; j--) {
				if (nums[j] == nums[i] && Math.abs(i - j) > maxSpan)
					maxSpan = Math.abs(i - j);
			}
		}

		return maxSpan + 1;

	}

	/**
	 * Return an array that contains exactly the same numbers as the given
	 * array, but rearranged so that every 3 is immediately followed by a 4. Do
	 * not move the 3's, but every other number may move. The array contains the
	 * same number of 3's and 4's, every 3 has a number after it that is not a 3
	 * or 4, and a 3 appears in the array before any 4.
	 * 
	 * fix34({1, 3, 1, 4}) → {1, 3, 4, 1} fix34({1, 3, 1, 4, 4, 3, 1}) → {1, 3,
	 * 4, 1, 1, 3, 4} fix34({3, 2, 2, 4}) → {3, 4, 2, 2}
	 */

	public int[] fix34(int[] nums) {

		int i, j;
		int aux;

		for (i = 0; i < nums.length; i++) {
			for (j = nums.length - 1; j >= 0; j--) {
				if (nums[i] == 3 && nums[j] == 4) {
					aux = nums[i + 1];
					nums[i + 1] = 4;
					nums[j] = aux;
				}
			}
		}

		return nums;
	}

	/**
	 * Say that a "clump" in an array is a series of 2 or more adjacent elements
	 * of the same value. Return the number of clumps in the given array.
	 * 
	 * countClumps({1, 2, 2, 3, 4, 4}) → 2 countClumps({1, 1, 2, 1, 1}) → 2
	 * countClumps({1, 1, 1, 1, 1}) → 1
	 */

	public int countClumps(int[] nums) {

		int i;

		int clumps = 0;

		for (i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				clumps++;
			while (i < nums.length - 1 && nums[i] == nums[i + 1])
				i++;
			
		}

		return clumps;

	}

	/**
	 * Given n of 1 or more, return the factorial of n, which is n * (n-1) *
	 * (n-2) ... 1. Compute the result recursively (without loops).
	 * 
	 * factorial(1) → 1 factorial(2) → 2 factorial(3) → 6
	 */
	public int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n - 1);

	}

	/**
	 * We have a number of bunnies and each bunny has two big floppy ears. We
	 * want to compute the total number of ears across all the bunnies
	 * recursively (without loops or multiplication).
	 * 
	 * bunnyEars(0) → 0 bunnyEars(1) → 2 bunnyEars(2) → 4
	 */
	public int bunnyEars(int bunnies) {

		if (bunnies == 0)
			return 0;
		else
			return 2 + bunnyEars(bunnies - 1);

	}

	/**
	 * The fibonacci sequence is a famous bit of mathematics, and it happens to
	 * have a recursive definition. The first two values in the sequence are 0
	 * and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	 * previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	 * 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	 * fibonacci number, with n=0 representing the start of the sequence.
	 * 
	 * fibonacci(0) → 0 fibonacci(1) → 1 fibonacci(2) → 1
	 */
	public int fibonacci(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacci(n - 2) + fibonacci(n - 1);
	}

	/**
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
	 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
	 * have 3 ears, because they each have a raised foot. Recursively return the
	 * number of "ears" in the bunny line 1, 2, ... n (without loops or
	 * multiplication).
	 * 
	 * bunnyEars2(0) → 0 bunnyEars2(1) → 2 bunnyEars2(2) → 5
	 */
	public int bunnyEars2(int bunnies) {
		if (bunnies == 0)
			return 0;
		else if (bunnies % 2 != 0) // odd numers(not even)
			return 2 + bunnyEars2(bunnies - 1);
		else
			return 3 + bunnyEars2(bunnies - 1);

	}

	/**
	 * Given base and n that are both 1 or more, compute recursively (no loops)
	 * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 * 
	 * powerN(3, 1) → 3 powerN(3, 2) → 9 powerN(3, 3) → 27
	 */
	public int powerN(int base, int n) {
		if (n == 1)
			return base;
		else
			return base * powerN(base, n - 1);
	}

	/**
	 * Given a string that contains a single pair of parenthesis, compute
	 * recursively a new string made of only of the parenthesis and their
	 * contents, so "xyz(abc)123" yields "(abc)".
	 * 
	 * parenBit("xyz(abc)123") → "(abc)" parenBit("x(hello)") → "(hello)"
	 * parenBit("(xy)1") → "(xy)"
	 */
	public String parenBit(String str) {

		if (str.length() == 0)
			return null;
		else if (str.charAt(0) != '(')
			return parenBit(str.substring(1));
		else if (str.charAt(str.length() - 1) != ')')
			return parenBit(str.substring(0, str.length() - 1));
		else
			return str;

	}

	/**
	 * Given an array of ints, is it possible to divide the ints into two
	 * groups, so that the sums of the two groups are the same. Every int must
	 * be in one group or the other. Write a recursive helper method that takes
	 * whatever arguments you like, and make the initial call to your recursive
	 * helper from splitArray(). (No loops needed.)
	 * 
	 * splitArray({2, 2}) → true splitArray({2, 3}) → false splitArray({5, 2,
	 * 3}) → true
	 */
	public boolean splitArray(int[] nums) {
		int i, j;
		boolean split = false;
		if (nums.length == 0)
			return split;
		for (i = 0; i < nums.length; i++)
			for (j = nums.length - 1; j >= 0; j--)
				if (sumArray(nums, i, j) == sumArray(nums, j, i))
					split = true;

		return split;

	}

	public int sumArray(int[] array, int i, int j) {
		if (i == j)
			return array[i];
		else if (i <= j)
			return array[i] + sumArray(array, i + 1, j - 1) + array[j];
		else
			return 0;
	}

	/**
	 * Given an array of scores, return true if each score is equal or greater
	 * than the one before. The array will be length 2 or more.
	 * 
	 * scoresIncreasing({1, 3, 4}) → true scoresIncreasing({1, 3, 2}) → false
	 * scoresIncreasing({1, 1, 4}) → true
	 */
	public boolean scoresIncreasing(int[] scores) {

		int i;
		boolean increasing = true;
		for (i = 0; i < scores.length - 1; i++) {
			if (scores[i + 1] < scores[i])
				increasing = false;

		}

		return increasing;

	}

	/**
	 * Start with two arrays of strings, a and b, each in alphabetical order,
	 * possibly with duplicates. Return the count of the number of strings which
	 * appear in both arrays. The best "linear" solution makes a single pass over
	 * both arrays, taking advantage of the fact that they are in alphabetical
	 * order.
	 * 
	 * commonTwo({"a", "c", "x"}, {"b", "c", "d", "x"}) → 2 commonTwo({"a", "c",
	 * "x"}, {"a", "b", "c", "x", "z"}) → 3 commonTwo({"a", "b", "c"}, {"a",
	 * "b", "c"}) → 3
	 */
	public int commonTwo(String[] a, String[] b) {
		int i, j;
		int count = 0;

		for (i = 0; i < a.length; i++)
			for (j = 0; j < b.length; j++)
				if (a[i].equals(b[j]))
					count++;

		return count;

	}

	/**
	 * Given a string and a non-empty substring sub, compute recursively the
	 * largest substring which starts and ends with sub and return its length.
	 * 
	 * strDist("catcowcat", "cat") → 9 strDist("catcowcat", "cow") → 3
	 * strDist("cccatcowcatxx", "cat") → 9
	 */
	public int strDist(String str, String sub) {

		if (str.equals(""))
			return 0;

		if (str.startsWith(sub))
			return strDistRest(str, sub);

		return strDist(str.substring(1), sub);
	}

	private int strDistRest(String str, String sub) {
		if (str.endsWith(sub))
			return str.length();
		return strDistRest(str.substring(0, str.length() - 1), sub);
	}

	/**
	 * When squirrels get together for a party, they like to have cigars. A
	 * squirrel party is successful when the number of cigars is between 40 and
	 * 60, inclusive. Unless it is the weekend, in which case there is no upper
	 * bound on the number of cigars. Return true if the party with the given
	 * values is successful, or false otherwise.
	 * 
	 * cigarParty(30, false) → false cigarParty(50, false) → true cigarParty(70,
	 * true) → true
	 */
	public boolean cigarParty(int cigars, boolean isWeekend) {
		if (isWeekend && cigars >= 40)
			return true;
		if (!isWeekend && (cigars >= 40 && cigars <= 60))
			return true;
		return false;

	}

	/**
	 * You have a green lottery ticket, with ints a, b, and c on it. If the
	 * numbers are all different from each other, the result is 0. If all of the
	 * numbers are the same, the result is 20. If two of the numbers are the
	 * same, the result is 10.
	 * 
	 * greenTicket(1, 2, 3) → 0 
	 * greenTicket(2, 2, 2) → 20 
	 * greenTicket(1, 1, 2) → 10
	 */
	public int greenTicket(int a, int b, int c) {
		if (a == b && b == c)
			return 20;
		else if (a == b || b == c || a == c)
			return 10;
		else
			return 0;

	}
	
	/**
	 * We want to make a row of bricks that is goal inches long. We have a
	 * number of small bricks (1 inch each) and big bricks (5 inches each).
	 * Return true if it is possible to make the goal by choosing from the given
	 * bricks. This is a little harder than it looks and can be done without any
	 * loops. See also: Introduction to MakeBricks
	 * 
	 * makeBricks(3, 1, 8) → true 
	 * makeBricks(3, 1, 9) → false 
	 * makeBricks(3, 2, 10) → true
	 */
	public boolean makeBricks(int small, int big, int goal) {
		
		int maxMulti5 =  5*big;
		boolean doable = false;
		
		if(maxMulti5 < goal){
			if(maxMulti5 + small >= goal)
				doable = true;
		
		}else if(maxMulti5 > goal){
			if(small >= goal - (goal/5)*5)
				doable = true;
		
		}else //maxMulti5 == goal
			doable = true;
		
		return doable;
		
		
	}

}
