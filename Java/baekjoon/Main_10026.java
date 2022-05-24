package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 10026 - 적록색약
 * 
 * -> 그림의 같은 색 구역을 구하는데 dfs로 탐색해서 구분을 함
 * -> 적색과 녹색이 같이보이는 적록색약은 어차피 한 색깔로 보이기 때문에 G로 보이는 것을 R로 다 바꾸고 돌림.
 */
public class Main_10026 {
	
	static char[][] pic;
	static int ans, N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		char[][] copy = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				pic[i][j] = s.charAt(j);
				if(pic[i][j]=='G') {
					copy[i][j] = 'R';
				}else copy[i][j] = pic[i][j];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(pic[i][j]!='0') {
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.print(ans+ " ");
		ans =0;
		pic =copy;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(pic[i][j]!='0') {
					dfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	static void dfs(int x, int y) {
		char ch = pic[x][y];
		pic[x][y] = '0';
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(pic[nx][ny] ==ch) {
				dfs(nx,ny);
			}
		}
	}
	

	
	
}
