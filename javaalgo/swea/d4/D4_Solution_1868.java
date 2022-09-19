package javaalgo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_Solution_1868 {
	static char[][] map;
	static int N;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			N= Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			for(int i=0; i<N; i++) {
				String s = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			int ans =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == '.') {
						if(go(i,j)) {
							ans++;
							solve(i,j);
						}
					}
				}
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='.') ans++;
				}
			}
			System.out.println("#"+t+" " + ans);
		}
		
	}
	private static void solve(int x, int y) {
		map[x][y] = '1';
		for(int d=0; d<8; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny]=='.') {
				map[nx][ny] =  '1';
				if(go(nx,ny)) solve(nx,ny);
			}
		}
	}
	private static boolean go(int x, int y) {
		for(int d=0; d<8; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(map[nx][ny]=='*') {
				return false;
			}
		}
		return true;
	}
	
}
