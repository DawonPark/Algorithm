package javaalgo.programmers.정렬;

import java.util.Arrays;

public class 가장큰수 {
	 public String solution(int[] numbers) {
		    String[] arr = new String[numbers.length];
	        for(int i=0; i<numbers.length; i++){
	            arr[i] = Integer.toString(numbers[i]);
	        }
	        String answer="";
	        Arrays.sort(arr,(a,b)->{
	            return (a+b).compareTo(b+a);
	        }); 
	        for(int i=arr.length-1; i>=0.; i--){
	            answer+=arr[i];
	        }
	        if(answer.charAt(0) == '0') answer = "0";
	        
	        return answer;
	    }
}
