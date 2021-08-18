package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 백준 쿼드트리
 * 
 *  -> 4개의 영역으로 나눠서 압축을 한다. 01 이 섞여있으면 한번에 나타내지 못하고  4개에 영역으로 묶어서 표현된다. -> 재귀
 *  재귀 종료 조건은 같은 숫자로 되있을 때 / 다시 들어가야할 때는 숫자가 섞여있을때(1사분면,2사분면,3사분면,4사분면) 진입
 *  출력 조건에 들어갈때는 ( 다시 돌아오면 ) 있어서 붙여줌
 *  
 */
public class Main_1992 {
	static int[][] videos;
	static int N, num;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		 sb = new StringBuilder();
		 videos = new int[N][N];
		for(int i=0; i<N; i++) {
			String data = br.readLine();
			for(int j=0; j<N; j++) {
				videos[i][j] = data.charAt(j) - '0';
			}
		}
		solve(N, 0, 0);
		System.out.println(sb);
		
	}

	private static void solve(int n, int r, int c) {
		if(check(n,r,c)) {  // 맞으면
			sb.append(num); // 같은숫자 append
			return;
		}
		sb.append("("); // 처음 시작 ( 
		n /=2;
		solve(n, r, c); // 1사분면
		solve(n, r,c+n); // 2사분면
		solve(n, r+n,c); // 3사분면
		solve(n, r+n,c+n);// 4사분면
		sb.append(")"); // 종료 )
		
	}
	
	static boolean check(int n, int r, int c) { // 더 들어가야하는지 체크
		num = videos[r][c]; // 같은 숫자를 판별하기 위해서 가져옴
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n;j++) {
				if(videos[i][j]!=num) {
					return false; // 다른숫자면 false
				}
			}
		}
		return true;
		
	}
	
	
}
