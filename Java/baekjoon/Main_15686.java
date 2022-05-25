package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*	문제 설명이 길어 링크
 *  백준 치킨 배달(https://www.acmicpc.net/problem/15686)
 *  
 *  -> 처음에 수익을 많이 내는 최대 M개에서 완전탐색으로 하지않고 구하는 방법을 찾다가 아닌 것 같아서 완전탐색으로 선택을 하고
 *     치킨거리 계산은 순서가 상관없어 조합을 선택함
 *  -> 과정은 전체 배열 입력 받고 -> 치킨집을 list 에 담아줌(리스트 사용은 치킨집이 몇개인지 안주기 때문에 가변적이라 사용)
 *  -> 조합에서 리스트 개수를 이용하여 select 배열에 저장을 해줌 -> 계산은 집이 있을때 가장 가까운 치킨 거리를 계산해서 더 해주고 경우마다 다른 result 비교 
 */
public class Main_15686 {
	static int[][] map;
	static int M;
	static int N;
	static int K;
	static int result;
	static List<Pair> list;
	static int[][] select;

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		StringTokenizer st = null;
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		select = new int[M][2];
		map = new int[N][N];
		list = new ArrayList<Pair>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					list.add(new Pair(i, j));
					K++;
				}
			}
		}
		result = Integer.MAX_VALUE;
		combination(0, 0);
		System.out.println(result);

	}

	static void combination(int start, int cnt) {
		if (cnt == M) {
			cal();
			return;
		}
		for (int i = start; i < K; i++) {
			select[cnt][0] = list.get(i).x;
			select[cnt][1] = list.get(i).y;
			combination(i + 1, cnt + 1);
		}
	}

	static void cal() {
		int distance = Integer.MAX_VALUE;
		int tempResult = 0;

		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (map[x][y] == 1) {
					distance = Integer.MAX_VALUE;
					for (int i = 0; i < select.length; i++) {
						int temp = 0;
						int r = select[i][0];
						int c = select[i][1];
						temp = Math.abs(x - r) + Math.abs(y - c);
						distance = Math.min(temp, distance);
					}
					tempResult += distance;
				}
			}
		}
		result = Math.min(tempResult, result);
	}
}
