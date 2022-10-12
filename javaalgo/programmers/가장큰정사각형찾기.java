package javaalgo.programmers;
import java.util.*;

public class 가장큰정사각형찾기 {
	    public int solution(int [][]board)
	    {
	        int answer = 0;
	        int R = board.length;
	        int C = board[0].length;
	        int[][] map = new int[R+1][C+1];
	        
	        for(int i = 0; i < R; i++){
	            for(int j = 0; j < C; j++){
	                map[i+1][j+1] = board[i][j];
	            }
	        }
	        
	        for(int i = 1; i <= R; i++){
	            for(int j = 1; j <= C; j++){
	                if(map[i][j] == 1){
	                    map[i][j] = Math.min(Math.min(map[i-1][j], map[i-1][j-1]), map[i][j-1]) + 1;
	                    answer= Math.max(answer, map[i][j]);
	                }
	            }
	        }

	        return answer * answer;
	    }
}
