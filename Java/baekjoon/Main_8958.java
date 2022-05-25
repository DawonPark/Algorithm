package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 8958 - OX퀴즈
 * 
 * -> O면 count를 올리면서 ans에 더해주고 X 면 count를 리셋 시킴
 */
public class Main_8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 0; t < T; t++) {
			String result = sc.nextLine();
			int ans = 0;
			int count = 0;
			for (int i = 0; i < result.length(); i++) {
				if (result.charAt(i) == 'O') {
					ans += ++count;
				} else {
					count = 0;
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
