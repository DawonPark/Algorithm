package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1937 {
	static int[][] map, dp;
	static int N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] data = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, solve(i, j));
			}
		}
		System.out.println(ans);
	}

	static int solve(int i, int j) {
		if (dp[i][j] != 0)
			return dp[i][j];

		dp[i][j] = 1;
		for (int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (map[nx][ny] > map[i][j]) {
				dp[i][j] = Math.max(dp[i][j], solve(nx, ny) + 1);
				solve(nx, ny);
			}
		}
		return dp[i][j];

	}
}
