package java. swea.d3;

import java.util.Scanner;

/*
 * N X N 크기의 판이 있다. 판의 각 칸에는 돌이 있거나 없을 수 있다. 
 * 돌이 가로, 세로, 대각선 중 하나의 방향으로 다섯 개 이상 연속한 부분이 있는지 없는지 판정하는 프로그램을 작성하라.
 * 
 * -> 팔방탐색으로 접근함. 8번을 검색하는데 쉽게 생각하고 접근 했다가 제시된 테케는 맞았는데
 *    통과를 못해서 다시 보게됨 -> 조건을 초기화하는 부분을 잘못 넣었다가 시간이 조금 오래걸림
 */
public class D3_Solution_11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
		int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
	outer: for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(sc.nextLine());
			char[][] board = new char[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = s.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 'o') {
						for (int d = 0; d < 8; d++) {
							int x = i, y = j;
							int nx = 0, ny = 0;
							nx = x + dx[d];
							ny = y + dy[d]; // 1번 이동 
							if (nx < 0 || nx >= N || ny < 0 || ny >= N)
								continue;
							x=nx; y=ny;
							if (board[nx][ny] == 'o') {
								int count = 2;
								while (true) {
									nx = x + dx[d]; // 2번 이동
									ny = y + dy[d];
									if (nx < 0 || nx >= N || ny < 0 || ny >= N)
										break;
									if (board[nx][ny] == 'o') {
										x= nx;
										y= ny;
										System.out.println("d" +d + " nx : "+ nx + " ny : " + ny);
										count++;
									}else {
										break;
									}
									
									if (count >= 5) {
										System.out.println("#" + t + " YES");
										continue outer;
									}
									
								}
							} else
								continue;

						}

					}

				}
			}
			System.out.println("#" + t + " NO");
		}
		sc.close();
	}
}
