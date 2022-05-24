package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1966 {
	static class Node {
		int idx;
		int priority;
		public Node(int idx, int priority) {
			super();
			this.idx = idx;
			this.priority = priority;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0 ; t<T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int ans = 1;
			LinkedList<Node> queue =new LinkedList<>();
			for(int i=0; i<N; i++) {
				queue.add(new Node(i,sc.nextInt()));
			}
			while(!queue.isEmpty()) {
				int max = queue.get(0).priority;
				int idx = 0;
				for(int i=1; i<queue.size(); i++) {
					if(queue.get(i).priority > max) {
						max = queue.get(i).priority;
						idx = i;
					}
				}
				if(idx !=0) {
					Node node = queue.remove(idx);
					if(node.idx == M) break;
					for(int i=0; i<idx; i++) {
						node = queue.poll();
						queue.offer(node);
					}
				}else {
					Node node = queue.remove(idx);
					if(node.idx==M) break;
				}
				ans++;
			}
			System.out.println(ans);
		}
	}
}
