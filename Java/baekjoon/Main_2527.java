package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 2528 직사각형
 * 
 * -> 좌표도 자꾸 헷갈리고 직사각형이 겹칠때의 경우가 생각보다 많아서 오래걸렸다.
 * -> 문제를 풀고나서 든 방법->직사각형의 경우의 수가 많으니까 현재코드에 b를 처리를 else로 한 건데 직사각형을 그렇게 했어야 됬음.
 */
public class Main_2527 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 4; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int x3 = sc.nextInt();
			int y3 = sc.nextInt();
			int x4 = sc.nextInt();
			int y4 = sc.nextInt();
			// 꼭짓점이 사각형 안에 있을때
			if (x1 == x3 && y1 == y3 && x2 == x4 && y2 == y4) {
				System.out.println("a");
				continue;
			}

			if (x3 <= x1 && x1 < x4 && y3 <= y1 && y1 < y4) {
				System.out.println("a");
				continue;
			}
			if (x3 < x2 && x2 <= x4 && y3 < y2 && y2 <= y4) {
				System.out.println("a");
				continue;
			}
			if (x1 <= x3 && x3 < x2 && y1 <= y3 && y3 < y2) {
				System.out.println("a");
				continue;
			}
			if (x1 < x4 && x4 <= x2 && y1 < y4 && y4 <= y2) {
				System.out.println("a");
				continue;
			}

			// 겹쳐있을때
			if (x1 < x4 && x4 < x2 && y3 < y2 && y2 < y4) {
				System.out.println("a");
				continue;
			}

			if (x3 < x2 && x2 < x4 && y1 < y4 && y4 < y2) {
				System.out.println("a");
				continue;
			}

			// 점
			if ((x1 == x4 && y1 == y4) || (x1 == x4 && y2 == y3) || (x2 == x3 && y2 == y3) || (x2 == x3 && y1 == y4)) {
				System.out.println("c");
				continue;
			}
			// 분리
			if (x2 < x3 || x4 < x1 || y2 < y3 || y4 < y1) {
				System.out.println("d");
				continue;
			}
			System.out.println("b");

		}

	}
}
