package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
outer: for (int t = 1; t <= T; t++) {
			String s = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if (ch == '(') stack.push(ch);
				else if (ch == ')' && stack.isEmpty()) {
					System.out.println("NO");
					continue outer;
				} else if (ch == ')' && !stack.isEmpty()) {
					stack.pop();
				}
			}
			String ans = stack.isEmpty() ? "YES" : "NO";
			System.out.println(ans);

		}
		sc.close();
	}
}
