package java. swea.d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D6_Solution_1263 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] matrix = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j<N; j++) {
					matrix[i][j] = Integer.parseInt(st.nextToken());
					if(matrix[i][j] == 0 && i!=j) matrix[i][j]=2000;
				}
			}
			for(int k =0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						matrix[i][j] = Math.min(matrix[i][k]+ matrix[k][j], matrix[i][j]);
					}
				}
			}
			int ans =Integer.MAX_VALUE;
			for(int i =0; i<N; i++) {
				int temp =0;
				for(int j=0; j<N; j++) {
					temp+=matrix[i][j];
				}
				ans = Math.min(ans,temp);
			}
			System.out.println("#" + t + " " + ans);
			
		}
	}
}
