package java. java.programmers;

public class 예상_대진표 {
	class Solution
	{
	    public int solution(int n, int a, int b)
	    {
	        int answer = 0;
	        
	        
	        while(a!=b){
	            answer++;
	            a= (a+1)/2;
	            b=(b+1)/2;
	        }
	        
	        return answer;
	    }
	}
}
