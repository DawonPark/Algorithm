package javaalgo.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 백준 4963 섬의 개수
 * 
 * -> 1인곳을 찾아 연결된 부분을 다 0으로 해주고 나오는 재귀함수 구현 1 하나만 있어도 섬이기때문에 들어갈때 count를 올려줌
 */

public class Main_4963 {
	static int w, h;
	static int[][] map;
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String data[] = br.readLine().split(" ");
			w = Integer.parseInt(data[0]);
			h = Integer.parseInt(data[1]);
			if (w == 0 && h == 0)
				break;
			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				data = br.readLine().split(" ");
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(data[j]);
				}
			}
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						ans++;
						dfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	static void dfs(int x, int y) {
		map[x][y] = 0;

		for (int d = 0; d < 8; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= h || ny >= w)
				continue;

			if (map[nx][ny] == 1) {
				dfs(nx, ny);
			}

		}

	}

}
