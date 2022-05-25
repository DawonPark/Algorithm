package java. java.baekjoon;

import java.util.Scanner;

public class Main_2580 {
	static int[][] map = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		solve(0, 0);
	}

	private static void solve(int r, int c) {
		if (r == 9) {
			solve(0, c + 1);
			return;
		}

		if (c == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}

		if (map[r][c] == 0) {
			for (int i = 1; i < 10; i++) {
				if (go(r, c, i)) {
					map[r][c] = i;
					solve(r + 1, c);
				}
			}
			map[r][c] = 0; // 백트래킹 원복
			return;
		}

		solve(r + 1, c);

	}

	private static boolean go(int r, int c, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num) {
				return false;
			}
		}

		for (int i = 0; i < 9; i++) {
			if (map[i][c] == num) {
				return false;
			}
		}

		int row = (r / 3) * 3;
		int col = (c / 3) * 3;

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				if (map[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}

}
