package javaalgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636 {
	static int R, C;
	static int[][] map;
	static boolean[][] isVisited;
	static int time;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		isVisited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		int time = 0;
		int count = Integer.MAX_VALUE;
		int result = 0;
		int temp = 0;
		while (true) {
			count = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 2) {
						map[i][j] = 0;
						for (int d = 0; d < 4; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (nx < 0 || nx >= R || ny < 0 || ny >= C)
								continue;
							if (map[nx][ny] == 1) {
								map[nx][ny] = 0;
								temp++;
								continue;
							}
						}
					}
				}
			}
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 1) {
						count++;
					}
				}
			}
			if (count == 0)
				break;
			result = count;
			isVisited = new boolean[R][C];
			dfs(0, 0);
			time++;
		}
		if (time == 0)
			result = temp;
		System.out.println(time + 1);
		System.out.println(result);
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}

	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void dfs(int x, int y) {

		isVisited[x][y] = true;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= R || ny < 0 || ny >= C)
				continue;
			if (map[nx][ny] == 1) {
				map[x][y] = 2;
				continue;
			}
			if (!isVisited[nx][ny])
				dfs(nx, ny);
		}
	}

}
