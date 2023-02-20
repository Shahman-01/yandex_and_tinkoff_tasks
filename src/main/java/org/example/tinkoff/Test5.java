package org.example.tinkoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();

		int count = scanner.nextLine().charAt(0) - '0';
		String[] arr = scanner.nextLine().split("\\s+");

		for (String s : arr) {
			list.add(Integer.valueOf(s));
		}
		sort(list);
	}

	public static void sort(List<Integer> list) {
		int first = -1;
		int second = -1;

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (swap(list, i, j)) {
					first = i;
					second = j;
					System.out.println((first + 1) + " " + (second + 1));
					return ;
				}
			}
		}

		System.out.println("-1 -1");
	}

	public static boolean swap(List<Integer> list, int i, int j) {
		Collections.swap(list, i, j);
		if (!isSorted(list)) {
			Collections.swap(list, i, j);
			return false;
		}

		return true;
	}

	public static boolean isSorted(List<Integer> list) {

		for (int i = 0; i < list.size(); i++) {
			if ((i % 2 == 0) && (list.get(i) % 2 != 1))
				return false;
			if ((i % 2 == 1) && (list.get(i) % 2 != 0))
				return false;
		}

		return true;
	}
}
