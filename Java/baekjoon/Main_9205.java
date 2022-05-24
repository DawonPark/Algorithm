package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
outer:	for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] con = new int[N+2][2];
			StringTokenizer st = null;
			for(int i = 0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}
			boolean[][] matrix  = new boolean[N+2][N+2];
			for(int i =0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(Math.abs(con[i][0] - con[j][0])+ Math.abs(con[i][1] - con[j][1]) <=1000) {
						matrix[i][j] = matrix[j][i] = true;
					}
				}
			}
			for(int k = 0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
						if(matrix[i][k] && matrix[k][j]) matrix[i][j]= true;
					}
				}
			}
			System.out.println(matrix[0][N+1] ? "happy" :  "sad");
			/* bfs 풀이
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			int[][] con = new int[N][2];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				con[i][0] = Integer.parseInt(st.nextToken());
				con[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int festivalX = Integer.parseInt(st.nextToken());
			int festivalY = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<>();
			boolean[] visited = new boolean[N];
			q.add(new int[] {homeX,homeY});
			while(!q.isEmpty()) {
				int[] data = q.poll();
				if(Math.abs(data[0] - festivalX)+ Math.abs(data[1] - festivalY) <=1000) {
					System.out.println("happy");
					continue outer;
				}
				for(int i=0; i<N; i++) {
					if(!visited[i] &&Math.abs(data[0] - con[i][0]) + Math.abs(data[1] - con[i][1])  <=1000) {
						visited[i] = true;
						q.add(new int[] {con[i][0],con[i][1]});
					}
				}
				
			}
			System.out.println("sad");
			*/
		}
	}
}
