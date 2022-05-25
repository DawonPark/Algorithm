package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	백준 1987 알파벳	
 * 
 * -> 대문자 알파벳 방문 boolean 배열을 넣어서 사용 -> 한번 칸에 들어왔다면 true , true면 방문을 하지않고 뒤로 돌아감 -> false와 temp--로 다시 복구시킴
 * -> 처음 재귀함수에 count를 안주고 전역으로 temp를 사용하려했는데 
 */
public class Main_1987 {
	static boolean isVisited[] = new boolean[26]; // 대문자 개수
	static char[][] board;
	static int R, C, ans, temp;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		R = Integer.parseInt(data[0]);
		C = Integer.parseInt(data[1]);
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}
		isVisited[board[0][0] - 'A'] = true;
		ans = Integer.MIN_VALUE;
		temp = 1;
		solve(0, 0);
		System.out.println(ans);
	}

	private static void solve(int x, int y) {

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C)
				continue;
			int val = board[nx][ny] - 'A';
			if (isVisited[val] == true)
				continue;
//			System.out.println(Arrays.toString(isVisited));
//			System.out.println(board[nx][ny]);
			isVisited[val] = true; // 밟았으면 true
			temp++;
			solve(nx, ny);
			temp--;
			isVisited[val] = false; // 돌아왓으면 다시 false
		}

		// 경로 끝
		ans = Math.max(temp, ans);

	}

}
