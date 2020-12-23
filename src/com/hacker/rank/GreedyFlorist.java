package com.hacker.rank;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class GreedyFlorist {

	// Complete the getMinimumCost function below.
	static int getMinimumCost(int k, int[] c) {

		Arrays.sort(c);

		int totalAdded = 0;
		int total = 0;
		int round = 0;
		int index = c.length - 1;

		for (int j = 0; j < c.length; j++) {

			total += (round + 1) * c[index];
			totalAdded++;

			if (totalAdded == k) {
				round++;
				totalAdded = 0;
			}

			index = index > 0 ? index - 1 : c.length - 1;

		}

		return total;

	}

	@Test
	public void test() {

		int[] c;
		int minimumCost;

		c = new int[] { 1, 2, 3, 4 };
		minimumCost = getMinimumCost(3, c);
		assertTrue(minimumCost == 11);

		c = new int[] { 2, 5, 6 };
		minimumCost = getMinimumCost(3, c);
		assertTrue(minimumCost == 13);

		c = new int[] { 2, 5, 6 };
		minimumCost = getMinimumCost(2, c);
		assertTrue(minimumCost == 15);

		c = new int[] { 1, 3, 5, 7, 9 };
		minimumCost = getMinimumCost(3, c);
		assertTrue(minimumCost == 29);

	}

//	private static final Scanner scanner = new Scanner(System.in);
//
//	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		String[] nk = scanner.nextLine().split(" ");
//
//		int n = Integer.parseInt(nk[0]);
//
//		int k = Integer.parseInt(nk[1]);
//
//		int[] c = new int[n];
//
//		String[] cItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int cItem = Integer.parseInt(cItems[i]);
//			c[i] = cItem;
//		}
//
//		int minimumCost = getMinimumCost(k, c);
//
//		bufferedWriter.write(String.valueOf(minimumCost));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();
//
//		scanner.close();
//	}

}
