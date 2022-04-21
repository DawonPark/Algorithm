package baekjoon;

import java.util.Scanner;

public class Main_14890 {
	static int ans,N,L;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		ans = 0;
		for(int i=0; i<N; i++) {
			goCol(0,i);
			goRow(i,0);
		}
		
		
	}
	private static void goCol(int x, int y) {
		
		
		
		ans++;
	}
	private static void goRow(int x, int y) {
		int current = map[x][y];
		boolean check = false;
		for(int i=1; i<N; i++) {
			if(current > map[x][i]) {
				if(!check && i+L <N ) {
					for(int j=1; j<=L; j++) {
						if(map[x][i]!=map[x][i+j]) return;
					}
				}
			}
		}
		
		
		ans++;
	}
}
