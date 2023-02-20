package org.example.yandex;

import java.util.*;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// Считываем рецепты
		List<Integer>[] recipes = new List[n];
		for (int i = 0; i < n - 2; i++) {
			int k = sc.nextInt();
			List<Integer> ingredients = new ArrayList<>();
			for (int j = 0; j < k; j++) {
				ingredients.add(sc.nextInt() - 1);
			}
			recipes[i + 2] = ingredients;
		}

		int q = sc.nextInt();

		// Обрабатываем запросы
		for (int i = 0; i < q; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt() - 1;

			// Используем топологическую сортировку
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[n];
			int[] inDegree = new int[n];

			// Вычисляем входящие степени вершин
			for (int j = 0; j < n; j++) {
				if (recipes[j] != null) {
					for (int ingredient : recipes[j]) {
						inDegree[j]++;
					}
				}
			}

			// Добавляем начальные вершины
			if (x > 0) {
				queue.offer(0);
			}
			if (y > 0) {
				queue.offer(1);
			}

			// Запускаем топологическую сортировку
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				visited[curr] = true;

				if (curr == s) {
					System.out.print("1");
					break;
				}

				if (recipes[curr] != null) {
					for (int next : recipes[curr]) {
						if (!visited[next]) {
							inDegree[next]--;
							if (inDegree[next] == 0) {
								queue.offer(next);
							}
						}
					}
				}
			}

			if (!visited[s]) {
				System.out.print("0");
			}
		}
	}
}