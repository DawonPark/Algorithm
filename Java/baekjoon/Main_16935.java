package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 	 백준 배열 돌리기 3(https://www.acmicpc.net/problem/16935)
 *  
 *  -> 3,4번째 연산에서 회전하는 것에서 행과 열이 바뀌는게 있음
 *  이외 것은 반으로 쪼개서 생각하면 편해서 반복문으로 생각함
 *  
 */
public class Main_16935 {
	static int N; // 배열의 크기(행)
	static int M; // 배열의 크기(열)
	static int R; // 연산의 횟수
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		StringTokenizer st = null;
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int num = Integer.parseInt(st.nextToken());
			switch (num) {
			case 1:
				rotation1();
				break;
			case 2:
				rotation2();
				break;
			case 3:
				rotation3();
				break;
			case 4:
				rotation4();
				break;
			case 5:
				rotation5();
				break;
			case 6:
				rotation6();
				break;
			}
		}
		print(arr);
	}

	private static void rotation6() {
		int[][] temp = new int[N][M];
		copy(temp);
		for (int i = 0; i < N / 2; i++) { // 1번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[i][j] = temp[i][M / 2 + j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 2번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[i][M / 2 + j] = temp[N / 2 + i][M / 2 + j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 3번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[N / 2 + i][M / 2 + j] = temp[N / 2 + i][j];
			}
		}

		for (int i = 0; i < N / 2; i++) { // 4번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[N / 2 + i][j] = temp[i][j];
			}
		}

//		print(arr);
	}

	private static void rotation5() {
		int[][] temp = new int[N][M];
		copy(temp);
		for (int i = 0; i < N / 2; i++) { // 1번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[i][j] = temp[N / 2 + i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) { // 2번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[i][M / 2 + j] = temp[i][j];
			}
		}
		for (int i = 0; i < N / 2; i++) { // 3번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[N / 2 + i][M / 2 + j] = temp[i][M / 2 + j];
			}
		}
		for (int i = 0; i < N / 2; i++) { // 4번 그룹
			for (int j = 0; j < M / 2; j++) {
				arr[N / 2 + i][j] = temp[N / 2 + i][M / 2 + j];
			}
		}

//		print(arr);

	}

	private static void rotation4() {
		int[][] result = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = arr[j][M - i - 1];
			}
		}
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = result[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
	}

	private static void rotation3() {
		int[][] result = new int[M][N];

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] = arr[N - j - 1][i];
			}
		}
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = result[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
	}

	private static void copy(int[][] temp) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = arr[i][j];
			}
		}

	}

	private static void rotation2() {
		int left = 0;
		int right = M - 1;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < M / 2; y++) {
				int temp = arr[x][left];
				arr[x][left] = arr[x][right];
				arr[x][right] = temp;
				left++;
				right--;
			}
			left = 0;
			right = M - 1;
		}
//		print(arr);
	}

	private static void rotation1() {
		int bottom = 0;
		int top = arr.length - 1;
		for (int y = 0; y < M; y++) {
			for (int x = 0; x < N / 2; x++) {
				int temp = arr[bottom][y];
				arr[bottom][y] = arr[top][y];
				arr[top][y] = temp;
				bottom++;
				top--;
			}
			bottom = 0;
			top = arr.length - 1;
		}
//		print(arr);
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
