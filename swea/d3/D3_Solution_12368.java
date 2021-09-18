package swea.d3;

import java.util.Scanner;
/*
 * SWEA 12368 - 24시간
 * 
 */
public class D3_Solution_12368 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A+B>=24) {
				A=(A+B)-24;
			}else {
				A +=B; 
			}
			
			System.out.println("#"+t+ " " + A);
		}
		sc.close();
	}
}
