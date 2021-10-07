package swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWTest_Solution_4014 {
	static int N, X, ans;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// map 길이
			X = Integer.parseInt(st.nextToken()); 	// 활주로 길이
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			for (int i = 0; i < N; i++) {
				check(map[i]);
				int[] tmp = new int[N];
				for (int j = 0; j < N; j++) {
					tmp[j] = map[j][i];
				}
				check(tmp);
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void check(int[] map) {
		int r =  map[0];
		int cnt = 1;		
		boolean check = false;
		for(int i = 1; i < N; i++) {
			if(Math.abs(map[i - 1]-map[i]) > 1) return;
 			if(r ==  map[i]) {
				cnt += 1;
				if(check && cnt == X) {
					cnt = 0;
					check = false;
				}
				continue;
			} else if (r <  map[i]) {
				if(cnt < X) return;
				check = false;
			} else {
				if(check && cnt < X) return;
				check = true;
			}
			cnt = 1;
			r =  map[i];
		}
		if(check && cnt < X) return;
		ans += 1;
	}
}
