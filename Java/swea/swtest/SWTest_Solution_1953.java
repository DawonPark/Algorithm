package swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWTest_Solution_1953 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<int[]> q = new LinkedList<>();
			boolean[][] visited = new boolean[N][M];
			visited[R][C] = true;
			int ans = 1; 
			q.add(new int[] {R,C,1});
			int[] dx = {-1,1,0,0}; // 상하좌우
			int[] dy = {0,0,-1,1};
			boolean[][] check = {{true,true,true,true},{true,true,false,false},{false,false,true,true},
								 {true,false,false,true},{false,true,false,true},{false,true,true,false},
								 {true,false,true,false}
			};
			while(!q.isEmpty()) {
				int[] data = q.poll();
				int x = data[0];
				int y = data[1];
				int time = data[2];
				if(time == L) break;
				for(int d =0; d<4; d++) {
					int nx = x +dx[d];
					int ny = y +dy[d];
					if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
					if(map[nx][ny] == 0 ) continue;
					if(visited[nx][ny]) continue;	
					if(d==0 && check[map[x][y]-1][0] && check[map[nx][ny]-1][1]) {
						ans++;
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,time+1});
					}
					if(d==1 && check[map[x][y]-1][1] && check[map[nx][ny]-1][0]) {
						ans++;
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,time+1});
					}
					if(d==2 && check[map[x][y]-1][2] && check[map[nx][ny]-1][3]) {
						ans++;
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,time+1});
					}
					if(d==3 && check[map[x][y]-1][3] && check[map[nx][ny]-1][2]) {
						ans++;
						visited[nx][ny] = true;
						q.add(new int[] {nx,ny,time+1});
					}
				}
			}
			System.out.println("#" + t + " "+ ans);
		}
	}
}
