package baekjoon;

import java.util.Scanner;
/*
 * 백준 14696 - 딱지놀이
 * 
 * -> 우선순위대로 체크해서 프린트 찍고 다음으로 넘김
 */
public class Main_14696 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =Integer.parseInt(sc.nextLine());
		int[][] A = new int[N][5];
		int[][] B = new int[N][5]; 
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			for(int j=0; j<a; j++) {
				A[i][sc.nextInt()]++;
			}
			 a = sc.nextInt();
			for(int j=0; j<a; j++) {
				B[i][sc.nextInt()]++;
			}
			
			
			for(int j=4; j>=1; j--) {
				if(A[i][j] > B[i][j]) {
					System.out.println("A");
					break;
				}else if( B[i][j]> A[i][j]) {
					System.out.println("B");
					break;
				}else if(j==1) {
					System.out.println("D");
				}
			}
			
		}
		sc.close();
	}
}
