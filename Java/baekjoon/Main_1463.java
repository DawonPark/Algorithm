package java. java.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 
 */
public class Main_1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[1000001];
		D[1] = 0;
		D[2] = 1;
		D[3] = 1;
		for (int i = 4; i <= N; i++) {
			D[i] = D[i - 1] + 1;
			if (i % 3 == 0) {
				D[i] = Math.min(D[i / 3] + 1, D[i]);
			}
			if (i % 2 == 0) {
				D[i] = Math.min(D[i / 2] + 1, D[i]);
			}
		}
		System.out.println(D[N]);
	}
}
