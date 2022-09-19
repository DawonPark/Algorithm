package javaalgo.baekjoon;

import java.util.Scanner;

public class Main_9663 {
	static int[] arr;
	static int N;
	static int ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		ans = 0;
		solve(0);
		System.out.println(ans);
		sc.close();
	}

	private static void solve(int row) {
		if (row == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[row] = i;
			if (go(row)) {
				solve(row + 1);
			}
		}
	}

	private static boolean go(int row) {
		for (int i = 0; i < row; i++) {
			if (arr[row] == arr[i])
				return false;
			if (Math.abs(row - i) == Math.abs(arr[row] - arr[i]))
				return false;
		}
		return true;
	}
}
