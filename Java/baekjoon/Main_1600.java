package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 *  백준 1600 - 말이 되고픈 원숭이
 *  - 말처럼 행동하는 것이 언제일지 모름 전체 탐색 
 *  - bfs로 클래스 안에 visited 를 따로 넣고 품 -> 메모리 초과 , 
 *  - 방문배열 겸 깊이를 나타내기위해서 int[][][] 배열 선언 -> 메모리 초과,
 *  - boolean 값으로 바꿈
 */
public class Main_1600 {
	static int[][] map;
	static int ans, W, H , K;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int[] hdx = {-1,-2,-2,-1,1,2,2,1};
	static int[] hdy = {-2,-1,1,2,-2,-1,1,2};
	
	static class Info{
		int x,y,k,cnt;
		public Info(int x, int y, int k, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    K = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = -1;
		Queue<Info> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[H][W][K+1];
		visited[0][0][0] = true;
		queue.offer(new Info(0,0,K,0));
		while(!queue.isEmpty()) {
				Info info = queue.poll();
				if(info.x == H-1 && info.y== W-1) {
				   ans = info.cnt;
				   break;
				}
				for(int d = 0; d<4; d++) {
					int nx = info.x + dx[d];
					int ny = info.y + dy[d];
					int k = info.k;
					if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
					if(map[nx][ny] == 1) continue;
					if(!visited[nx][ny][k]) {
						visited[nx][ny][k]= true;
						queue.add(new Info(nx,ny,info.k,info.cnt+1));
					}
				}
				if(info.k>0) {
					for(int d = 0; d<8; d++) {
						int nx = info.x + hdx[d];
						int ny = info.y + hdy[d];
						int k = info.k;
						if(nx<0 || nx>=H || ny<0 || ny>=W) continue;
						if(map[nx][ny] == 1) continue;
						if(!visited[nx][ny][k-1]) {
							visited[nx][ny][k-1]= true;
							queue.add(new Info(nx,ny,info.k-1,info.cnt+1));
						}
					}
				}
		}
		System.out.println(ans);
		
	}

}
