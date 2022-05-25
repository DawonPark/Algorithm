package java. java.baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] indegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			list.get(start).add(end);
			indegree[end]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				pq.offer(i);
			}
		}

		while (!pq.isEmpty()) {
			int node = pq.poll();
			System.out.print(node + " ");

			for (int v : list.get(node)) {
				indegree[v]--;

				if (indegree[v] == 0) {
					pq.add(v);
				}
			}
		}

		System.out.println();
	}
}
