package javaalgo.programmers;
import java.util.*;

public class 무인도여행 {
	class Solution {
	    public int[] solution(String[] maps) {
	        ArrayList<Integer> answer = new ArrayList<>();
	        int N = maps.length;
	        int M = maps[0].length();
	        char[][] map = new char[N][M];
	        boolean[][] visited = new boolean[N][M];

	        int[] dx = {0,0,-1,1};
	        int[] dy = {1,-1,0,0};
	        for(int i = 0; i < N; i++){
	            char[] arr = maps[i].toCharArray();
	            for(int j = 0; j < M; j++){
	                map[i][j] = arr[j];
	            }
	        }
	        for(int i = 0; i < N; i++){
	            for(int j = 0; j < M; j++){
	                if(map[i][j] == 'X' || visited[i][j]) continue;
	                Queue<int[]> queue = new LinkedList<>();
	                queue.offer(new int[]{i,j});
	                visited[i][j] = true;
	                int sum = map[i][j] - '0';
	                while(!queue.isEmpty()){
	                    int[] data = queue.poll();
	                    int x = data[0];
	                    int y = data[1];
	                    for(int d = 0; d < 4; d++){
	                        int nx = x + dx[d];
	                        int ny = y + dy[d];
	                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
	                        if(map[nx][ny] == 'X' || visited[nx][ny]) continue;
	                        sum += map[nx][ny] - '0';
	                        visited[nx][ny] = true;
	                        queue.offer(new int[]{nx,ny});
	                    }
	                }
	                answer.add(sum);
	            }
	        }
	        if(answer.size() == 0) return new int[]{-1};
	        int[] ans = new int[answer.size()];
	        Collections.sort(answer);
	        for(int i =0; i < ans.length; i++){
	            ans[i] = answer.get(i);
	        }
	        return ans;
	    }
	}
}
