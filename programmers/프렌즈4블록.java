package programmers;

import java.util.*;

public class 프렌즈4블록 {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int[] dx = { 0, 1, 1 };
		int[] dy = { 1, 0, 1 };
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}

		while (true) {
			boolean check = false;
			boolean[][] visited = new boolean[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					char ch = map[i][j];
					boolean flag = true;
					if (ch == '0')
						continue;
					for (int d = 0; d < 3; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
							flag = false;
							break;
						}
						if (map[nx][ny] != ch) {
							flag = false;
							break;
						}
					}
					if (flag) {
						visited[i][j] = true;
						check = true;
						for (int d = 0; d < 3; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							visited[nx][ny] = true;
						}
					}
				}
			}
			if (!check)
				break;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j]) {
						answer++;
						map[i][j] = '0';
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = m - 1; j >= 0; j--) {
					if (map[j][i] == '0') {
						int idx = j - 1;
						while (idx >= 0) {
							if (map[idx][i] != '0') {
								map[j][i] = map[idx][i];
								map[idx][i] = '0';
								break;
							}
							idx--;
						}
					}
				}
			}
		}

		return answer;
	}
}