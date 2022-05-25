package java. java.baekjoon;

import java.util.Scanner;

public class Main_14500 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		// 1번 째 도형
		int ans = 0;
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 3 >= M)
					continue outer;
				for (int k = 0; k < 4; k++) {
					sum += map[i][k + j];
				}
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (i + 3 >= N)
					continue outer;
				for (int k = 0; k < 4; k++) {
					sum += map[i + k][j];
				}
				ans = Math.max(ans, sum);
			}
		}
		// 두번째
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 1 >= M)
					continue outer;
				if (i + 1 >= N)
					break outer;
				for (int k = 0; k < 4; k++) {
					if (k < 2) {
						sum += map[i][j + k];
					} else {
						sum += map[i + 1][j + k % 2];
					}
				}
				ans = Math.max(ans, sum);
			}
		}
		// 3번째
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 1 >= M)
					continue outer;
				if (i + 2 >= N)
					break outer;
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
				ans = Math.max(ans, sum);
				sum = map[i + 2][j] + map[i + 2][j + 1] + map[i + 1][j + 1] + map[i][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 1 >= M)
					continue outer;
				if (i + 2 >= N)
					break outer;
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j] + map[i + 2][j];
				ans = Math.max(ans, sum);
				sum = map[i + 2][j] + map[i + 2][j + 1] + map[i + 1][j + 1] + map[i][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 2 >= M)
					continue outer;
				if (i + 1 >= N)
					break outer;
				sum = map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2] + map[i][j + 2];
				ans = Math.max(ans, sum);
				sum = map[i + 1][j] + map[i][j] + map[i][j + 1] + map[i][j + 2];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 2];
				ans = Math.max(ans, sum);
			}
		}

		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 1 >= M)
					continue outer;
				if (i + 2 >= N)
					break outer;
				sum = map[i][j] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j] + map[i + 2][j];
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 2 >= M)
					continue outer;
				if (i + 1 >= N)
					break outer;
				sum = map[i][j + 1] + map[i][j + 2] + map[i + 1][j] + map[i + 1][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 1][j + 2];
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 2 >= M)
					continue outer;
				if (i + 1 >= N)
					break outer;
				sum = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1] + map[i + 1][j + 2];
				ans = Math.max(ans, sum);
				sum = map[i][j] + map[i][j + 1] + map[i][j + 2] + map[i + 1][j + 1];
				ans = Math.max(ans, sum);
			}
		}
		outer: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int sum = 0;
				if (j + 1 >= M)
					continue outer;
				if (i + 2 >= N)
					break outer;
				sum = map[i][j] + map[i + 1][j] + map[i + 2][j] + map[i + 1][j + 1];
				ans = Math.max(ans, sum);
				sum = map[i + 1][j] + map[i][j + 1] + map[i + 1][j + 1] + map[i + 2][j + 1];
				ans = Math.max(ans, sum);
			}
		}

		System.out.println(ans);

	}
}
