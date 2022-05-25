package java. java.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 백준 1260번 - DFS와 BFS
 * 
 *  -> dfs , bfs 구현
 */

public class Main_1260 {
	static int N, M, V;
	static boolean[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		arr = new boolean[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			arr[from][to] = arr[to][from] = true;
		}
		boolean[] isVisited = new boolean[N + 1];
		dfs(V, isVisited);
		System.out.println();
		bfs(V);
		sc.close();
	}

	static void bfs(int start) {
		boolean[] isVisited = new boolean[N + 1];

		Queue<Integer> queue = new LinkedList<Integer>();

		isVisited[start] = true;
		queue.offer(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			for (int i = 1; i < N + 1; i++) {
				if (!isVisited[i] && arr[current][i]) {
					isVisited[i] = true;
					queue.offer(i);
				}
			}
		}

	}

	static void dfs(int start, boolean isVisited[]) {

		System.out.print(start + " ");
		isVisited[start] = true;

		for (int i = 1; i < N + 1; i++) {
			if (!isVisited[i] && arr[start][i]) {
				dfs(i, isVisited);
			}
		}

	}

}
