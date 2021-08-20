package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * 재귀를 태울 때 처음에 arr을 파라미터로 안주고 시작을 했는데 그 시점에서 다시 복원하기가 쉽지 않아서 안에서 copy 배열로 그 시점을 복원하도록 함
 * -> 파라미터로 준 배열을 건드리면 다시 복구하기 힘들어서 copy로 보내줌.
 * 
 * 카메라는 ArrayList로 받으면서 count를 세고 카메라 모두를 돌렸을때에 종료하면서 사각지대를 계산하게함.
 */

public class Main_15683 {
	static int N, M, ans, count;
	static int[][] map, copy;
	static ArrayList<Camera> cameras = new ArrayList<>();

	static class Camera {
		int x;
		int y;
		int num;

		public Camera(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		map = new int[N][M];
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int val = Integer.parseInt(data[j]);
				if (val != 0 && val != 6) {
					cameras.add(new Camera(i, j, val));
					count++;
				}
				map[i][j] = val;
				copy[i][j] = val;
			}
		}
		ans = Integer.MAX_VALUE;
		solve(map,0);
		System.out.println(ans);
	}

	static void copy(int[][] arr1 , int[][] arr2) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
	}
	
	static void solve(int[][] arr,int cnt) {
		if (cnt == count) {
			int temp = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (arr[i][j] == 0) {
						temp++;
					}
				}
			}
//			System.out.println(Arrays.deepToString(map));
//			System.out.println(Arrays.deepToString(copy));
			System.out.println(Arrays.deepToString(arr));
			ans = Math.min(temp, ans);
			return;
		}
			int x = cameras.get(cnt).x;
			int y = cameras.get(cnt).y;
			int num = cameras.get(cnt).num;
			int copy[][] = new int[N][M]; // 복구해야하기 때문에 copy배열이 필요
			
			if(num ==1) { 
				copy(copy, arr);
				left(copy,x, y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				right(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				up(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				down(copy,x,y);
				solve(copy,cnt+1);
			}else if(num == 2){
				copy(copy, arr);
				left(copy,x, y);
				right(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				up(copy,x,y);
				down(copy,x,y);
				solve(copy,cnt+1);
			}else if(num == 3){
				copy(copy, arr);
				up(copy,x, y);
				right(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				right(copy,x,y);
				down(copy,x, y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				down(copy,x, y);
				left(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				left(copy,x, y);
				up(copy,x,y);
				solve(copy,cnt+1);
			}else if(num == 4){
				copy(copy, arr); // 왼 위 오
				up(copy,x, y);
				left(copy,x,y);
				right(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr); // 위 오 아
				up(copy,x, y);
				right(copy,x,y);
				down(copy,x,y);
				solve(copy,cnt+1);
				
				copy(copy, arr); // 왼 아 오
				right(copy,x,y);
				down(copy,x,y);
				left(copy,x, y);
				solve(copy,cnt+1);
				
				copy(copy, arr);
				down(copy,x,y);
				left(copy,x, y);
				up(copy,x,y);
				solve(copy,cnt+1);
				
				
			}else if(num == 5){
				copy(copy, arr);
				left(copy,x, y);
				right(copy,x,y);
				up(copy,x,y);
				down(copy,x,y);
				solve(copy,cnt+1);
			}
		
		

	}

	static void left(int[][] arr,int x, int y) {
			for (int j = y-1; j >= 0; j--) {
				if(arr[x][j]==6) break;
				arr[x][j]=-1;
			}
	}
	static void right(int[][] arr,int x, int y) {
		for (int j = y+1; j <M; j++) {
			if(arr[x][j]==6) break;
			arr[x][j]=-1;
		}
	}
	static void up(int[][] arr,int x, int y) {
		for (int i= x-1; i>=0; i--) {
			if(arr[i][y]==6) break;
			arr[i][y]=-1;
		}
	}
	static void down(int[][] arr,int x, int y) {
		for (int i= x+1; i<N; i++) {
			if(arr[i][y]==6) break;
			arr[i][y]=-1;
		}
	}

}
