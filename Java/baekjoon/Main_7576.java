package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	static class Tomato {
		int x, y, day;

		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<Tomato> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new Tomato(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		int max = 0;
		while (!q.isEmpty()) {
			Tomato t = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = t.x + dx[d];
				int ny = t.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] != 0)
					continue;
				if (!visited[nx][ny]) {
					map[nx][ny] = 1;
					max = t.day + 1;
					visited[nx][ny] = true;
					q.offer(new Tomato(nx, ny, t.day + 1));
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					max = -1;
					break;
				}
			}
		}
		System.out.println(max);
	}
}
