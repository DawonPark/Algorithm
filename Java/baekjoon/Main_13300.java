package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 13300 - 방배정
 * 
 * -> students 이차원배열에 학년과 성별로 숫자를 카운트해서 넣어주고 방의 수를 구해줌.
 */
public class Main_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] students = new int[7][2];
		for (int i = 0; i < N; i++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			students[Y][S]++;
		}
		int ans = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 0; j < 2; j++) {
				if (students[i][j] != 0) {
					if (students[i][j] / K == 0) {
						ans++;
						continue;
					} else {
						int temp = students[i][j] / K;
						students[i][j] -= temp * K;
						if (students[i][j] != 0)
							temp++;
						ans += temp;
					}
				}
			}
		}
		System.out.println(ans);
	}
}
