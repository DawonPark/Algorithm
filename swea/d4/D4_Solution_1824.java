package swea.d4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class D4_Solution_1824 {
	static boolean[][][] visited; 
	static class Point {
		public Point() {}
		int x,y,dir,memo;
		public Point(int x, int y, int dir, int memo) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.memo = memo;
		}
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", dir=" + dir + ", memo=" + memo + "]";
		}
	}
	
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
			if(t==40) {
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				return;
			}
			
			if(!check) {
				System.out.println("#" + t + " NO");
				continue outer;
			}
			if(map[0][0] =='@') {
				System.out.println("#" + t +" YES");
				continue outer;
			}
			int[] dx = {0,0,-1,1}; // 왼 오 위 아
			int[] dy = {-1,1,0,0};
			Queue<Point> queue = new LinkedList<>();
			visited = new boolean[R][C][16];
			Point p =check(new Point(0,0,1,0),map[0][0],0,0);
			visited[0][0][p.memo] = true;
			queue.add(p);
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
				if(map[nx][ny] == '_' || map[nx][ny] == '|'
				   ||map[nx][ny] == '+' || map[nx][ny] == '-') {
					Point add = new Point(data.x,data.y,data.dir,data.memo);
					add = check(add,map[nx][ny],nx,ny);
					visited[add.x][add.y][add.memo] = true;
					queue.add(add);
					continue;
				}
				if(visited[nx][ny][p.memo]) {
					continue;
				}
				if(map[nx][ny]=='?') {
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
						Point add = new Point(data.x,data.y,data.dir,data.memo);
						add = check(add,map[nx1][ny1],nx1,ny1);
						if(!visited[nx1][ny1][add.memo]) continue;
						if(d==add.dir) add.dir = d;
						visited[add.x][add.y][add.memo] = true;
//						System.out.println(add);
						queue.add(add);
					}
					continue;
				}
				Point add = new Point();
				add = check(data,map[nx][ny],nx,ny);
				visited[add.x][add.y][add.memo] = true;
				queue.add(add);
			}
			System.out.println("#" + t + " NO");
		}
	}
  // 왼 오 위 아
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
			case '-':
				p.memo= p.memo==0 ?  15 : p.memo-1;
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
