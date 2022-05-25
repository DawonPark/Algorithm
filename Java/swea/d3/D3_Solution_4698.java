package java. swea.d3;

import java.util.Scanner;
/*
 * SWEA 4698 - 테네스의 특별한 소수
 * 
 * -> j*j<=i Math.sqrt(i)를 이용해서 j<=Math.sqrt(i)도 똑같음 이 부분이 없으면 시간이 초과임
 */
public class D3_Solution_4698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		boolean[] arr = new boolean[1000001];
		for(int i =2; i<=1000000; i++) {
			for(int j=2; j*j<i; j++) {
				if(i%j==0) {
					arr[i] = true;
					break;
				}
			}
		}
		for(int t =1; t<=T; t++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			if(A==1) A= 2;
			int count =0;
			for(int i =A; i<=B; i++) {
				if(arr[i] == false) {
					if(Integer.toString(i).contains(Integer.toString(D))) {
						count++;
					}
				}
			}
			System.out.println("#"+t+" " + count);
			
		}
		sc.close();
	}
}
