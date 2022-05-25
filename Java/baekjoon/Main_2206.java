package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]);
		int M = Integer.parseInt(data[1]);
		int[][] map = new int[N + 1][M + 1];
		boolean[][][] isVisited = new boolean[N + 1][M + 1][2];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}
		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { -1, 1, 0, 0 };
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 1, 1, 0, 1 });
		isVisited[1][1][0] = true;
		isVisited[1][1][1] = true;
		int ans = -1;
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			System.out.println("X : " + pos[0] + " Y : " + pos[1]);
			if (pos[0] == N && pos[1] == M) {
				ans = pos[3];
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = pos[0] + dx[d];
				int ny = pos[1] + dy[d];
				int check = pos[2];
				if (nx <= 0 || nx > N || ny <= 0 || ny > M)
					continue;
				if (isVisited[nx][ny][check])
					continue;
				if (check == 1 && map[nx][ny] == 1)
					continue; // 못감

				if (map[nx][ny] == 1) {
					queue.add(new int[] { nx, ny, 1, pos[3] + 1 });
					isVisited[nx][ny][1] = true;
				} else {
					queue.add(new int[] { nx, ny, check, pos[3] + 1 });
					isVisited[nx][ny][check] = true;
				}
			}
		}

		System.out.println(ans);

	}

}
