package java. java.baekjoon;

import java.util.Scanner;

public class Main_1062 {
	static int N, K, ans;
	static String[] words;
	static boolean[] isRead;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();
		words = new String[N];
		isRead = new boolean[26];

		for (int i = 0; i < N; i++) {
			String word = sc.nextLine();
			word = word.substring(4, word.length() - 4);
			words[i] = word;
		}

		if (K < 5)
			System.out.println("0");
		else if (K == 26)
			System.out.println(N);
		else {
			ans = Integer.MIN_VALUE;
			isRead['a' - 'a'] = true;
			isRead['n' - 'a'] = true;
			isRead['t' - 'a'] = true;
			isRead['i' - 'a'] = true;
			isRead['c' - 'a'] = true;

			read(0, 0);
			System.out.println(ans);
		}
		sc.close();
	}

	private static void read(int start, int cnt) {
		if (cnt == K - 5) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				for (int j = 0; j < words[i].length(); j++) {
					if (!isRead[words[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag)
					sum++;
			}
			ans = Math.max(ans, sum);

			return;
		}

		for (int i = start; i < 26; i++) {
			if (isRead[i] == false) {
				isRead[i] = true;
				read(i, cnt + 1);
				isRead[i] = false;
			}
		}

	}

}
