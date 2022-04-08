package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2252 {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] link = new int[N+1];
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
			link[b]++;
		}
		topologicalSort(list, link);
	}
	private static void topologicalSort(ArrayList<ArrayList<Integer>> list, int[] link) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			if(link[i] == 0) {
				queue.offer(i);
			}
		}
		
		for(int i=0; i<N; i++) {
			int node = queue.poll();
			System.out.print(node+ " ");
			for(int v : list.get(node)) {
				link[v]--;
				if(link[v] ==0) {
					queue.add(v);
				}
			}
		}
	}
}
