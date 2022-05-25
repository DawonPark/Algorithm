package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main_5430 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		outer: for (int t = 0; t < T; t++) {
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			ArrayDeque<Integer> deque = new ArrayDeque<>();
			String s = br.readLine();
			String[] data = s.substring(1, s.length() - 1).split(",");
			for (int i = 0; i < n; i++) {
				deque.add(Integer.parseInt(data[i]));
			}
			boolean check = true;
			for (int i = 0; i < command.length(); i++) {
				if (command.charAt(i) == 'D') {
					if (check) {
						if (deque.pollFirst() == null) {
							System.out.println("error");
							continue outer;
						}
					} else {
						if (deque.pollLast() == null) {
							System.out.println("error");
							continue outer;
						}
					}

				} else {
					check = !check;
				}
			}

			System.out.print("[");
			if (deque.size() > 0) {
				if (check) {
					System.out.print(deque.pollFirst());
					while (!deque.isEmpty()) {
						System.out.print("," + deque.pollFirst());
					}
				} else {
					System.out.print(deque.pollLast());
					while (!deque.isEmpty()) {
						System.out.print("," + deque.pollLast());
					}
				}
			}
			System.out.println("]");
		}

	}
}
