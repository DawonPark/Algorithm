package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 17413 - 단어 뒤집기2
 * 
 * -> 스택을 사용하려다가 start -> 문자열이 단어마다 끊을 곳을 찾아서 조건별로 sb에 붙여주는 식으로 함.
 */
public class Main_17413 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		int start = 0;
		boolean check = false;
		for (int i = 0; i < msg.length(); i++) {
			if (check == true)
				sb.append(msg.charAt(i));
			if (msg.charAt(i) == '<') {
				for (int j = i - 1; j >= start; j--) {
					sb.append(msg.charAt(j));
				}
				sb.append(msg.charAt(i));
				check = true;
			}
			if (msg.charAt(i) == '>') {
				check = false;
				start = i + 1;
			}
			if (msg.charAt(i) == ' ' && check == false) {
				for (int j = i - 1; j >= start; j--) {
					sb.append(msg.charAt(j));
				}
				start = i + 1;
				sb.append(msg.charAt(i));
			}

		}
		for (int j = msg.length() - 1; j >= start; j--) {
			sb.append(msg.charAt(j));
		}
		sc.close();
		System.out.println(sb);
	}
}
