package java. java.baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17471 {
	static int N, ans;
	static int[] p, color;
	static int[][] dist;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		p = new int[N + 1];
		color = new int[N + 1];
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			int a = sc.nextInt();
			for (int k = 1; k <= a; k++) {
				dist[i][sc.nextInt()] = 1;
			}
		}
		ans = Integer.MAX_VALUE;
		solve(1);
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
		sc.close();
	}

	private static void solve(int cnt) {
		if (cnt == N + 1) {
			int check = 0;
			int check2 = 0;
			for (int i = 1; i <= N; i++) {
				if (color[i] == 1)
					check++;
				else if (color[i] == -1)
					check2++;
			}
			if (check == 0 || check2 == 0)
				return;
			go();
			return;
		}
		color[cnt] = -1;
		solve(cnt + 1);
		color[cnt] = 1;
		solve(cnt + 1);
	}

	private static void go() {
		int start = 0;
		int start2 = 0;
		for (int i = 1; i <= N; i++) {
			if (start == 0 && color[i] == 1)
				start = i;
			if (start2 == 0 && color[i] == -1)
				start2 = i;
			if (start != 0 && start2 != 0)
				break;
		}
		if (!check(start, start2))
			return;
		int sum = 0;
		int sum2 = 0;
		for (int i = 1; i <= N; i++) {
			if (color[i] == 1)
				sum += p[i];
			else
				sum2 += p[i];
		}
		ans = Math.min(Math.abs(sum - sum2), ans);
	}

	private static boolean check(int start, int start2) {
		boolean[] visited = new boolean[N + 1];
		cal(start, visited);
		cal(start2, visited);
		for (int i = 1; i <= N; i++) {
			if (!visited[i])
				return false;
		}
		return true;
	}

	private static void cal(int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);
		while (!queue.isEmpty()) {
			int n = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (dist[n][i] == 0)
					continue;
				if (color[n] != color[i])
					continue;
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
