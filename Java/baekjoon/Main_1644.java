package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1644 {
	public static void main(String[] args) throws IOException {
		boolean prime[];
		ArrayList<Integer> list = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		prime = new boolean[N + 1];
		prime[0] = true;
		prime[1] = true;
		// 소수가 되는 수의 배수를 지우면 남은 건 소수 (에라토스테네스의 체)
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!prime[i])
				list.add(i);
		}

		// 2. 연속합으로 주어진 정수 구할 수 있는지 판별
		int start = 0, end = 0, sum = 0, count = 0;
		while (true) {
			if (sum >= N)
				sum -= list.get(start++);
			else if (end == list.size())
				break;
			else
				sum += list.get(end++);
			if (N == sum)
				count++;
		}
		System.out.println(count);
	}
}