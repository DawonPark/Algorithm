package baekjoon;

import java.util.Scanner;

public class Main_1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int ans = 0;
 outer: for (int i = 0; i < N; i++) {
			String msg = sc.nextLine();
			boolean[] check = new boolean[26];
			char ch = msg.charAt(0);
			check[ch - 'a'] = true;
			for (int j = 1; j < msg.length(); j++) {
				if (ch == msg.charAt(j))
					continue;
				else {
					if (check[msg.charAt(j) - 'a'])
						continue outer;
					check[msg.charAt(j) - 'a'] = true;
					ch= msg.charAt(j);
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}
