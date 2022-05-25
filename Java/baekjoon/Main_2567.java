package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 2567 - 색종이 2
 * 
 * 칠해진 부분을 true하고 true 사방탐색을 통해서 false 인 것이 둘레로 더해줌
 */
public class Main_2567 {

	public static void main(String[] args) {
		boolean[][] paper = new boolean[101][101];
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int k = 0; k < 10; k++) {
				for (int j = 0; j < 10; j++) {
					paper[x + k][y + j] = true;
				}
			}
		}
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 }; // 사방
		int ans = 0;
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (paper[i][j] == true) {
					for (int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx < 0 || nx > 100 || ny < 0 || ny > 100)
							continue;
						if (paper[nx][ny] == false)
							ans++;
					}
				}
			}
		}

		System.out.println(ans);

	}
}
