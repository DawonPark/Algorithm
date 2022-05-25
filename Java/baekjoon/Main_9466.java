package java. java.baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_9466 {
	static int N, ans;
	static int[] map;
	static boolean[] isVisited;
	static boolean[] isFinished;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			ans = 0;
			map = new int[N + 1];
			isVisited = new boolean[N + 1];
			isFinished = new boolean[N + 1];
			for (int i = 1; i <= N; i++)
				map[i] = sc.nextInt();
			for (int i = 1; i <= N; i++) {
				solve(i);
			}
			System.out.println(N - ans);
		}
		sc.close();
	}

	private static void solve(int i) {
//		System.out.println(next);
		if (isVisited[i])
			return;

		isVisited[i] = true;
		int to = map[i];

		if (isVisited[to]) {
			if (!isFinished[to]) {
				ans++;
				while (i != to) {
					ans++;
					to = map[to];
				}
			}
		} else {
			solve(to);
		}

		isFinished[i] = true;

	}
}
