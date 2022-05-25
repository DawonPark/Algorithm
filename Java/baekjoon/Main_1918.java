package java. java.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1918 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		Stack<Character> ops = new Stack<>();
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				System.out.print(ch);
			else {
				if (ch == '(')
					ops.push(ch);
				else if (ch == ')') {
					while (!ops.empty() && ops.peek() != '(')
						System.out.print(ops.pop());
					ops.pop();
				} else {
					while (!ops.isEmpty() && priority(ops.peek()) >= priority(ch)) {
						System.out.print(ops.pop());
					}
					ops.push(ch);
				}
			}
		}
		while (!ops.isEmpty())
			System.out.print(ops.pop());
	}

	private static int priority(char ch) {
		if (ch == '-' || ch == '+')
			return 1;
		else if (ch == '*' || ch == '/')
			return 2;
		return 0;
	}

}
