package org.example.tinkoff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] operands = scanner.nextLine().split("\\s+");
		List<String> strList = new ArrayList<>();
		List<Integer> numsList = new ArrayList<>();
		int before = 0;

		int n = Integer.parseInt(operands[0]);
		int k = Integer.parseInt(operands[1]);
		int res = 0;

		String[] arr = scanner.nextLine().split("\\s+");
		Collections.addAll(strList, arr);
		for (String s : strList)
			numsList.add(Integer.parseInt(s));

		before = getRes(numsList);

		for (int i = 0; i < k; i++) {
			changeElem(numsList, res);
		}
		System.out.println(getRes(numsList) - before);
	}

	private static List<Integer> changeElem(List<Integer> list, int res) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int index = 0;

		for (Integer i : list) {
			if ((i + "").length() > max && ((i + "").charAt(0) != '9')) {
				max = (i + "").length();
			}
		}

		for (Integer i : list) {
			if ((i + "").length() == max) {
				if (i < min) {
					min = i;
					index = list.indexOf(i);
				}
			}
		}

		if (min == Integer.MAX_VALUE)
			return list;
		min = Integer.parseInt(("9" + (min + "").substring(1)));
		list.set(index, min);

		return list;
	}

	private static int getRes(List<Integer> list) {
		int res = 0;

		for (Integer num : list) {
			res += num;
		}
		return res;
	}
}
