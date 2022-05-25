package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 8320 - 직사각형을 만드는 방법
 * 
 * 정사각형으로 직사각형을 만드는데 겹치는 것은 2X3 3X2이런 경우인데 이 경우를 제외하고 count를 세줌
 */
public class Main_8320 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 1;
		for (int i = 2; i <= N; i++) {
			count++;
			for (int j = i; j <= N; j++) {
				if (i * j <= N) {
					count++;
				} else
					break;
			}
		}
		System.out.println(count);
		sc.close();
	}
}
