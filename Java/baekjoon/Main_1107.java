package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1107 {
	static int ans = Integer.MAX_VALUE;
	static int N = 0;
	static boolean[] live;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		live = new boolean[10];
		if (M > 0) {
			String[] buttons = br.readLine().split(" ");
			for (int i = 0; i < M; i++) {
				live[Integer.parseInt(buttons[i])] = true;
			}
		}
		int ans = Math.abs(N - 100); // 모든 버튼이 고장 났을때를 위해

		for (int i = 0; i < 1000000; i++) {
			int sel = solve(i);
			if (sel > 0) {
				int cnt = Math.abs(N - i);
				ans = Math.min(ans, sel + cnt);
			}
		}
		System.out.println(ans);

	}

	static int solve(int n) {
		if (n == 0) {
			if (live[0]) {
				return 0;
			} else {
				return 1;
			}
		}
		int len = 0;
		while (n > 0) {
			if (live[n % 10]) {
				return 0;
			}
			n /= 10;
			len += 1;
		}
		return len;
	}
}
