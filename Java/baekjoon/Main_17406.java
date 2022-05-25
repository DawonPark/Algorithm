package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 백준 배열 돌리기 4
 * 문제 내용이 너무 길어 생략(https://www.acmicpc.net/problem/17406)
 * 
 * 문제는 순열 + 배열 탐색으로 접근함.
 * 
 * -> 문제를 푸는데도 시간이 필요했지만 테스트케이스는 맞았는데 제출에서 틀려서 어디가 틀린지 찾는데 고생함
 * -> 틀린이유는 순열이 만들어졌을 때 돌렸어야했는데 중간에 돌려서 카운트가 안됬어도 돌아가서 틀린 것 같다. 
 */

public class Main_17406 {
	static int[][] arr, tempArr, rotation;
	static boolean isSelected[];
	static int[] answer;
	static int K, result, N, M;
	static int dx[] = { 1, 0, -1, 0 }; // 아래 오른쪽 위쪽 왼쪽
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] msg = br.readLine().split(" ");
		N = Integer.parseInt(msg[0]);
		M = Integer.parseInt(msg[1]);
		K = Integer.parseInt(msg[2]);
		result = Integer.MAX_VALUE;
		isSelected = new boolean[K];
		answer = new int[K];
		arr = new int[N][M];
		tempArr = new int[N][M];
		StringTokenizer st = null;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int c = 0; c < M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[r][c] = temp;
				tempArr[r][c] = temp;
			}
		}

		rotation = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotation[i][0] = Integer.parseInt(st.nextToken());
			rotation[i][1] = Integer.parseInt(st.nextToken());
			rotation[i][2] = Integer.parseInt(st.nextToken());
		}

		permutation(0);
		System.out.println(result);

	}

	private static void permutation(int count) {
		if (count == K) {
			result();
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i] == true)
				continue;
			isSelected[i] = true;
			answer[count] = i;
			permutation(count + 1);
			isSelected[i] = false;
		}

	}

	private static void result() {
		for (int i = 0; i < K; i++) {
			int r = rotation[answer[i]][0];
			int c = rotation[answer[i]][1];
			int s = rotation[answer[i]][2];
			rotation(r, c, s);
		}
		int temp = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp += arr[i][j];
			}
			result = Math.min(result, temp);
			temp = 0;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = tempArr[i][j];
			}
		}
	}

	private static void rotation(int r, int c, int s) {
		for (int i = 0; i < s; i++) { // 횟수는 짧은 변의 /2 하면 되는데 (r+s-1)-(r-s-1)/2 =s c도 마찬가지((c+s-1)-(c-s-1)/2 = s)
			int x = r - s - 1 + i;
			int y = c - s - 1 + i;
			int temp = arr[x][y];
			for (int d = 0; d < 4; d++) {
				while (true) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx > r + s - 1 - i || nx < r - s - 1 + i || ny < c - s - 1 + i || ny > c + s - 1 - i)
						break; // 나가는 경우
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				}
			}
			arr[r - s - 1 + i][c - s + i] = temp;
		}
	}
}
