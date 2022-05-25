package java. java.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1916 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] matrix = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int w = sc.nextInt();
			if (matrix[start][end] == 0 || matrix[start][end] > w)
				matrix[start][end] = w;
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		boolean[] visited = new boolean[N + 1];
		int[] D = new int[N + 1];
		for (int i = 1; i <= N; i++)
			D[i] = Integer.MAX_VALUE;
		D[start] = 0;
		visited[start] = true;
		for (int i = 1; i <= N; i++) {
			D[i] = matrix[start][i];
		}
		for (int i = 0; i < N - 1; i++) {
			int min = Integer.MAX_VALUE;
			int current = 0;
			for (int j = 1; j <= N; j++) {
				if (D[j] < min && !visited[j]) {
					current = j;
					min = D[j];
				}
			}
			visited[current] = true;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && matrix[current][j] != 0) {
					if (D[current] + matrix[current][j] < D[j]) {
						D[j] = D[current] + matrix[current][j];
					}
				}
			}
		}
		System.out.println(D[end]);

	}
}
