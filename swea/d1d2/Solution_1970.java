package swea.d1d2;

import java.util.Scanner;

public class Solution_1970 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc =sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int change[][] = {{10,50,100,500,1000,5000,10000,50000},{0,0,0,0,0,0,0,0}};
			int money =sc.nextInt();
			for(int i=7; i>=0; i--) {
				if(money/change[0][i]>0) {
					change[1][i]+=money/change[0][i];
					money-=money/change[0][i]*change[0][i];
				}
			}
			
			
			System.out.println("#"+t);
			for(int k=7; k>=0; k--) {
				System.out.print(change[1][k]+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
