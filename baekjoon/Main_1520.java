package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1520 {
	static int N,M,ans;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data= br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0; i<N;i++) {
			data= br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j]= Integer.parseInt(data[j]);
				visited[i][j] = -1;
			}
		}
		System.out.println(solve(0,0));
		System.out.println(Arrays.deepToString(visited));
	}
	private static int solve(int i, int j) {
		if(i==N-1 && j ==M-1) {
			return 1;
		}
		if(visited[i][j] != -1) return visited[i][j];
		visited[i][j] = 0;
		
		for(int d = 0; d<4; d++) {
			int nx = i+dx[d];
			int ny = j+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
			if(map[nx][ny] < map[i][j]) {
				visited[i][j] += solve(nx,ny);
			}
		}
		
		return visited[i][j];
		
	}
}
