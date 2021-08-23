package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * SWEA 1238 Contact
 * 
 * -> 마지막 bfs를 찾는 방법을 구하는게 어려웠음. bfs로 내려가기 때문에 한쪽방향만 true로 해줌
 * -> bfs 함수의 visited를 boolean으로 구현을 했는데 마지막에 방문한 것을 체크하기 위해서 int 배열로 해주고
 * -> 처음 방문을 1로 하고 visited[i]: 다음 방문할 곳에 visited[current] 현재의 +1을 해주는 방식으로 구현.
 * -> Node클래스를 만들어서 클래스안에 깊이를 해서도 구현할 수 있지만 배열을 사용했음.
 */
public class D4_Solution_1238 {
	static int N, result;
	static boolean[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			int start = sc.nextInt();
			arr = new boolean[N + 1][N + 1];
			for (int i = 0; i < N / 2; i++) {
				arr[sc.nextInt()][sc.nextInt()] = true;
			}
			result = Integer.MIN_VALUE;
			bfs(start);
			System.out.println("#"+t + " " + result);
		}
		sc.close();

	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] visited = new int[N + 1];
		int index = 0;
		queue.offer(start);
		visited[start] = 1;
		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 1; i < N + 1; i++) {
				if (visited[i] == 0 && arr[current][i]) {
					visited[i] = visited[current] + 1;
					queue.offer(i);
				}
			}
			index = visited[current];
		}
//		System.out.println(index);
//		System.out.println(Arrays.toString(visited));
		for (int i = 0; i < N + 1; i++) {
			if (index == visited[i])
				result = Math.max(result, i);
		}

	}

}
