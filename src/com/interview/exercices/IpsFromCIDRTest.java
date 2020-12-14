package com.interview.exercices;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/* Generate all ips given a particular CIDR subnet*/
public class IpsFromCIDRTest {

	public static List<String> buildIps(String cidrAddresses) {
		List<String> ips = new ArrayList<>();

		// Extract initialIp from input
		String initIp = cidrAddresses.split("/")[0];
		// Extract mask from input
		int mask = Integer.parseInt(cidrAddresses.split("/")[1]);
		// Convert ip address into an array for operating better
		String[] ipArray = initIp.split("\\.");

		// Add as many directions as 2^(32 - Mask)
		ips.add(initIp);
		for (int i = 1; i < Math.pow(2, 32 - mask); i++) {

			// Extract each octet
			int firstOctet = Integer.parseInt(ipArray[3]);
			int secondOctet = Integer.parseInt(ipArray[2]);
			int thirdOctet = Integer.parseInt(ipArray[1]);
			int fourthOctet = Integer.parseInt(ipArray[0]);

			// Increase appropriate octet one for each new direction
			if (firstOctet < 255) {
				ipArray[3] = Integer.toString(firstOctet + 1);

			} else if (firstOctet == 255 && secondOctet != 255) {
				ipArray[3] = "0";
				ipArray[2] = Integer.toString(secondOctet + 1);

			} else if (firstOctet == 255 && secondOctet == 255 && thirdOctet != 255) {
				ipArray[3] = ipArray[2] = "0";
				ipArray[1] = Integer.toString(thirdOctet + 1);

			} else if (firstOctet == 255 && secondOctet == 255 && thirdOctet == 255 && fourthOctet != 255) {
				ipArray[3] = ipArray[2] = ipArray[1] = "0";
				ipArray[0] = Integer.toString(fourthOctet + 1);
			}

			// Generate ip address from ipArray and add it lo list of ips
			String ip = String.join(".", ipArray);
			ips.add(ip);

		}

		return ips;
	}

	@Test
	public void test() {
//		for (String cidrAddresses : new String[] { 
//				"10.10.10.0/32", // expected output: [10.10.10.0]
//				"10.10.10.0/31", // expected output: [10.10.10.0, 10.10.10.1]
//				"10.10.10.0/24", // expected output: [10.10.10.0, ..., 10.10.10.255]
//				"10.10.10.0/23", // expected output: [10.10.10.0, ..., 10.10.11.255]
//				"10.10.0.0/16", // expected output: [10.10.0.0, ..., 10.10.255.255]
//				"10.10.0.0/15", // expected output: [10.10.10.0, ..., 10.11.255.255]
//				"10.0.0.0/7", // expected output: [10.10.10.0, ..., 10.11.255.255]
//		}) {
//			//System.out.println(buildIps(cidrAddresses));
//			buildIps(cidrAddresses);
//		}

		List<String> ips;

		ips = buildIps("10.10.10.0/32");
		assertTrue(ips.equals(Arrays.asList(new String[] { "10.10.10.0" })));

		ips = buildIps("10.10.10.0/31");
		assertTrue(ips.equals(Arrays.asList(new String[] { "10.10.10.0", "10.10.10.1" })));

		ips = buildIps("10.10.10.0/24");
		assertTrue(ips.size() == 256 && ips.get(ips.size() - 1).equals("10.10.10.255"));

		ips = buildIps("10.10.10.0/23");
		assertTrue(ips.size() == 512 && ips.get(ips.size() - 1).equals("10.10.11.255"));

		ips = buildIps("10.10.0.0/16");
		assertTrue(ips.size() == 65536 && ips.get(ips.size() - 1).equals("10.10.255.255"));

		ips = buildIps("10.10.0.0/15");
		assertTrue(ips.size() == 131072 && ips.get(ips.size() - 1).equals("10.11.255.255"));

//		ips = buildIps("10.0.0.0/7");
//		assertTrue(ips.size() == 33554432 && ips.get(ips.size() - 1).equals("11.255.255.255"));

	}

}
