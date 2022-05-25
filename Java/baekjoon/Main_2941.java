package java. java.baekjoon;

import java.util.Scanner;

/*
 * 백준 2941 - 크로아티아 알파벳
 * 
 * ->  String 으로 받아 조건마다 처리를 해줌. 인풋이 -,=만 들어오는 경우도 생각해줘야함
 * ->  i를 증가시키는 것을 까먹은 조건들이 있어서 여러번 제출하게 됨
 */
public class Main_2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		int count = 0;
		for (int i = 0; i < msg.length(); i++) {
			char ch = msg.charAt(i);
			char ch2 = '0';
			if (i + 1 < msg.length()) {
				ch2 = msg.charAt(i + 1);
			}
			if (ch == 'c' && (ch2 == '-' || ch2 == '=')) {
				i++;
				count++;
			} else if (ch == 's' && ch2 == '=') {
				i++;
				count++;
			} else if (ch == 'z' && ch2 == '=') {
				i++;
				count++;
			} else if (ch == 'l' && ch2 == 'j') {
				i++;
				count++;
			} else if (ch == 'n' && ch2 == 'j') {
				i++;
				count++;
			} else if (ch == 'd' && ch2 == '-') {
				i++;
				count++;
			} else if (ch == 'd' && ch2 == 'z') {
				if (i + 2 >= msg.length()) {
					count += 2;
					i++;
					continue;
				}

				if (msg.charAt(i + 2) == '=') {
					count++;
					i += 2;
				} else {
					i += 2;
					count += 3;
				}
			} else if ('a' <= ch && ch <= 'z') {
				count++;
			}
		}
		System.out.println(count);
	}
}
