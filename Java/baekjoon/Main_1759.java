package java. java.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 1759 암호만들기
 * 
 * sort를 한 후 -> C만큼의 순열을 만들고 자음 모음 체크를 해줌
 */
public class Main_1759 {
	static char[] encode, decode;
	static int L, C;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		String msg = sc.nextLine().replace(" ", "");
		encode = msg.toCharArray();
		Arrays.sort(encode);
		decode = new char[C];
		solve(0, 0);
		sc.close();
	}

	static void solve(int cnt, int start) {
		if (cnt == L) {
			int check1 = 0;
			int check2 = 0;

			for (int i = 0; i < L; i++) {
				char ch = decode[i];
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
					check1++; // 최소 한개의 모음
				else
					check2++; // 자음 카운트
			}
			if (check1 < 1 || check2 < 2)
				return;

			for (int i = 0; i < L; i++) {
				System.out.print(decode[i]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i < C; i++) {
			decode[cnt] = encode[i];
			solve(cnt + 1, i + 1);
		}

	}

}
