package swea;

import java.util.Scanner;
/*
 *  2814. 최장  경로
 *  
 *  -> 처음에  isVisited배열없이 하다가 순환 그래프가 있을 수도 있어 isVisited배열을 만들게 됨
 *  -> 재귀로 경로가 있다면 들어가고 아니면 다음 노드와의 간선확인
 */
public class D3_Solution_2814 {
	static int ans,N,M;
	static boolean[] isVisited;
	static boolean[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			 N = sc.nextInt();
			 M = sc.nextInt();
			 arr = new boolean[N+1][N+1];
			 isVisited = new boolean[N+1];
			 for(int i= 0; i<M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = arr[y][x] =true;
			}
			
			ans = 1;
			for(int i=1; i<N; i++) {
				isVisited[i] = true;
				solve(i,1);
				isVisited[i] = false;
			}
			System.out.println("#"+t + " " + ans);
		}
		sc.close();
	}
	
	
	static void solve(int index, int count) {
		if(count>ans) {
			ans = count;
		}
		for(int i=1; i<=N; i++) {
			if(isVisited[i] == true) continue;
			if(arr[index][i] == true) { // 간선이 있으면 
				isVisited[i] = true;
				solve( i, count+1);
				isVisited[i] = false;
			}else return;
		}
		
		
	}
}
