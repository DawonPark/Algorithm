package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		int[][] temp = new int[R][C];
		int[] cleaner = new int[2]; // 1 행에만 있으므로 1차원으로 가능
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = map[i][j];
				if (map[i][j] == -1)
					cleaner[idx++] = i;
			}
		}
		int[] dx = { -1, 0, 1, 0, 1, 0, -1, 0 };
		int[] dy = { 0, 1, 0, -1, 0, 1, 0, -1 };
		for (int t = 0; t < T; t++) {
			Queue<int[]> q = new LinkedList<>();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] > 0) {
						q.add(new int[] { i, j });
					}
				}
			}

			while (!q.isEmpty()) {
				int[] data = q.poll();
				int cnt = 0;
				ArrayList<int[]> list = new ArrayList<>();
				for (int d = 0; d < 4; d++) {
					int nx = data[0] + dx[d];
					int ny = data[1] + dy[d];
					if (nx < 0 || nx >= R || ny < 0 || ny >= C)
						continue;
					if (map[nx][ny] == -1)
						continue;
					cnt++;
					map[nx][ny] += temp[data[0]][data[1]] / 5;
				}
				map[data[0]][data[1]] -= (temp[data[0]][data[1]] / 5) * cnt;
			}

			for (int i = 0; i < 2; i++) {
				if (i == 0) {
					int x = cleaner[i] + dx[0];
					int y = 0;
					for (int d = 0; d < 4; d++) {
						while (true) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx < 0 || nx > cleaner[i] || ny < 0 || ny >= C)
								break;
							if (map[nx][ny] == -1) {
								map[x][y] = 0;
								break;
							}
							map[x][y] = map[nx][ny];
							x = nx;
							y = ny;
						}
					}
				} else {
					int x = cleaner[i] + dx[4];
					int y = 0;
					for (int d = 4; d < 8; d++) {
						while (true) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx < 0 || nx < cleaner[i] || nx >= R || ny < 0 || ny >= C)
								break;
							if (map[nx][ny] == -1) {
								map[x][y] = 0;
								break;
							}
							map[x][y] = map[nx][ny];
							x = nx;
							y = ny;
						}
					}
				}
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					temp[i][j] = map[i][j];
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					ans += map[i][j];
			}
		}

		System.out.println(ans);

	}
}
