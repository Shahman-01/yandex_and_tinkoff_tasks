package org.example.tinkoff;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test7 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		int size = scanner.nextInt();
		if (size < 0 || size > 100)
			return;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			int num = scanner.nextInt();
			if (num > 300)
				return;
			list.add(num);
		}

		int totalCost = 0;
		int coupons = 0;

		for (int i = 0; i < list.size(); i++) {
			totalCost += list.get(i);
			int max = list.subList(i, size).stream()
					.max(Comparator.comparingInt(Integer::valueOf)).orElse(0);
			if (coupons > 0 && list.get(i) == max)
				totalCost -= list.get(i);
			if (list.get(i) >= 100)
				coupons++;
		}

		System.out.println(totalCost);
	}
}
