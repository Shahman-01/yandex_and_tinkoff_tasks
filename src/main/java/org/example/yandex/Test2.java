package org.example.yandex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	static class Order {
		int start;
		int end;
		int cost;

		Order(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		String str = "";

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int cost = scanner.nextInt();

			orders.add(new Order(start, end, cost));
		}

		int q = scanner.nextInt();

		for (int i = 0; i < q; i++) {
			int start = scanner.nextInt();
			int end = scanner.nextInt();
			int type = scanner.nextInt();

			if (type == 1) {
				int totalCost = 0;
				for (Order order : orders) {
					if (order.start >= start && order.start <= end) {
						totalCost += order.cost;
					}
				}
				str += totalCost + " ";
//				System.out.print(totalCost + " ");
			} else {
				int totalDuration = 0;
				for (Order order : orders) {
					if (order.end >= start && order.end <= end) {
						totalDuration += (order.end - order.start);
					}
				}
				str += totalDuration + " ";
//				System.out.print(totalDuration + " ");
			}
		}

		System.out.println(str);
		scanner.close();
	}
}