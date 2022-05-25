package java. java.programmers;

public class 카카오프렌즈컬러링북 {
	    
	    static int[] dx = {0,0,-1,1};
	    static int[] dy = {1,-1,0,0};
	    static int numberOfArea, maxSizeOfOneArea, M,N ,sum;
	    public int[] solution(int m, int n, int[][] picture) {
	        N = n; M = m;
	        
	        numberOfArea = 0;
	        maxSizeOfOneArea = 0; 
	        sum= 0;
	        int[][] copy = new int[picture.length][picture[0].length];
	        for(int i=0; i<copy.length; i++){
	            copy[i] = picture[i].clone();
	        }
	        
	        for(int i=0; i<m; i++){
	            for(int j=0; j<n; j++){
	                if(copy[i][j] == 0) continue;
	            
	                sum = 1;
	                dfs(i,j,copy);
	                numberOfArea++;
	                if(sum > maxSizeOfOneArea) maxSizeOfOneArea = sum;
	            }
	        }
	        
	        
	        
	        int[] answer = new int[2];
	        answer[0] = numberOfArea;
	        answer[1] = maxSizeOfOneArea;
	        return answer;
	    }
	    
	    public void dfs(int x, int y, int[][] map){
	        int temp = map[x][y];
	        map[x][y] = 0;        
	        for(int d =0; d<4; d++){
	            int nx = x+dx[d];
	            int ny = y+dy[d];
	            if(nx <0 || nx>=M || ny<0 || ny>=N) continue;
	            if(temp == map[nx][ny]){
	                sum++;
	                dfs(nx,ny,map);
	            }
	        }
	        
	        
	    } 
	    
	    
}
