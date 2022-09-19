package javaalgo.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D3_Solution_4615 {
	 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t =1 ; t<=T; t++) {
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			map[N/2-1][N/2-1] = 2;
			map[N/2-1][N/2] = 1;
			map[N/2][N/2-1] = 1;
			map[N/2][N/2] = 2;
			int[] dx = {0,0,1,-1,-1,-1,1,1};
			int[] dy = {1,-1,0,0,-1,1,-1,1};
			for(int i = 0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
				map[x-1][y-1] = color;
				for(int d = 0 ; d<8; d++) {
					ArrayList<int[]> list = new ArrayList<>();
					boolean check = false;
					int nx = x-1,  ny=y-1;
					while(true) {
						nx = nx+dx[d];
						ny = ny+dy[d];
						if(nx<0 || nx>=N || ny<0 || ny>=N ) break;
						list.add(new int[] {nx,ny});
						if(map[nx][ny] == 0) break;
						if(map[nx][ny] == color) {
							check= true;
							break;
						}
					}
					if(check) {
						for(int[] data : list) {
							map[data[0]][data[1]] = color;
						}
					}
				}
			}
			int black =0, white =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 1) {
						black++;
					}else if(map[i][j] == 2) {
						white++;
					}
				}
			}
			System.out.println("#" + t+ " "+ black + " " + white);
		}
	}
}
