package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 2292 벌집
 * 
 * 벌집이 한칸씩 갈때마다 start는 6씩 더해져야함.
 */
public class Main_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int start = 1;
		int result = 1;
		int i = 6;
		while (true) {
			if (N == 1)
				break;
			if (N > start) {
				start += i;
				result++;
				i += 6;
			} else
				break;
		}
		System.out.println(result);
		sc.close();
	}

}
