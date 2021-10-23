package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N+1][M+1];
		int[] dx = {0,1,0,-1}; // 0 북 1 동 2 남 3 서 
		int[] dy = {-1,0,1,0}; 
		int[] dx2 = {1,0,-1,0}; // 0 북 1 동 2 남 3 서 
		int[] dy2 = {0,-1,0,1}; 
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[][] check = new boolean[N+1][M+1];
		int ans = 1;
		check[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x,y});
outer:	while(!queue.isEmpty()) {
			int[] data= queue.poll();
//			System.out.println(data[0] + "," + data[1] + "," + D);
			for(int i= 0; i<4; i++) {
				int nx = data[0] + dx[D%4];
				int ny = data[1] + dy[D%4];
				if(nx <= 0 || nx >N || ny<=0 || ny>M) {
					D++;
					continue;
				}
				if(check[nx][ny] || map[nx][ny]== 1 ) {
					D++;
					continue;
				}
				check[nx][ny] = true;
				queue.offer(new int[] {nx,ny});
				ans++;
				continue outer;
			}
			int nx = data[0] +dx2[D%4];
			int ny = data[1] +dy2[D%4];
			if(map[nx][ny] == 0 ) queue.offer(new int[] {nx,ny});
		}
		int cnt =0;
		for(int i =1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(check[i][j]) {
					cnt++;
					System.out.print(1);
				}
				else System.out.print(0);
			}
			System.out.println();
		}
		System.out.println(cnt + " " + ans);
		
		
	}
}
