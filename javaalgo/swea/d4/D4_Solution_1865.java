package javaalgo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_Solution_1865 {
	
	static double[][] works;
	static boolean[] visited;
	static int N;
	static double ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			visited= new boolean[N];
			works = new double[N][N];
			ans = 0.0;
			for(int i=0; i<N; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j =0; j<N; j++) {
					works[i][j] = Integer.parseInt(st.nextToken())*0.01;
				}
			}
			
			dfs(0,1.0);
			System.out.printf("#%d %.6f", t ,ans);
			System.out.println();
		}
	}
	
	static void dfs(int people, double sum) {
		if(sum*100 <= ans) return; // 다 계산하기도 전에 ans가 더 크다면 더 탐색할 필요가 없음.
		
		if(people == N) {
			if(sum*100 > ans) {
				ans = sum*100;
				return;
			}
		}
		
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(people+1, sum*works[people][i]);
				visited[i]=false;
			}
		}
		
	}
	
	
}
