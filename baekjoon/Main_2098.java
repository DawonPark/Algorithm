package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2098 {
	static int N;
	static int[][]dp,map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][(1<<N) - 1];
		for(int i=0; i<N; i++) {
			String[] data =br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(data[j]);
			}
		}
		for(int i =0; i<N; i++) {
			Arrays.fill(dp[i], 11000000);
		};
		System.out.println(solve(0,1));
	}
	public static int solve(int city , int bit) {
		if(bit == (1<<N)-1) {
			if(map[city][0]== 0) return 11000000;
			return map[city][0];
		}
		if(dp[city][bit] != 11000000) return dp[city][bit];
		
		for(int i=0; i < N; i++) {
			if((bit&(1 <<i ))==0 && map[city][i] !=0) {
				dp[city][bit]= Math.min(dp[city][bit],solve(i,bit | (1<<i) ) + map[city][i]);
			}
		}
		
		return dp[city][bit];
		
	}
	
}
