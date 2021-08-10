package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 	요세푸스 문제는 다음과 같다.
	1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

 	->처음에 배열로 하려다가 너무 복잡해서 큐를 사용해서 앞에꺼를 뽑아서 뒤로 붙이고 빼고 다시 넣는 방식으로 함
 */
public class Main_1158 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int K= sc.nextInt();
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		System.out.print("<");
		while(!queue.isEmpty()) {
			for(int i= 0; i<K-1; i++) {
				queue.offer(queue.poll());
			}
			if(queue.size()==1) {
				System.out.print(queue.poll());
			}else System.out.print(queue.poll()+", ");
		}
		System.out.print(">");
		sc.close();
	}
}
