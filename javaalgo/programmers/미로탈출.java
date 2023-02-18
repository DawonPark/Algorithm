package javaalgo.programmers;

import java.util.*;

public class 미로탈출 {

	class Solution {
		public int solution(String[] maps) {
			int answer = 0;
			char[][] map = new char[maps.length][maps[0].length()];
			int fx = 0, fy = 0;
			int startX = 0, startY = 0;
			for (int i = 0; i < maps.length; i++) {
				char[] data = maps[i].toCharArray();
				for (int j = 0; j < maps[0].length(); j++) {
					map[i][j] = data[j];
					if (map[i][j] == 'L') {
						fx = i;
						fy = j;
					}
					if (map[i][j] == 'S') {
						startX = i;
						startY = j;
					}
				}
			}
			boolean[][] visited = new boolean[map.length][map[0].length];
			Queue<int[]> queue = new LinkedList<>();
			visited[startX][startY] = true;
			queue.offer(new int[] { startX, startY, 0 });
			boolean flag = false;
			int[] dx = { 0, 0, -1, 1 };
			int[] dy = { 1, -1, 0, 0 };
			int sum = 0;
			outer: while (!queue.isEmpty()) {
				int[] data = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nx = data[0] + dx[d];
					int ny = data[1] + dy[d];
					if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
						continue;
					if (map[nx][ny] == 'X')
						continue;
					if (visited[nx][ny])
						continue;
					if (map[nx][ny] == 'L') {
						sum = data[2] + 1;
						flag = true;
						break outer;
					}

					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, data[2] + 1 });
				}
			}
			if (!flag)
				return -1;
			visited = new boolean[maps.length][maps[0].length()];
			visited[fx][fy] = true;
			queue = new LinkedList<>();
			queue.offer(new int[] { fx, fy, 0 });
			int sum2 = 0;
			flag = false;
			outer: while (!queue.isEmpty()) {
				int[] data = queue.poll();
				for (int d = 0; d < 4; d++) {
					int nx = data[0] + dx[d];
					int ny = data[1] + dy[d];
					if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length)
						continue;
					if (map[nx][ny] == 'X')
						continue;
					if (visited[nx][ny])
						continue;
					if (map[nx][ny] == 'E') {
						sum2 = data[2] + 1;
						flag = true;
						break outer;
					}

					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny, data[2] + 1 });
				}
			}
			if (!flag)
				return -1;
			return sum + sum2;
		}
	}
}
