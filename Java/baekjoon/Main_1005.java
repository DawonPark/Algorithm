package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_1005 {
	static int N, K;
	static int[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String[] data = br.readLine().split(" ");
			N = Integer.parseInt(data[0]);
			K = Integer.parseInt(data[1]);
			time = new int[N + 1];
			List<Integer>[] list = new ArrayList[N + 1];
			int[] indegree = new int[N + 1];
			data = br.readLine().split(" ");
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
				time[i] = Integer.parseInt(data[i - 1]);
			}
			for (int i = 0; i < K; i++) {
				data = br.readLine().split(" ");

				int start = Integer.parseInt(data[0]);
				int end = Integer.parseInt(data[1]);

				list[start].add(end);
				indegree[end]++;

			}

			int W = Integer.parseInt(br.readLine());
			solve(indegree, list, W);
		}
	}

	public static void solve(int[] indegree, List<Integer>[] list, int W) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				result[i] = time[i];
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int k : list[current]) {
				result[k] = Math.max(result[current] + time[k], result[k]);
				indegree[k]--;
				if (indegree[k] == 0)
					queue.offer(k);
			}
		}
		System.out.println(result[W]);
	}
}