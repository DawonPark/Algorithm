package swea.d4;

import java.util.HashSet;
import java.util.Scanner;

public class D4_Solution_2819 {
	static int[][] map ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			map = new int[4][4];
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			hs = new HashSet<>();
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					dfs(i,j,1,Integer.toString(map[i][j]));
				}
			}
			System.out.println("#"+t +  " "+hs.size());
		}
		sc.close();
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static HashSet<String> hs;
	private static void dfs(int x, int y, int cnt, String ans) {
		if(cnt == 7) {
			hs.add(ans);
			return;
		}
		for(int d = 0 ; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=4 || ny<0 || ny>=4) continue;
			dfs(nx,ny,cnt+1,ans+Integer.toString(map[nx][ny]));
		}
		
		
	}
}
