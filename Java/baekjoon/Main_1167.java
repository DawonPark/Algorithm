package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1167 {
//	static int[][] dist;
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int N,ans,end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++) list[i] = new ArrayList<>();
		visited = new boolean[N+1];
		for(int i =0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			for(int j=1; j<s.length - 2; j+=2) {
				list[Integer.parseInt(s[0])].add(new Node(Integer.parseInt(s[j]), Integer.parseInt(s[j+1])));
//				dist[Integer.parseInt(s[0])][Integer.parseInt(s[j])] = Integer.parseInt(s[j+1]);
			}
		}
		ans = 0;
		visited[1] = true;
		dfs(1,0);
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				System.out.print(dist[i][j] + " ");
//			}
//			System.out.println();
//		}
		visited = new boolean[N+1];
		visited[end] = true;
		dfs(end,0);
		System.out.println(ans);
	}
	private static void dfs(int node, int sum) {
		if(sum >ans) {
			end = node;
			ans = sum;
		}
//		System.out.println(node);
		for(int i=0; i<list[node].size(); i++) {
			Node n = list[node].get(i);
			if(!visited[n.idx]) {
				visited[n.idx] = true;
				dfs(n.idx,sum+n.cost);
			}
		}
		
	}
	static class Node {
		int idx, cost;
		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
