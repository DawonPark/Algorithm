package java. java.baekjoon;

import java.util.Scanner;
/*
 * 백준 1592 영식이와 친구들
 * 
 * -> 간단한 문제 홀수와 짝수 , 배열의 인덱스가 넘어가는것만 처리해주면 됨
 */

public class Main_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int[] circle = new int[N + 1];
		int idx = 1;
		circle[idx]++;
		int count = 0;
		while (true) {
			if (circle[idx] % 2 == 1) {// 홀수면
				idx = idx + L;
				if (idx > N - 1) {
					idx -= N;
				}
			} else {
				idx = idx - L;
				if (idx < 0) {
					idx += N;
				}
			}
			count++;
			if (++circle[idx] == M)
				break;

		}
		System.out.println(count);
		sc.close();
	}
}
