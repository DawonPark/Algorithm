package baekjoon;

import java.util.Scanner;
/*
 * 백준 10163 - 색종이
 * 
 * -> 겹치는 부분을 번호로 줘서 계속 값을 넣어줘서 해결
 */
public class Main_10163 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[1001][1001];
		int[] ans = new int[N+1];
		for(int i=1; i<=N; i++) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			for(int r=0; r<height; r++) {
				for(int c=0; c<width; c++) {
					arr[r+x][c+y] = i;
				}
			}
			
			
		}
		
		for(int r=0; r<1001; r++) {
			for(int c=0; c<1001; c++) {
				ans[arr[r][c]]++;
			}
		}
		for(int j=1; j<=N; j++) {
			System.out.println(ans[j]);
		}
	sc.close();
	}
	
}
