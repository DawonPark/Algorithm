package java. java.baekjoon;

import java.util.Scanner;

/*
 * 	가로, 세로의 크기가 각각 100인 정사각형 모양의 흰색 도화지가 있다. 이 도화지 위에 가로, 
 * 	세로의 크기가 각각 10인 정사각형 모양의 검은색 색종이를 색종이의 변과 도화지의 변이 평행하도록 붙인다.
 *  이러한 방식으로 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램을 작성하시오
 *  
 *  -> 도화지에 검은영역은 한번만 칠해져도 포함되기 때문에 겹치는 건 상관없어서 칠해지지 않았을때(false)에서만 count를 세줌
 */
public class Main_2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] paper = new boolean[101][101];
		int n = sc.nextInt();
		int count = 0;
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int r = 1; r <= 10; r++) {
				for (int c = 1; c <= 10; c++) {
					if (paper[x + r][y + c] == true)
						continue;
					else if (paper[x + r][y + c] == false) {
						paper[x + r][y + c] = true;
						count++;
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}
}
