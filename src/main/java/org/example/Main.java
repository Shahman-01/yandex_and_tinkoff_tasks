package org.example;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int piece = scanner.nextInt();
		int count = 0;

		while (piece != 1) {
			if (piece % 2 == 1)
				piece +=1;
			piece /= 2;
			count++;
		}
		System.out.println(count);
	}
}