package javaalgo.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7569 {
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static int[][][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		Queue<int[]> queue = new LinkedList<>();
		map = new int[N][M][H];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j][k] = sc.nextInt();
					if (map[i][j][k] == 1)
						queue.offer(new int[] { i, j, k });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] data = queue.poll();

			for (int d = 0; d < 6; d++) {
				int nx = data[0] + dx[d];
				int ny = data[1] + dy[d];
				int nh = data[2] + dh[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nh < 0 || nh >= H)
					continue;
				if (map[nx][ny][nh] != 0)
					continue;
				queue.add(new int[] { nx, ny, nh });
				map[nx][ny][nh] = map[data[0]][data[1]][data[2]] + 1;
			}
		}
		int ans = Integer.MIN_VALUE;

//		for(int k=0; k<H; k++) {
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(map[i][j][k]);
//				}
//				System.out.println();
//			}			
//		}

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					ans = Math.max(ans, map[i][j][k]);
				}
			}
		}
		System.out.println(ans == 1 ? 0 : ans - 1);

	}
}
