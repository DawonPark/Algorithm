package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2169 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = map[0][0];
		for (int i = 1; i < M; i++)
			dp[0][i] = dp[0][i - 1] + map[0][i];
		for (int i = 1; i < N; i++) {
			int dl[] = new int[M]; // 왼쪽 아래
			int dr[] = new int[M]; // 오른쪽 아래
			dl[0] = dp[i - 1][0] + map[i][0];
			for (int j = 1; j < M; j++) {
				dl[j] = map[i][j] + Math.max(dl[j - 1], dp[i - 1][j]);
			}

			dr[M - 1] = dp[i - 1][M - 1] + map[i][M - 1];
			for (int j = M - 2; j >= 0; j--)
				dr[j] = map[i][j] + Math.max(dr[j + 1], dp[i - 1][j]);
			for (int j = 0; j < M; j++)
				dp[i][j] = Math.max(dl[j], dr[j]);
		}
		System.out.println(dp[N - 1][M - 1]);

	}

}
