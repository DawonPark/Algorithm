package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_Solution_1861 {
	/*
	 * 상하좌우에 있는 다른 방으로 이동할 수 있다.
	      물론 이동하려는 방이 존재해야 하고, 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
              처음 어떤 수가 적힌 방에서 있어야 가장 많은 개수의 방을 이동할 수 있는지 구하는 프로그램을 작성하라
              방에는 1이상 N2 이하의 수 Ai,j가 적혀 있으며, 이 숫자는 모든 방에 대해 서로 다르다.
              
              방 크기 : N*N
        -> 반복을 돌리기 어려울 때는 재귀를 생각 -> 각 숫자가 다르므로 +1 된 숫자는 한개 밖에 없다 사방탐색으로 보고 있다면 재귀 호출을 하는 방향으로 프로그래밍
	 */
	static int room[][];
	static int n;
	static int dx[] = {-1,1,0,0}; // 상하좌우
	static int dy[] = {0,0,-1,1};
	static int cnt; // 움직 일 수 있는 방의 개수

	static boolean move(int x, int y) { // 배열 안에 체크
		return 0<=x && x<n && 0<=y && y<n;
	}
	
	static int check(int x, int y) {	 // 재귀 함수 
		for(int d =0; d<4; d++) {
			if(move(x+dx[d],y+dy[d])) {
				if(room[x][y]+1 == room[x+dx[d]][y+dy[d]]) { 	// 1보다 큰걸 찾았을때
					cnt++; 		// 방의 개수를 하나 올리고 다음 방 좌표 값으로 다시 호출
					check((x+dx[d]),(y+dy[d]));
					break;
				}
			}
		} 
		return cnt;
	}
	public static void main(String[] args) throws Exception {
//		Scanner sc =new Scanner(System.in);
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int t=1; t<=tc; t++) {
			int max = Integer.MIN_VALUE;
			int result =0;
			n = Integer.parseInt(br.readLine());
			room = new int[n][n];
			for(int x= 0; x<n; x++) {
				st= new StringTokenizer(br.readLine(), " ");
				for(int y = 0; y<n; y++) {
					room[x][y] =Integer.parseInt(st.nextToken());
				}
			}
			for(int x= 0; x<n; x++) {
				for(int y = 0; y<n; y++) {
					cnt =1;
					int temp = check(x,y);
					if(max<temp) {
						max = temp;
						result = room[x][y];
					}else if(max == temp) { 	    // 최대 방의 크기가 같을 떄는 작은 곳
						if(room[x][y]<result) {
							result =room[x][y];
						}						
					}
				}
			}
			System.out.println("#"+t +" " + result+" "+ max);			
		}
	}
}
