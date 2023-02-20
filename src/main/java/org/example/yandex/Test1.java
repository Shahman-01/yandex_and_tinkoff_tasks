package org.example.yandex;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		String[] arr = scanner.nextLine().replaceAll("[^\\d]", " ").trim().split("\\s+");

		for (String s : arr)
			list.add(Integer.valueOf(s));

		list.sort(Comparator.comparing(Integer::valueOf));

		boolean flag = false;
		for (int i = 0; i < list.size(); i++) {
			if ((i + 1) < list.size() && (list.get(i + 1) == (list.get(i) + 1)) && !flag) {
				System.out.print(list.get(i) + "-");
				flag = true;
			}
			else if ((i + 1) < list.size() && (list.get(i + 1) != (list.get(i) + 1)) && flag) {
				System.out.println(list.get(i) + ",");
				flag = false;
			}
		}

		System.out.println(list);
	}
}
