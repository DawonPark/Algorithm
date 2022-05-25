package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 3052 - 나머지
 * check배열로 나머지 있는 것 체크
 */
public class Main_3052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] check = new boolean[43];
		for (int i = 0; i < 10; i++) {
			check[sc.nextInt() % 42] = true;
		}
		int count = 0;
		for (int i = 0; i < 43; i++) {
			if (check[i] == true)
				count++;
		}
		System.out.println(count);
		sc.close();
	}

}
