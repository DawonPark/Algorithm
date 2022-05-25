package java. java.baekjoon;

import java.util.Scanner;

public class Main_11053 {
	static int N;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		for (int i = 0; i < N; i++)
			LIS(i);
		int max = 0;
		for (int i = 0; i < N; i++)
			max = Math.max(max, dp[i]);
		System.out.println(max);
	}

	private static int LIS(int N) {
		if (dp[N] == 0) {
			dp[N] = 1;
			for (int i = N - 1; i >= 0; i--) {
				if (arr[i] < arr[N])
					dp[N] = Math.max(dp[N], LIS(i) + 1);
			}
		}
		return dp[N];
	}

}
