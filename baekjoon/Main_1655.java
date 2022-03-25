package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int K = Integer.parseInt(br.readLine());
			if(maxHeap.size() == minHeap.size()) {
				if(!minHeap.isEmpty() && K > minHeap.peek()) {
					maxHeap.offer(minHeap.poll());
					minHeap.offer(K);
				}else maxHeap.offer(K);
			}
			else {
				if(K < maxHeap.peek()) {
					minHeap.offer(maxHeap.poll());
					maxHeap.offer(K);
				}else minHeap.offer(K);
			}
			sb.append(maxHeap.peek()+"\n");
		}
		System.out.println(sb);
	}
}
