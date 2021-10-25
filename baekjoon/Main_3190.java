package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main_3190 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<K; i++) {
			String[] data = br.readLine().split(" ");
			System.out.println(Integer.parseInt(data[0]) + " " + Integer.parseInt(data[1]));
			map[Integer.parseInt(data[0])][Integer.parseInt(data[1])] = 1;
		}
		for(int i=0; i<N; i++) {
			for(int j =0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		int L = Integer.parseInt(br.readLine());
		char[] command = new char[L];
		int[] commandt = new int[L];
		for(int i=0; i<L; i++) {
			String[] data = br.readLine().split(" ");
			commandt[i] = Integer.parseInt(data[0]);
			command[i] = data[1].charAt(0);
		}
		int ans =1;
		int x = 1;
		int y = 1;
		int dir = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		map[1][1] = 2;
		List<int[]> snake = new LinkedList<>();
		snake.add(new int[] {x,y});
		while(true) {
			for(int i = 0; i<command.length; i++) {
				if(ans == commandt[i]) {
					if(command[i] ==  'L') {
						dir--;
						if(dir == -1) dir =3;
					}
					else {
						dir++;
						if(dir == 4) dir = 0;
					}
					break;
				}
			}
			x +=dx[dir%4];
			y +=dy[dir%4];
			if(x <=0 || x>=N-1 || y<=0 || y >=N-1) break;
			if(map[x][y] == 2) break;
			if(map[x][y] == 1) {
				map[x][y] = 2;
			}else {
				int[] data = snake.remove(0);
				map[data[0]][data[1]] = 0;
			}
			map[x][y] =2;
			snake.add(new int[] {x,y});
			ans++;
		}
		System.out.println(ans+1);
		
	}
}
