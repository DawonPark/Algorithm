package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4485 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt =1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) return;
			int[][] map = new int[N][N];
			int[][] cost = new int[N][N];
			StringTokenizer st = null;
			for(int i =0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = Integer.MAX_VALUE;
				}
			}
			Queue<int[]> q = new LinkedList<int[]>();
			q.add(new int[] {0,0});
			cost[0][0] = map[0][0];
			int dx[] = {-1,1,0,0};
			int dy[] = {0,0,-1,1};
			while(!q.isEmpty()) {
				int[] data = q.poll();
				for(int d = 0; d<4; d++) {
					int nx = data[0]+dx[d];
					int ny = data[1]+dy[d];
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					if(map[nx][ny] + cost[data[0]][data[1]] < cost[nx][ny]) {
						cost[nx][ny] = map[nx][ny] + cost[data[0]][data[1]];
						q.add(new int[] {nx,ny});
					}
				}
			}
			
			System.out.println("Problem "+cnt++ + ": " + cost[N-1][N-1]);
		}
		
	}
}
