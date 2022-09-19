package javaalgo.swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class D4_Solution_1824 {
	static boolean[][][][] visited; 
	static class Point {
		public Point() {}
		int x,y,dir,memo;
		public Point(int x, int y, int dir, int memo) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.memo = memo;
		}
	}
	//62 57 49
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
outer:	for(int t=1; t<=T; t++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			sc.nextLine();
			boolean check = false;
			char[][] map = new char[R][C];
			for(int i=0; i<R; i++) {
				String s = sc.nextLine();
				for(int j=0; j<C; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '@') check = true;
				}
			}
			if(!check) {
				System.out.println("#" + t + " NO");
				continue outer;
			}
			if(map[0][0]=='@') {
				System.out.println("#" + t + " YES");
				continue outer;
			}
			int[] dx = {0,0,-1,1}; // 왼 오 위 아
			int[] dy = {-1,1,0,0};
			Queue<Point> queue = new LinkedList<>();
			visited = new boolean[R][C][16][4];
			queue.offer(check(new Point(0,0,1,0),map[0][0],0,0));
			visited[0][0][queue.peek().memo][queue.peek().dir] = true;
			while(!queue.isEmpty()) {
				Point data = queue.poll();
//				System.out.println(data.x + "," + data.y + "," + data.memo);			
				int nx = data.x + dx[data.dir];
				int ny = data.y + dy[data.dir];
				if(nx<0) nx=R-1;
				if(nx>=R) nx=0;
				if(ny<0) ny=C-1;
				if(ny>=C) ny=0;
				if(map[nx][ny] == '@') {
					System.out.println("#" + t +" YES");
					continue outer;
				}
				
				if(map[nx][ny]== '?') {
					visited[nx][ny][data.memo][data.dir] = true;
					for(int d= 0; d<4; d++) {
						int nx1 = nx + dx[d];
						int ny1 = ny + dy[d];
						if(nx1<0) nx1=R-1;
						if(nx1>=R) nx1=0;
						if(ny1<0) ny1=C-1;
						if(ny1>=C) ny1=0;
						if(map[nx1][ny1] == '@') {
							System.out.println("#" + t + " YES");
							continue outer;
						}
						Point add = check(new Point(nx,ny,d,data.memo),map[nx1][ny1] ,nx1,ny1);
						if(visited[nx1][ny1][add.memo][add.dir]) continue;
						visited[nx1][ny1][data.memo][data.dir] = true;
						queue.offer(add);
					}
					continue;
				}
				Point add = check(new Point(data.x,data.y,data.dir,data.memo),map[nx][ny],nx,ny);
				if(visited[nx][ny][add.memo][add.dir]) continue;
				visited[nx][ny][add.memo][add.dir] = true;
				queue.offer(add);
			}
			System.out.println("#" + t + " NO");
			
		}
	}
	private static Point check(Point p,char c , int nx, int ny) {
		switch(c) {
			case '<':
				p.dir = 0;
				break;
			case '>':
				p.dir = 1;
				break;
			case '^':
				p.dir = 2;
				break;
			case 'v':
				p.dir = 3;
				break;
			case '_':
				if(p.memo==0) p.dir = 1;
				else p.dir=0;
				break;
			case '|':
				if(p.memo==0) p.dir = 3;
				else p.dir=2;
				break;
			case '+':
				p.memo= p.memo==15 ?  0 : p.memo+1;
				break;
			case '-':p.memo= p.memo==0 ?  15 : p.memo-1;
				break;
			case '.':
				break;
		}
		if('0'<= c && c<='9') p.memo = c - '0';
		p.x = nx;
		p.y = ny;
		return p;
	}
}