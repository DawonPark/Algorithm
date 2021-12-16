package programmers;

public class N개의최소공배수 {
	class Solution {
	    public int solution(int[] arr) {
	        int answer = lcm(arr[0], arr[1]);
	        
	        for(int i=2; i<arr.length; i++){
	            answer = lcm(answer, arr[i]);
	        }
	        
	        return answer;
	    }
	    
	    public int gcd(int a,int b) {
	        while(b!=0){
	            int r = a%b;
	            a=b;
	            b=r;
	        }
	        return a;
	    }
	    
	    public int lcm(int a, int b){
	        return a*b/gcd(a,b);
	    }
	    
	    
	}
}
