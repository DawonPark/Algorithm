package java. java.baekjoon;

import java.util.Scanner;

public class Main_12865 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] W = new int[N + 1];
		int[] P = new int[N + 1];
		int[][] D = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			W[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (W[i] > j) {
					D[i][j] = D[i - 1][j];
				} else {
					D[i][j] = Math.max(D[i - 1][j], D[i - 1][j - W[i]] + P[i]);
				}
			}
		}
		System.out.println(D[N][K]);
	}
}
