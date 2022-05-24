package baekjoon;

import java.util.Scanner;

public class Main_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		while(start <=N-1 && end <=N-1) {
			if(sum>=S) {
				min = Math.min(min, end-start);
			}
			if(sum < S) sum += arr[end++];
			else sum -= arr[start++];
		}
		System.out.println(min == Integer.MAX_VALUE ? "0" : min);
	}
}
