package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	매일 매일 일곱 난쟁이는 광산으로 일을 하러 간다. 난쟁이가 일을 하는 동안 백설공주는 그들을 위해 저녁 식사를 준비한다. 
 	백설공주는 의자 일곱개, 접시 일곱개, 나이프 일곱개를 준비한다.
 	어느 날 광산에서 아홉 난쟁이가 돌아왔다. (왜 그리고 어떻게 아홉 난쟁이가 돌아왔는지는 아무도 모른다) 
	아홉 난쟁이는 각각 자신이 백설공주의 일곱 난쟁이라고 우기고 있다.백설공주는 이런 일이 생길 것을 대비해서, 
	난쟁이가 쓰고 다니는 모자에 100보다 작은 양의 정수를 적어 놓았다. 사실 백설 공주는 공주가 되기 전에 매우 유명한 수학자였다. 
	따라서, 일곱 난쟁이의 모자에 쓰여 있는 숫자의 합이 100이 되도록 적어 놓았다.
	아홉 난쟁이의 모자에 쓰여 있는 수가 주어졌을 때, 일곱 난쟁이를 찾는 프로그램을 작성하시오
 * 
 * -> 순서가 상관이 없이 100을 만드는 7명이 있다 -> 조합
 */
public class Main_3040 {
	static int[] dwarfs;
	static int[] answer;
	static int R = 7;
	static int N = 9;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dwarfs = new int[N];
		answer = new int[R];
		for (int i = 0; i < N; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		combi(0, 0);
	}

	static void combi(int start, int cnt) {
		if (cnt == R) {
			int result = 0;
			for (int i = 0; i < R; i++) {
				result += dwarfs[answer[i]];
			}
			if (result == 100) {
				for (int i = 0; i < R; i++) {
					System.out.println(dwarfs[answer[i]]);
				}
			}
			return;
		}

		for (int i = start; i < N; i++) {
			answer[cnt] = i;
			combi(i + 1, cnt + 1);
		}
	}

}
