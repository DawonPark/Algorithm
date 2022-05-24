package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_12100 {
	static int[][] map;
	static int[][] temp;
	static int N,max;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		sel = new int[5];
		max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		solve(0);
		System.out.println(max);
		sc.close();
	}
	private static void solve(int cnt) {
		if(cnt ==5) {
			temp = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp[i][j]  = map[i][j];
				}
			}
			go(0);
			for(int i=0; i<N; i++) {
				for(int j =0; j<N; j++) {
					max = Math.max(temp[i][j], max);
				}
			}
			return;
		}
		for(int i=0; i<4; i++) {
			sel[cnt] = i;
			solve(cnt+1);
		}
		
	}
	private static void go(int cnt) {
		if(cnt == 5) {
			return;
		}
		
		int dir = sel[cnt];
		if(dir == 0 ) { // 위로
			for(int i=0; i<N; i++) {
				int idx = 0;
				int val = 0;
				for(int j=0; j<N; j++) {
					if(temp[j][i] != 0) {
						if(val == temp[j][i] ) { // 
							temp[idx-1][i] = val * 2;
							temp[j][i] = 0;
							val = 0;
						}else {
							val = temp[j][i];
							temp[j][i] = 0;
							temp[idx][i] = val;
							idx++;
						}
					}
					
				}
			}
		}else if(dir ==1) { // 아래
			for(int i=0; i<N; i++) {
				int idx = N-1;
				int val = 0;
				for(int j=N-1; j>=0; j--) {
					if(temp[j][i] != 0) {
						if(val == temp[j][i] ) { // 
							temp[idx+1][i] = val * 2;
							temp[j][i] = 0;
							val = 0;
						}else {
							val = temp[j][i];
							temp[j][i] = 0;
							temp[idx][i] = val;
							idx--;
						}
					}
				}
			}
		}else if(dir ==2) { // 왼쪽
			for(int i=0; i<N; i++) {
				int idx = 0;
				int val = 0;
				for(int j=0; j<N; j++) {
					if(temp[i][j] != 0) {
						if(val == temp[i][j] ) { // 
							temp[i][idx-1] = val * 2;
							temp[i][j] = 0;
							val = 0;
						}else {
							val = temp[i][j];
							temp[i][j] = 0;
							temp[i][idx] = val;
							idx++;
						}
					}
				}
			}
		}else if(dir ==3) { // 오른쪽
			for(int i=0; i<N; i++) {
				int idx = N-1;
				int val = 0;
				for(int j=N-1; j>=0; j--) {
					if(temp[i][j] != 0) {
						if(val == temp[i][j] ) { // 
							temp[i][idx+1] = val * 2;
							temp[i][j] = 0;
							val = 0;
						}else {
							val = temp[i][j];
							temp[i][j] = 0;
							temp[i][idx] = val;
							idx--;
						}
					}
				}
			}
		}
		go(cnt+1);
	}
}
