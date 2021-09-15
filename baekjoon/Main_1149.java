package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 백준 1149 RGB 거리
 *
 *- DP로 각집마다 색깔을 칠했을떄의 최소를 구함.
 */
public class Main_1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int[][] costs = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		int[][] D = new int[3][N+1];

		for(int i=1; i<=N; i++) {
			D[0][i] = Math.min(D[1][i-1], D[2][i-1])+ costs[i][0];
			D[1][i] = Math.min(D[0][i-1], D[2][i-1])+ costs[i][1];
		    D[2][i] = Math.min(D[0][i-1], D[1][i-1])+ costs[i][2];
		}
		int ans = Math.min(Math.min(D[0][N], D[1][N]),D[2][N]);
		System.out.println(ans);
	}
	
}
