package swea;

import java.util.Scanner;
/*
 * SWEA 1209 - Sum
 * 
 * -> 배열 행, 열 , 대각선 검사
 */
public class D3_Solution_1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			sc.nextInt();
			int [][]arr = new int[100][100];
			int sum=0;
			for(int i=0; i<100; i++) {
				int temp=0;
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
					temp+=arr[i][j];
				}
				sum = Math.max(temp, sum);
			}
			for(int i=0; i<100; i++) {
				int temp =0;
				for(int j=0; j<100; j++) {
					temp+=arr[j][i];
				}
				sum = Math.max(temp, sum);
			}
			int temp =0;
			for(int i=0; i<100; i++) {
				temp+= arr[i][i];
			}
			sum = Math.max(temp, sum);
		
			temp=0;
			for(int i=99; i>=0; i--) {
				temp+= arr[99-i][i];
			}
			sum = Math.max(temp, sum);
			System.out.println("#"+t+ " " + sum);
			
		}
		sc.close();
	}
}
