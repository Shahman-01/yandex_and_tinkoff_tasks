package org.example.tinkoff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int leaveEmp, n, t;

		String[] operands = scanner.nextLine().split("\\s+");
		n = Integer.parseInt(operands[0]);
		t = Integer.parseInt(operands[1]);

		if ((n < 1 || n > 100) || (t < 1 || t > 100))
			return;

		String[] floors = scanner.nextLine().split("\\s+");
		for (String s : floors)
			list.add(Integer.valueOf(s));

		leaveEmp = scanner.nextInt();
		System.out.println(f(list, leaveEmp, n, t));
	}

	private static int f(List<Integer> list, int leaveEmp, int n, int t) {
		int res = 0;

		if ((list.get(leaveEmp - 1) - list.get(0)) <= t) {
			res = list.get(list.size() - 1) - list.get(0);
		} else {
			res = (list.get(leaveEmp - 1) - list.get(0) + (list.get(list.size() - 1) - list.get(0)));
		}
		return res;
	}
}

