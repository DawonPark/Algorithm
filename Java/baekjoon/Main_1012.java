package java. java.baekjoon;

import java.util.Scanner;

public class Main_1012 {
	static int[][] map;
	static int M, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N + 1][M + 1];
			int ans = 0;
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = 1;
			}

			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			for (int i = 0; i <= N; i++) {
				for (int j = 0; j <= M; j++) {
					if (map[i][j] == 1) {
						solve(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);

		}

	}

	static int dx[] = { 0, 0, -1, 1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void solve(int i, int j) {
		map[i][j] = 0;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || nx > N + 1 || ny < 0 || ny > M + 1)
				continue;
			if (map[nx][ny] == 1) {
				solve(nx, ny);
			}
		}

	}
}
