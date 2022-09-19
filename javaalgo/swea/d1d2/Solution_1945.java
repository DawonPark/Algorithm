package javaalgo.swea.d1d2;

import java.util.Scanner;

public class Solution_1945 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			int num = sc.nextInt();
			int[] count = new int[5];
			while (num > 1) {
				if (num % 2 == 0) {
					count[0]++;
					num /= 2;
				}
				if (num % 3 == 0) {
					count[1]++;

					num /= 3;
				}
				if (num % 5 == 0) {
					count[2]++;

					num /= 5;
				}
				if (num % 7 == 0) {
					count[3]++;

					num /= 7;
				}
				if (num % 11 == 0) {
					count[4]++;

					num /= 11;
				}
			}
			System.out.printf("#%d %d %d %d %d %d%n", t, count[0], count[1], count[2], count[3], count[4]);
		}
		sc.close();
	}
}
