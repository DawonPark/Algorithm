package java. swea.swtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWTest_Solution_5656 {
	static int N,W,H,ans;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			 N = sc.nextInt();
			 W = sc.nextInt();
			 H = sc.nextInt();
			 map = new int[H][W];
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = Integer.MAX_VALUE;
			solve(0, map);
			System.out.println("#" + t+ " "  + ans);
		}
		sc.close();
	}
	private static void solve(int cnt, int[][] map) {
		if(cnt == N) {
			int sum =0;
			for(int i = 0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					if(map[i][j]!=0) sum++;
				}
			}
			ans = Math.min(sum, ans);
			return;
		}
		for(int i=0; i<W; i++) {
			solve(cnt+1, explosion(i, map));
		}
		
	}
	
	private static int[][] explosion(int C, int[][] map) {
		int[][] copy = new int[H][W];
		copy(map, copy);
		int R = 0;
		for(int i=0; i<H; i++) {
			if(copy[i][C]!=0) {
				R=i;
				break;
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[H][W];
		queue.offer(new int[] {R,C,copy[R][C]});
		visited[R][C] = true;
		while(!queue.isEmpty()) {
			int[] data = queue.poll();
			int x = data[0];
			int y = data[1];
			int size = data[2]-1;
			for(int d =0; d<4; d++) {
				int nx = x; 
				int ny = y;
				for(int i =0; i<size; i++) {
					nx = nx + dx[d];
					ny = ny + dy[d];
					if(nx<0 || nx>=H || ny<0 || ny>=W ) continue;
					if(visited[nx][ny]) continue;
					if(copy[nx][ny]!=0) {
						queue.add(new int[] {nx,ny,copy[nx][ny]});
						copy[nx][ny] = 0;
						visited[nx][ny] = true;
					}
					if(copy[nx][ny] == 0) {
						visited[nx][ny] = true;
					}
				}
			}
			copy[x][y] = 0;
		}
	
			for(int i = 0; i<W; i++) { 
				for(int j = H-1; j>=0; j--) {
					if(copy[j][i]!=0) {
						int nx = j;
						if(j == H-1) continue;
						while(true) {
							nx +=dx[1];
							if(nx>=H) {
								copy[H-1][i] = copy[j][i];
								copy[j][i] = 0;
								break;
							}
							if(copy[nx][i]!=0) {
								copy[nx-1][i]=copy[j][i];
								if(j!= nx-1) copy[j][i] = 0;
								break;
							}
						}
					}
				}
			}
			
		return copy;
	}
	
	private static void copy(int[][] map, int[][] copy) {
		for(int i =0; i<H; i++) {
			for(int j =0; j<W; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}
	
}
