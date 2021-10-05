package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239 {
	static int[][] puzzle;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		for(int i = 0; i<9; i++) {
			String s = br.readLine();
			for(int j =0; j<9; j++) {
				puzzle[i][j] = s.charAt(j) -'0';
			}
		}
		
		
	}
}
