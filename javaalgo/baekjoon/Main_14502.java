package javaalgo.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_14502 {
	static int N = 0;
	static int M = 0;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int ans, area;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		M = Integer.parseInt(data[1]);
		map = new int[N][M];
		list = new LinkedList<>();
		area = 0;
		for(int i = 0; i < N; i++) {
			data = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(data[j]);
				if(map[i][j] == 2) list.add(new int[] {i,j}); 
				if(map[i][j] == 0) area++;
			}
		}
		
		ans = Integer.MIN_VALUE;
		go(0);
		System.out.println(ans);
	}
	
	public static void go(int cnt) {
		if(cnt == 3) {
			int temp = area - 3;
			Queue<int[]> queue = new LinkedList<>();
			for(int i = 0; i < list.size(); i++) {
				queue.add(list.get(i));
			}
			boolean[][] visited = new boolean[N][M];
			while(!queue.isEmpty()) {
				int[] data = queue.poll();
				visited[data[0]][data[1]] = true;
				for(int d = 0; d < 4; d++) {
					int nx = data[0] + dx[d];
					int ny = data[1] + dy[d];
					if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
					if(map[nx][ny] !=0 || visited[nx][ny]) continue;
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					temp--;
				}
			}
			ans = Math.max(ans, temp);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1; 
					go(cnt + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
}
