package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1194 {
	public static class Point {
		int x, y, cnt, key;

		public Point(int x, int y, int cnt, int key) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		char[][] map = new char[N][M];
		int startX = 0, startY = 0;
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '0') {
					startX = i;
					startY = j;
				}
			}
		}
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		// visited[][][64] 키를 가질 수 있는 경우의 수 2^키의 수
		boolean[][][] visited = new boolean[N][M][64]; // a키를 가지면 이진수로 000001 ab를 가지면 000011, b만 가지면 000010, ...
		Queue<Point> q = new LinkedList<>();
		visited[startX][startY][0] = true;
		map[startX][startY] = '.'; // 시작지점에 돌아오게 만들어야함
		q.add(new Point(startX, startY, 0, 0));
		int ans = -1;
		while (!q.isEmpty()) {
			Point data = q.poll();
			int key = data.key;
//			System.out.println(data.x + " " + data.y + " " + key);
			int cnt = data.cnt;
			for (int d = 0; d < 4; d++) {
				int nx = data.x + dx[d];
				int ny = data.y + dy[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (map[nx][ny] == '1') {
					ans = cnt + 1;
					System.out.println(ans);
					return;
				}
				if (map[nx][ny] == '#')
					continue;

				if (map[nx][ny] == '.' && !visited[nx][ny][key]) {
					visited[nx][ny][key] = true;
					q.add(new Point(nx, ny, cnt + 1, key));
				}
				if ('a' <= map[nx][ny] && map[nx][ny] <= 'f' && !visited[nx][ny][key]) {
					visited[nx][ny][key] = true;
//					System.out.println(key|(1<<(map[nx][ny]-'a')));
					q.add(new Point(nx, ny, cnt + 1, key | (1 << (map[nx][ny] - 'a'))));
				}
				if ('A' <= map[nx][ny] && map[nx][ny] <= 'F' && !visited[nx][ny][key]) {
					visited[nx][ny][key] = true;
//					System.out.println("key" + key);
//					System.out.println("bit" + (1<<(map[nx][ny]-'A')));
//					System.out.println((key &(1<<(map[nx][ny]-'A'))));
					if ((key & (1 << (map[nx][ny] - 'A'))) != 0) {// 열쇠를 가지고 있으면
						q.add(new Point(nx, ny, cnt + 1, key));
					}
				}

			}
		}
		System.out.println(ans);

	}
}
