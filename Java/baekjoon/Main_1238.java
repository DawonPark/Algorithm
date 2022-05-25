package java. java.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1238 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Node>> list = new ArrayList<>();
		ArrayList<ArrayList<Node>> reverseList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
			reverseList.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list.get(start).add(new Node(end, cost));
			reverseList.get(end).add(new Node(start, cost));
		}
		int[] dist = new int[N + 1];
		int[] reverseDist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(reverseDist, Integer.MAX_VALUE);
		dijkstra(X, dist, list);
		dijkstra(X, reverseDist, reverseList);
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dist[i] + reverseDist[i]);
		}
		System.out.println(ans);
	}

	private static void dijkstra(int x, int[] dist, ArrayList<ArrayList<Node>> list) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x, 0));
		dist[x] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (visited[node.end])
				continue;
			visited[node.end] = true;
			for (Node n : list.get(node.end)) {
				if (dist[n.end] > dist[node.end] + n.cost) {
					dist[n.end] = dist[node.end] + n.cost;
					pq.add(new Node(n.end, dist[n.end]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int end, cost;

		Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
}
