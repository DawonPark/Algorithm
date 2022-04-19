package programmers;

public class 순위 {
	 public int solution(int n, int[][] results) {
	        int answer = 0;
	        boolean[][] visited = new boolean[n+1][n+1];
	        for(int i=0; i<results.length; i++){
	            visited[results[i][0]][results[i][1]] = true;
	        }
	        for(int i= 1; i<visited.length; i++){ // 경
	            for(int j = 1; j<visited.length; j++) { // 출
	                for(int k = 1; k<visited.length; k++ ) {// 도
	                    if(visited[j][i] && visited[i][k]) visited[j][k] = true;
	                }
	            }
	        }
	        
	        for(int i=1; i<=n; i++){
	            int cnt = 0;
	            for(int j=1; j<=n; j++){
	                if(visited[i][j] || visited[j][i]) cnt++;
	            }
	            if(cnt == n-1) answer++;
	        }
	        
	        return answer;
	    }
}
