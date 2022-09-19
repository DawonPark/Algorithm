package javaalgo.swea.d3;

import java.util.Scanner;

/*
 * 	1 이상 N 이하의 정수가 적혀 있는 길이 N의 순열 p1, p2, …, pN이 있다. 
 * 	수열에 있는 모든 숫자는 서로 다르다. 2 ≤ i ≤ N-1이며,
 *  pi-1, pi, pi+1 중 pi가 최솟값도, 최댓값도 아니라면 pi를 평범한 숫자라고 정의한다.
 *  주어진 순열에서 평범한 숫자의 개수는 몇 개인가?
 *  
 *  -> 평범한 숫자일 경우는 두가지이다. 
 *  1. i-1 최솟값, i+1 최대값
 *  2. i-1 최댓값, i+1 최솟값
 */
public class D3_Solution_11736 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0; i<n ; i++) {
				arr[i] = sc.nextInt();
			}
			int count =0;
			for(int i=1; i<n-1; i++) {
				if((arr[i-1]<arr[i]&& arr[i]<arr[i+1]) ||(arr[i-1]>arr[i]&& arr[i]>arr[i+1])) {
					count++;
				}
			}
			System.out.println("#"+t+ " " +count);
			
		}
		sc.close();
	}
}
