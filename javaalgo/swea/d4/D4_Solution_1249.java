package javaalgo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class D4_Solution_1249 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =1 ; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] distance = new int[N][N];
			for(int i=0; i<N; i++) {
				String data = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = data.charAt(j)-'0';
					distance[i][j] = Integer.MAX_VALUE;
				}
			}
			int[] dx = {0,0,-1,1};
			int[] dy = {-1,1,0,0};
			PriorityQueue<Point> q = new PriorityQueue<>();
			distance[0][0] = 0;
			q.add(new Point(0,0,0));
			while(!q.isEmpty()) {
				Point data = q.poll();
				int x = data.x;
				int y = data.y;
				int weight = data.weight;
				for(int d = 0; d<4; d++) {
					int nx = x+dx[d];
					int ny = y+dy[d];
					if(nx<0||nx>=N || ny<0||ny>=N) continue;
					if(distance[nx][ny] > map[nx][ny] + weight) {
						distance[nx][ny] = map[nx][ny] + weight;
						q.offer(new Point(nx,ny,map[nx][ny] + weight));
					}
				}
			}
			System.out.println("#" + t + " " + distance[N-1][N-1]);
		}
	}
	static class Point implements Comparable<Point> {
		int x, y, weight;
		public Point(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		@Override
		public int compareTo(Point o) {
			return this.weight-o.weight;
		}
	}
}
