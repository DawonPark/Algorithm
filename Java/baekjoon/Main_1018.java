package java. java.baekjoon;

import java.util.Scanner;

public class Main_1018 {
	static char[][] map;
	static int N, M, ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				check(i, j);
			}
		}
		System.out.println(ans);

	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };

	private static void check(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= M)
				continue;
			if (map[x][y] == 'B' && map[nx][ny] == 'B') {
				ans++;
				map[nx][ny] = 'W';
			}
			if (map[x][y] == 'W' && map[nx][ny] == 'W') {
				ans++;
				map[nx][ny] = 'B';
			}

		}
	}
}
