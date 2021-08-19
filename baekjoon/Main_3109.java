package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 *  백준 3109 빵집
 * 
 * 파이프라인이 겹치지 않아야한다는 것은 한 행마다 설치할 수 있는 개수는 한개만 가능함.
 * 파이프라인이 첫째 행에서 시작하고 열이 전진 할 때 왼쪽 위부터 검사한다면 최대 경우 수가 나온다고 생각함.
 * -> 파이프를 연결해보든 말든 잘 생각해보면 갔던 경로로 갈 경우는 없다. -> 갔던 곳 x로 갱신
 * -> 한번 파이프를 깔면 더 이상 할 필요없기 때문에 check boolean 타입으로 검사해서 true 면 return
 *  
 */
public class Main_3109 {
	static int R , C ,ans;
	static char[][] map;
	static int[] dx = {-1,0,1};
	static boolean check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		 R = Integer.parseInt(data[0]);
		 C = Integer.parseInt(data[1]);
		 map = new char[R][C];
		 for(int i=0; i<R; i++) {
			 String s =br.readLine();
			 for(int j=0; j<C; j++) {
				 map[i][j] = s.charAt(j);
			 }
		 }
		 for(int i=0; i<R; i++) {
			 check = false;
			 solve(i,0);
		 }
		 System.out.println(ans);
	}
	
	
	static void solve(int r,int c) {
		if(c == C-1) {
			ans++;
			check = true;
			return;
		}
		
		for(int d =0; d<3; d++) {
			int nr = r + dx[d];
			int nc = c + 1;
			if(check == true) return;
			
			if(nr <0 || nr >= R || nc< 0 || nc >= C) continue;
			
			if(map[nr][nc]=='.' ) {
				map[nr][nc] = 'x';
				solve(nr,nc);
			}
		
		}
	}
	
}
