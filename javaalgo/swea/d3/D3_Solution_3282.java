package javaalgo.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_Solution_3282 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] V = new int[N+1];
			int[] C = new int[N+1];
			for(int i = 1; i<=N; i++) {
				V[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}
			int[] D = new int[K+1];
			for(int i = 1; i<=N; i++) {
				for(int k=K; k>=V[i]; k--) {
					D[k] = Math.max(D[k], C[i]+D[k-V[i]]);
				}
			}
			System.out.println("#"+t + " " + D[K]);
			
		}
	}
}
