package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_2239 {
	static int[][] puzzle;
	static ArrayList<int[]> list;
	static boolean check = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		puzzle = new int[9][9];
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				puzzle[i][j] = s.charAt(j) - '0';
				if (puzzle[i][j] == 0)
					list.add(new int[] { i, j });
			}
		}
		solve(0);
	}

	private static void solve(int cnt) {
		if (check)
			return;
		if (list.size() == cnt) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(puzzle[i][j]);
				}
				System.out.println();
			}
			check = true;
			return;
		}
		int r = list.get(cnt)[0];
		int c = list.get(cnt)[1];
		boolean[] check = new boolean[10]; // 어떤 숫자가 가능한지 알기위해
		for (int i = 0; i < 9; i++) { // 가로
			if (puzzle[r][i] != 0)
				check[puzzle[r][i]] = true;
		}
		for (int i = 0; i < 9; i++) { // 세로
			if (puzzle[i][c] != 0)
				check[puzzle[i][c]] = true;
		}
		int nr = (r / 3) * 3;
		int nc = (c / 3) * 3;
		for (int i = nr; i < nr + 3; i++) { // 박스
			for (int j = nc; j < nc + 3; j++) {
				if (puzzle[i][j] != 0)
					check[puzzle[i][j]] = true;
			}
		}
		for (int i = 1; i < 10; i++) {
			if (!check[i]) {
				puzzle[r][c] = i;
				solve(cnt + 1);
				puzzle[r][c] = 0;
			}
		}
	}
}
