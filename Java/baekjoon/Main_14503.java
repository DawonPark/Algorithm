package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
	static int R,C,x,y,D;
	static int [][] map;
	static boolean [][] visited;
	static int ans =0; 
	//북 동 남 서
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		D = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		clean(x,y,D);
		System.out.println(ans);
	}
	private static void clean(int x,int y,int dir) {
		boolean check = false;
		
		if(!visited[x][y]) {
			ans++;
			visited[x][y]=true;
		}
		
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[(dir+3)%4];
			int ny = y + dy[(dir+3)%4];
			
			if(map[nx][ny]==0 && !visited[nx][ny]) {
				clean(nx,ny,(dir+3)%4);
				check=true;
				break;
			}
			dir = (dir+3)%4;
		}
		
		if(check==false) {
			int nx = x+dx[(dir+2)%4];
			int ny = y+dy[(dir+2)%4];
			
			if(map[nx][ny]==0) {
				clean(nx,ny,dir);
			}
		}
	}

}