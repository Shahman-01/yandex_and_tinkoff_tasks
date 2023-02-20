package org.example.tinkoff;

import java.util.*;

public class Test6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int quan = scanner.nextInt();
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < quan; i++) {
			list.add(scanner.nextInt());
		}
		f(list);
	}

	public static void f(List<Integer> list) {
		boolean flag = false;
		int needNum = getNeedNum(list);
		if (needNum == -1) {
			System.out.println("-1 -1");
			return;
		}


		for (int i = 0; i < list.size(); i++) {
			if (i + 1 == list.get(i)) {
				if (flag) {
					System.out.println("-1 -1");
					return;
				}
				list.set(i, getNeedNum(list));
				System.out.println((i + 1) + " " + needNum);
				flag = true;
			}
		}
	}

	public static int getNeedNum(List<Integer> list) {
		int res = -1;

		for (int i = 1; i < list.size(); i++) {
			if (!list.contains(i))
				res = i;
		}

		return res;
	}
}
