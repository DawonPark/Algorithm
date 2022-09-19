package javaalgo.swea.d3;

import java.util.Scanner;

public class D3_Solution_1206 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int n = sc.nextInt();
			int[] building = new int[n+1];
			for(int i=0; i<n; i++) {
				building[i] = sc.nextInt();
			}
			int sum =0;
			int leftCount =0 , rightCount=0;
			for(int i=2; i<n-1; i++) {
				if(building[i-2]< building[i] && building[i-1]< building[i]) { // 왼쪽 조망권 확인
					leftCount = Math.min(building[i]- building[i-1], building[i]- building[i-2]);
				}
				if(building[i+1]< building[i] && building[i+2]< building[i]) { // 오른쪽 조망권 확인
					rightCount = Math.min(building[i]- building[i+1], building[i]- building[i+2]);
					sum += Math.min(leftCount, rightCount);
				}
				leftCount =0; rightCount=0;
			}
			System.out.println("#"+t+" "+sum);
		}
		sc.close();
	}
}
