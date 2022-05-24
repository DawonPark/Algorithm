package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D4_Solution_3124 {
	static class Edge{
		int start , weight, end;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", weight=" + weight + ", end=" + end + "]";
		}
	}
	
	static int[] parents;
	static int V,E;
	static Edge[] edgeList;
	static void make() {
		parents = new int[V+1];
		for(int i=1; i<=V; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t =1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];
			for(int i=0; i<E; i++) {
				st= new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start,end,weight);
			}
			
			
			make();
			Arrays.sort(edgeList, (a,b) -> Integer.compare(a.weight, b.weight));
			int cnt =0;
			long result=0;
			for(Edge e : edgeList) {
				if(union(e.start,e.end)) {
					result+= e.weight;
					if(++cnt == V-1)break;
				}
			}
			
			System.out.println("#"+t+" " + result);
			
		}
	}
}
