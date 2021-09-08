package swea;

import java.util.Scanner;

/*
 *  SWEA 1227 - 미로2
 *  
 *  -> DFS로 길찾고 check로 도착지점을 판단.
 */

public class D4_Solution_1227 {
	static int[][] map;
	static boolean[][] isVisited;
	static boolean check;
	static int[] dx = {1,-1,0,0 };
	static int[] dy = {0,0,-1,1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			sc.nextLine(); // 테케 번호는 넘김
			map = new int[100][100];
			isVisited = new boolean[100][100];
			int x=0, y=0;
			for(int i=0; i<100; i++) {
				String s = sc.nextLine();
				for(int j=0; j<100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j]==2) {
						x=i;
						y=j;
					}
				}
			}
			check = false;
			isVisited[x][y]= true;
			solve(x,y);
			System.out.println("#"+t+" " + (check? 1:0));
		}
		
	}

	private static void solve(int x, int y) {
		if(check == true) {
			return;
		}
		for(int d =0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=100 ||ny<0 || ny>=100) continue; // 경계조건
			if(map[nx][ny] == 1) continue;
			if(map[nx][ny]==0 && !isVisited[nx][ny]) {
				isVisited[nx][ny] = true;
				solve(nx,ny);
			}
			if(map[nx][ny]==3) {
				check =true;
			}
		}
		
		
	}
	
	
}
