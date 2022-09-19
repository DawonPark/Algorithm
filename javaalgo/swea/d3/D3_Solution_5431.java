package javaalgo.swea.d3;

import java.util.Scanner;

public class D3_Solution_5431 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] check = new boolean[N+1];
			for(int i=0; i<K; i++) {
				check[sc.nextInt()] = true;
			}
			System.out.print("#" + t + " ");
			for(int i =1 ; i<=N; i++) {
				if(!check[i]) System.out.print(i+ " ");
			}
			System.out.println();
			
		}
		sc.close();
	}
}
