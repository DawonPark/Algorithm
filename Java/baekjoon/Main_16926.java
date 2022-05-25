package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.
 * 
 * ->처음에 while로 돌리다보니 너무 복잡하게 작성이 되었음 , temp값을 신경쓰기 싫어서 두 개의 배열을 사용하였음
 */

public class Main_16926 {

	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int R = Integer.parseInt(s[2]);
		int tempN = N;
		int tempM = M;
		arr = new int[N][M];
		for (int x = 0; x < N; x++) {
			st = new StringTokenizer(br.readLine());
			for (int y = 0; y < M; y++) {
				arr[x][y] = Integer.parseInt(st.nextToken());
			}
		}
		int x = 0, y = 0;
		int result[][] = new int[N][M];
		int dir = 0; // 방향 아래 0 오른쪽 1; 위쪽 2 왼쪽 3
		int n = 0;
		int boundX = N;
		int boundY = M;
		for (int i = 0; i < R; i++) {
			while (Math.min(N, M) / 2 > 0) {
				if (dir == 0) {
					if (x != boundX - 1) {
						result[x + 1][y] = arr[x][y];
						x++;
					} else {
						result[x][y] = arr[x - 1][y];
						dir = 1;
					}
				}
				if (dir == 1) {
					if (y != boundY - 1) {
						result[x][y + 1] = arr[x][y];
						y++;
					} else {
						result[x][y] = arr[x][y - 1];
						dir = 2;
					}
				}
				if (dir == 2) {
					if (x != n) {
						result[x - 1][y] = arr[x][y];
						x--;
					} else {
						result[x][y] = arr[x + 1][y];
						dir = 3;
					}
				}
				if (dir == 3) {
					if (y != n) {
						result[x][y - 1] = arr[x][y];
						y--;
					} else {
						result[x][y] = arr[x][y + 1];
						dir = 0;
						N -= 2;
						M -= 2;
						boundX--;
						boundY--;
						x++;
						y++;
						n++;
					}
				}
			}
			for (int r = 0; r < tempN; r++) {
				for (int c = 0; c < tempM; c++) {
					arr[r][c] = result[r][c];
				}
			}
			x = 0;
			y = 0;
			N = tempN;
			M = tempM;
			boundX = tempN;
			boundY = tempM;
			n = 0;
		}
		for (int r = 0; r < tempN; r++) {
			for (int c = 0; c < tempM; c++) {
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		}

	}
}
