package java. programmers.스택큐;

import java.util.Stack;

public class 주식가격 {
	 public int[] solution(int[] prices) {
	        int[] ans = new int[prices.length];
	        Stack<Integer> stack = new Stack<>();
	        for(int i =0; i<prices.length; i++){
	            while (!stack.isEmpty()&&prices[i] < prices[stack.peek()]){
	                int idx = stack.pop();
	                ans[idx] = i-idx;     
	            }
	            stack.push(i);
	        }
	        while(!stack.isEmpty()){
	            int idx = stack.pop();
	            ans[idx] = prices.length - (idx+1); 
	        }
	        

	        return ans;
	    }
}
