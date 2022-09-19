package javaalgo.programmers.정렬;
import java.util.*;

public class H_Index {
	  public int solution(int[] citations) {
	        Arrays.sort(citations);
	        int answer = 0;
	        
	        for(int i=0; i<citations.length; i++){
	            if(citations[i]>=citations.length-i && citations[i]>=i ) {
	                answer = citations.length-i;
	                break;
	            }
	        }
	    
	        return answer;
	    }
}
