package org.example.tinkoff;

import java.math.BigInteger;
import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] arr= scanner.nextLine().split("\\s+");
		BigInteger from = new BigInteger(arr[0]);
		BigInteger to = new BigInteger(arr[1]);

		System.out.println(getRes(from, to));

	}

	public static int getRes(BigInteger from, BigInteger to) {
		BigInteger N = BigInteger.ONE;
		int count = 0;

		while (N.compareTo(to) < 0) {
			for (int i = 1; i < 10; i++) {
				BigInteger k = N.multiply(BigInteger.valueOf(i));
				if (k.compareTo(from) >= 0 && k.compareTo(to) <= 0)
					count++;
			}
			N = N.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1));
		}
		return count;
	}
}
