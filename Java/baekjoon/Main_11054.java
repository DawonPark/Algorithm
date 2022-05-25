package java. java.baekjoon;

import java.util.Scanner;

public class Main_11054 {
	static int[] r_dp, l_dp;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r_dp = new int[N];
		l_dp = new int[N];
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		int max = 0;
		for (int i = 0; i < N; i++) {
			left(i);
			right(i);
		}
		for (int i = 0; i < N; i++) {
			max = Math.max(r_dp[i] + l_dp[i] - 1, max);
		}
		System.out.println(max);
	}

	static int left(int N) {
		if (l_dp[N] == 0) {
			l_dp[N] = 1;

			for (int i = N + 1; i < arr.length; i++) {
				if (arr[i] < arr[N]) {
					l_dp[N] = Math.max(l_dp[N], left(i) + 1);
				}
			}
		}
		return l_dp[N];
	}

	static int right(int N) {
		if (r_dp[N] == 0) {
			r_dp[N] = 1;

			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N]) {
					r_dp[N] = Math.max(r_dp[N], left(i) + 1);
				}
			}
		}
		return r_dp[N];
	}
}
