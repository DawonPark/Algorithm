package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main_1707 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		outer: for (int t = 0; t < K; t++) {
			String[] data = br.readLine().split(" ");
			int V = Integer.parseInt(data[0]);
			int E = Integer.parseInt(data[1]);
			int[] isVisited = new int[V + 1];

			ArrayList<Integer>[] list = new ArrayList[V + 1];

			for (int i = 0; i <= V; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < E; i++) {
				data = br.readLine().split(" ");
				int start = Integer.parseInt(data[0]);
				int end = Integer.parseInt(data[1]);

				list[start].add(end);
				list[end].add(start);
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i <= V; i++) {
				if (isVisited[i] == 0) {
					queue.add(i);
					isVisited[i] = 1;
				}

				while (!queue.isEmpty()) {
					int start = queue.poll();

					for (int j = 0; j < list[start].size(); j++) {
						if (isVisited[list[start].get(j)] == 0) {
							queue.add(list[start].get(j));
						}
						if (isVisited[list[start].get(j)] == isVisited[start]) {
							System.out.println("NO");
							continue outer;
						}
						if (isVisited[start] == 1 && isVisited[list[start].get(j)] == 0)
							isVisited[list[start].get(j)] = 2;
						else if (isVisited[start] == 2 && isVisited[list[start].get(j)] == 0)
							isVisited[list[start].get(j)] = 1;
					}
				}
			}
			System.out.println("YES");

		}

	}
}
