package swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_Solution_1226 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int t =1 ; t<=10; t++) {
			sc.nextLine();
			int startX = 0;
			int startY = 0;
			int endX = 0;
			int endY = 0;
			int map[][] = new int[16][16];
			int[] dx = {0,0,-1,1};
			int[] dy = {1,-1,0,0};
			
			for(int i =0; i<16; i++) {
				String s = sc.nextLine();
				for(int j =0; j<16; j++) {
					map[i][j] = s.charAt(j) -'0';
					if(map[i][j] == 2) {
						startX =i;
						startY =j;
					}else if(map[i][j]==3) {
						endX = i;
						endY = j;
					}
				}
			}
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] {startX, startY});
			boolean check =false;
			while(!queue.isEmpty()) {
				int[] data= queue.poll();
				for(int d = 0; d<4; d++) {
					int nx = data[0] + dx[d];
					int ny = data[1] + dy[d];
					if(nx<0 || nx >=16 || ny<0 || ny>=16) continue;
					if(nx == endX && ny == endY) check = true;
					if(map[nx][ny]>=1) continue;
					map[nx][ny] = 1;
					queue.add(new int[] {nx,ny});
				}
			}
			if(check) System.out.println("#"+t+" " + 1);
			else System.out.println("#" + t + " " + 0);
			
			
			
		}
		sc.close();
		
	}
}
