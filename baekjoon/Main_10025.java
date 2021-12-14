package baekjoon;

import java.util.Scanner;

public class Main_10025 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 양동이의 수
		int K = sc.nextInt(); // 떨어진 거리
		int[] arr = new int[1000001];

		for(int i=0; i<N; i++) {
			int g= sc.nextInt();
			int x= sc.nextInt();
			arr[x] = g; 
		}
		
		int ans = 0;
		int sum = 0;
		int window =2*K+1; // K곰K => 2K+1
		
		for(int i=0; i<=1000000; i++) {
			if(i<window) {
				sum+=arr[i];
			}else {
                sum+=arr[i];
				sum-=arr[i-window];
			}
			if(sum > ans) {
				ans = sum;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
