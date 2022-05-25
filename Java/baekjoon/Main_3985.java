package java. java.baekjoon;

import java.util.Scanner;

public class Main_3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] cakes = new boolean[N + 1];
		int first = 1;
		int firstV = Integer.MIN_VALUE;
		int secondV = Integer.MIN_VALUE;
		int num = sc.nextInt();
		int secondResult = 0;
		for (int i = 1; i <= num; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int second = 0;

			if (end - start > firstV) {
//				System.out.println(i);
				firstV = end - start;
				first = i;
			}
			for (int j = start; j <= end; j++) {
				if (cakes[j] != true) {
					cakes[j] = true;
					second++;
				}
			}
			if (secondV < second) {
				secondV = second;
				secondResult = i;
			}
		}

		System.out.println(first);
		System.out.println(secondResult);
	}
}
