package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_1753 {
	static class Node {
		int idx;
		int cost;
		Node(int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int V = Integer.parseInt(data[0]);
		int E = Integer.parseInt(data[1]);
		int start = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Node>> matrix = new ArrayList<ArrayList<Node>>();
		for(int i =0; i<=V; i++) {
			matrix.add(new ArrayList<>());
		}
		
		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		for(int i=0; i<E; i++) {
			data = br.readLine().split(" ");
			int s = Integer.parseInt(data[0]);;
			int e = Integer.parseInt(data[1]);;
			int w = Integer.parseInt(data[2]);;
			matrix.get(s).add(new Node(e,w));
		}
		final int INFINITY = Integer.MAX_VALUE;
		Arrays.fill(distance,INFINITY);
		distance[start] = 0;
		
		int min =0, current =0;
		for(int i=0; i<V; i++) {
			min = INFINITY;
			for(int j=1; j<=V; j++) {
				if(!visited[j]&& distance[j]<min) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			
			for(int j=0; j<matrix.get(current).size(); j++) {
				Node node = matrix.get(current).get(j);
				if(distance[node.idx] > distance[current] + node.cost) {
					distance[node.idx] = distance[current] + node.cost;
				}
			}
		}
		for(int i=1; i<=V; i++) {
			if(distance[i] == INFINITY) System.out.println("INF");
			else System.out.println(distance[i]);
		};
	
		
	}
}
