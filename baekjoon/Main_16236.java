package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 백준 16236 아기 상어
 * 
 * -> 최단 경로를 구할 때는 bfs를 사용해야함. -> int[][] vistied 배열로 거리를 측정하고 처음 걸린 자리에서 bfs를 재귀로 부르면 될 줄 알았는데 테케 한개가 안됬음
 * ->   00901 -> 이경우에 오른쪽으로 상어가 오른쪽 1 을 먹어야하는데 왼쪽 아래로 가게 됨 -> 재귀 사용 불가능
	    01000
   -> 잡을  수 있는 물고기들을 담고 내림차순 sort하고 하나씩 제거함.
   -> 추가적으로 상어는 9로 주어지는데 인덱스를 잡고 0으로 셋팅해야 지나다닐 수 있음.
 */
public class Main_16236 {
	static int map[][];
	static int count, N, size, ans;
	static int[] dx = { -1, 0, 0, 1 };// 상 좌 우 하
	static int[] dy = { 0, -1, 1, 0 };

	static class Pair {
		int x, y , d;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public Pair(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		size = 2;
		count = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[i][j] = 0;
				}
			}
		}
		bfs(x, y);
		System.out.println(ans);

	}

	// 거리가 가까우면 위에 있는 물고기, 위에 있는 것도 여러마리면 왼쪽부터 -> 위로 뻗으면서 bfs + 왼쪽부터 살피기
	static void bfs(int x, int y) {

		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(x, y));

		while (true) {
			int isVisited[][] = new int[N][N];
			ArrayList<Pair> list = new ArrayList<>(); // -> 그 시점에 잡을 수  물고기들 리스트
			if(count == size) {
				size++;
				count =0;
			}
			while (!queue.isEmpty()) {
				Pair current = queue.poll();
				/*
				 * 00901 -> bfs안에 재귀를 돌리면 문제가 생기는 경우 -> 재귀 사용 불가능 거리가 같을 때 문제
				 * 01000
				 * 
				 */
				for (int d = 0; d < 4; d++) {
					int nx = current.x + dx[d];
					int ny = current.y + dy[d];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;

					if (isVisited[nx][ny] == 0 && map[nx][ny] <= size) {
						isVisited[nx][ny] = isVisited[current.x][current.y] + 1;
						queue.offer(new Pair(nx, ny));
					}
					if (map[nx][ny] > 0 && map[nx][ny] < size) { // 먹을 수 있다면

						list.add(new Pair(nx,ny,isVisited[nx][ny]));

					}
				}

			}
			if(list.isEmpty()) {
				return;
			}
			
			Collections.sort(list, (a,b)-> {
				if(a.d== b.d) {	// 거리가 같으면 문제점의 정렬을 해야함.
					if (a.x == b.x) { // 같이 위쪽에 있으면
						return a.y - b.y; // 왼쪽 부터 -> 내림차순
					}
					return a.x - b.x; // 아니면 위쪽 부터 -> 내림차순
				}
				else return a.d - b.d;
			});
			
			ans+= list.get(0).d;
			count++;
			map[list.get(0).x][list.get(0).y]=0;
			
			queue.add(new Pair(list.get(0).x, list.get(0).y));
			
		}
		

	}

}
