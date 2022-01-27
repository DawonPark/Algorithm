package baekjoon;

import java.util.Scanner;


public class Main_20165 {
	static int N, M , R ,ans;
	static int[][] map;
	static int[][] temp;
	static int[][] defense;
	static Attack[] attack;
	static class Attack {
		int x , y;
		char dir; 
		public Attack(int x, int y, char dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Attack [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
		
	}
	
	
	public static void main(String[] args) {
		// N 행,  M 열 , R
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		map = new int[N+1][M+1];
		temp = new int[N+1][M+1];
		for(int i =1; i<=N; i++) {
			for(int j =1; j<=M; j++) {
				map[i][j] = sc.nextInt();
				temp[i][j] = map[i][j];
			}
		}
		
		sc.nextLine();
		
		attack = new Attack[R];
		defense = new int[R][2];
		// e w s n 방향
		
		for(int i=0; i<R; i++) {
			String[] data = sc.nextLine().split(" ");
			attack[i] = new Attack(Integer.parseInt(data[0]) ,Integer.parseInt(data[1]),data[2].charAt(0));
			data = sc.nextLine().split(" ");
			defense[i][0] = Integer.parseInt(data[0]);
			defense[i][1] = Integer.parseInt(data[1]);
		}
		
		ans =0;
		for(int i=0; i<R; i++) {
			attack(attack[i].x,attack[i].y, attack[i].dir);
			defense(defense[i][0], defense[i][1]);
			System.out.println(ans);
		}
		
		System.out.println(ans);
		for(int i =1; i<=N; i++) {
			for(int j =1; j<=M; j++) {
				if(temp[i][j] == 0) System.out.print("F ");
				else System.out.print("S ");
			}
			System.out.println();
		}
	
		
		
		
		
	}


	private static void defense(int x, int y) {
		if(temp[x][y] == 0) {
			temp[x][y] = map[x][y];
		}
	}


	private static void attack(int x, int y, char dir) {
		if(temp[x][y] == 0) return;
		int max = temp[x][y];
		
		if(dir == 'E') { // 왼쪽 -> 행
			while(max > 0) {
				if(temp[x][y] != 0) {
					temp[x][y]=0;
					ans++;
					max--;
					y++;
				}else {
					max--;
					y++;
				}
				if(y == M+1 ) break;
				max = Math.max(max, temp[x][y]);					
			}
		} else if (dir == 'N') { // 위 -> 열
			while(max > 0) {
				if(temp[x][y] != 0) {
					temp[x][y]=0;
					ans++;
					max--;
					x--;
				}else {
					max--;
					x--;
				}
				if(x == 0 ) break;
				max = Math.max(max, temp[x][y]);
			}
			
		} else if (dir == 'S') { // 아래 -> 열
			while(max > 0) {
				if(temp[x][y] != 0) {
					temp[x][y]=0;
					ans++;
					max--;
					x++;
				}else {
					max--;
					x++;
				}
				if(x == N+1 ) break;
				max = Math.max(max, temp[x][y]);
			}
		
		} else if (dir == 'W') { //  오른쪽  -> 행
			while(max > 0) {
				if(temp[x][y] != 0) {
					temp[x][y]=0;
					ans++;
					max--;
					y--;
				}else {
					max--;
					y--;
				}
				if(y == 0 ) break;
				max = Math.max(max, temp[x][y]);
			}
		}
	}
}
