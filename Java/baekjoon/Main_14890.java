package java. java.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_14890 {
	static int ans, N, L;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			goCol(0, i);
			goRow(i, 0);
		}
		System.out.println(ans);

	}

	private static void goCol(int x, int y) {
		boolean[] flags = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			int diff = map[i][y] - map[i + 1][y];
			if (Math.abs(diff) > 1)
				return;
			if (diff == 0)
				continue;
			if (diff == 1) {
				for (int j = 1; j <= L; j++) {
					if (i + j >= N || flags[i + j])
						return;
					if (map[i][y] - 1 != map[i + j][y])
						return;
					flags[i + j] = true;
				}
			} else if (diff == -1) {
				for (int j = 0; j < L; j++) {
					if (i - j < 0 || flags[i - j])
						return;
					if (map[i][y] != map[i - j][y])
						return;
					flags[i - j] = true;
				}
			}
		}

//		System.out.println("col: " + y);
		ans++;
	}

	private static void goRow(int x, int y) {
		boolean[] flags = new boolean[N];
		for (int i = 0; i < N - 1; i++) {
			int diff = map[x][i] - map[x][i + 1];
			if (Math.abs(diff) > 1)
				return;
			if (diff == 0)
				continue;
			if (diff == 1) {
				for (int j = 1; j <= L; j++) {
					if (i + j >= N || flags[i + j])
						return;
					if (map[x][i] - 1 != map[x][i + j])
						return;
					flags[i + j] = true;
				}
			} else if (diff == -1) {
				for (int j = 0; j < L; j++) {
					if (i - j < 0 || flags[i - j])
						return;
					if (map[x][i] != map[x][i - j])
						return;
					flags[i - j] = true;
				}
			}
		}

//		System.out.println("row: " + x);
		ans++;
	}
}
