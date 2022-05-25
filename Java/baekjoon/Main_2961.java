package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  도영이는 짜파구리 요리사로 명성을 날렸었다. 이번에는 이전에 없었던 새로운 요리에 도전을 해보려고 한다.
	지금 도영이의 앞에는 재료가 N개 있다. 도영이는 각 재료의 신맛 S와 쓴맛 B를 알고 있다. 여러 재료를 이용해서 요리할 때, 
	그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합이다.시거나 쓴 음식을 좋아하는 사람은 많지 않다. 
	도영이는 재료를 적절히 섞어서 요리의 신맛과 쓴맛의 차이를 작게 만들려고 한다.
 	또, 물을 요리라고 할 수는 없기 때문에, 재료는 적어도 하나 사용해야 한다.
	재료의 신맛과 쓴맛이 주어졌을 때, 신맛과 쓴맛의 차이가 가장 작은 요리를 만드는 프로그램을 작성하시
 * 
 * -> 1개 이상 선택해야함. 주어진 모든 조합을 고름 -> 부분 집합
 * -> 부분집합을 재귀(주석처리함) 와 바이너리 카운팅으로 구현
 */
public class Main_2961 {
	static int N;
	static int[][] dish;
	static boolean isSelected[];
	static int result;

	private static void subset(int cnt) {
		if (cnt == N) {
			int sour = 1;
			int bitter = 0;
			int select = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i] == true) {
					sour *= dish[i][0];
					bitter += dish[i][1];
					select++;
				}
			}
			if (select == 0) {
				return;
			}
			result = Math.min(Math.abs(sour - bitter), result);
			return;
		}

		isSelected[cnt] = true;
		subset(cnt + 1);
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		dish = new int[N][2];
		isSelected = new boolean[N];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dish[i][0] = Integer.parseInt(st.nextToken());
			dish[i][1] = Integer.parseInt(st.nextToken());
		}
//		subset(0);
		for (int i = 1; i < 1 << N; i++) {
			int sour = 1;
			int bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sour *= dish[i - 1][0];
					bitter += dish[i - 1][1];
				}
			}
			result = Math.min(Math.abs(sour - bitter), result);
		}
		System.out.println(result);
	}
}
