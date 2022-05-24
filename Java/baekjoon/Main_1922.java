package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922 {
	
	static class Edge implements Comparable<Edge> {

		int start,end,weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
		
	}
	
	static int[] parents;
	static int N, M;
	static Edge[] edgeList;
	
	private static void make() {
		parents = new int[N+1];
		for(int i=0; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		edgeList = new Edge[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i] = new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(edgeList);
		make();
		
		int cnt =0, result = 0;
		
		for(Edge edge : edgeList) {
			if(union(edge.start, edge.end)) {
				result += edge.weight;
				if(++cnt==N) break;
			}
		}
		
		System.out.println(result);
		
	}
}
