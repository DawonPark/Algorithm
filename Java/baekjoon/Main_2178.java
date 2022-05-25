package java. java.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
	static class Node {
		int x;
		int y;
		int time;

		public Node(int x, int y, int time) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		int[][] map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			String s = sc.nextLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j - 1) - '0';
			}
		}
		Queue<Node> queue = new LinkedList<>();
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		queue.offer(new Node(1, 1, 1));
		map[1][1] = 0;
		int ans = 0;
		while (!queue.isEmpty()) {
			Node data = queue.poll();
			if (data.x == N && data.y == M) {
				ans = data.time;
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = data.x + dx[d];
				int ny = data.y + dy[d];
				if (nx <= 0 || nx > N || ny <= 0 || ny > M)
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = 0;
					queue.add(new Node(nx, ny, data.time + 1));
				}
			}
		}
		System.out.println(ans);
		sc.close();

	}
}
