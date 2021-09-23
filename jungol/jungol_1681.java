package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1681 {
	static int[][] cost;
	static boolean[] visited;
	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		cost = new int[N][N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken().trim());
			}
		}
		ans = Integer.MAX_VALUE;
		solve(0,0,0);
		System.out.println(ans);
	}
	
	public static void solve(int start,int cnt, int sum) {
		if(sum >=ans) return; // 가지치기
		if(cnt == N-1) { // 회사로 돌아갈 길이 있다면 더 해주면 됨
			if(cost[start][0]!=0) {
				ans = Math.min(sum+cost[start][0], ans);				
			}
			return;
		}
		
		for(int i=1; i<N; i++) {
			if(visited[i]) continue;
			if(cost[start][i]!=0) {
				visited[i] = true;
				solve(i,cnt+1,sum+cost[start][i]);
				visited[i] = false;
			}
		}
	}
	
}
