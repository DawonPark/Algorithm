package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
/*
 * 	    백준 캐슬 디펜스 (https://www.acmicpc.net/problem/17135)
 * 
 * -> list가 가변적 remove인걸 생각안하고 코딩을 했다가 너무 돌아서 시간도 많이 걸렸음.
 *    배열의 안의 값으로 지우려해도 객체로 넘어가니까 어떻게 해야할지 모르겠어서 지우는 방법을 set에서 배열로 가져오고
 *    정렬을 한후에 list에서 지우면서 index를 하나씩 줄이는 방법을 선택하게됨
 * -> 주소값을 넘긴다는 것을 잘 생각해야된다고 느껴짐
 * 
 */

public class Main_17135 {
	static int N, M, D;
	static ArrayList<int[]> enemy = new ArrayList<int[]>();
	static ArrayList<int[]> tempList = new ArrayList<int[]>();
	static boolean[] isAlive;
	static int[] archer = new int[3];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data[] = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		D = Integer.parseInt(data[2]);
		for (int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				if (Integer.parseInt(data[j]) == 1)
					enemy.add(new int[] { i, j });
			}
		}
		tempList = (ArrayList<int[]>) enemy.clone();

		result = 0;
		combi(0, 0);
		System.out.println(result);

	}

	static void combi(int start, int cnt) {
		if (cnt == 3) {
			attack();
			return;
		}
		for (int i = start; i < M; i++) {

			archer[cnt] = i;
			combi(i + 1, cnt + 1);
		}
	}

	private static void attack() {
		int temp = 0;
		enemy = (ArrayList<int[]>) tempList.clone();
		for (int k = 0; k < N; k++) {
			int[] die = { -1, -1, -1 };
			HashSet<Integer> hs = new HashSet<>();
			for (int i = 0; i < 3; i++) {// 3번의 공격
				int x = -1;
				int y = -1;
				int distance = Integer.MAX_VALUE;
				int tempDistance = 0;
				int idx = -1;
				for (int j = 0; j < enemy.size(); j++) {
					if (N - (enemy.get(j)[0] + k) <= 0) {
						continue;
					}
					tempDistance = Math.abs((N - (enemy.get(j)[0] + k))) + Math.abs(archer[i] - enemy.get(j)[1]);
					if (tempDistance <= D) {
						if (tempDistance < distance) {
							x = enemy.get(j)[0] + k;
							y = enemy.get(j)[1];
							distance = tempDistance;
							idx = j;
						}
						if (tempDistance == distance) {
							if (y > enemy.get(j)[1]) {
								y = enemy.get(j)[1];
								idx = j;
							}
						}
					}
				}

				if (x != -1 && y != -1 && idx != -1) {
					hs.add(idx);
				}
				x = -1;
				y = -1;
				idx = -1;
			}

			temp += hs.size();
			Iterator iter = hs.iterator();
			int arr[] = new int[hs.size()];
			int i = 0;
			while (iter.hasNext()) {
				arr[i++] = (int) iter.next();
			}
			Arrays.sort(arr);
			for (int j = 0; j < arr.length; j++) {
				enemy.remove(arr[j] - j);
			}

		}

		result = Math.max(temp, result);
	}

}
