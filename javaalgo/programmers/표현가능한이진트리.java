package javaalgo.programmers;
import java.util.*;

public class 표현가능한이진트리 {
	class Solution {
	    static int[] num;
	    static boolean res;
	    public void dfs(int s, int e, boolean flag){
	        int mid = (s + e) / 2;
	        if(flag && num[mid] == 1){
	            res = true;
	            return;
	        }
	        if(s != e){
	            boolean check = num[mid] == 1 ?  false : true ; 
	            dfs(s, mid - 1, check);
	            dfs(mid + 1, e, check);
	        }
	    }
	    public int[] solution(long[] numbers) {
	        int[] answer = new int[numbers.length];
	        for(int i = 0; i < numbers.length; i++){
	            int len =(int) Math.floor(Math.log(numbers[i]) / Math.log(2)) + 1;
	            int treeLen = 0;
	            int n = 1;
	            while(len > treeLen){
	                treeLen = (int) Math.pow( 2, n++) - 1;
	            }
	            // 0101010 -> 2 8 32 
	            num = new int[treeLen];
	            int idx = treeLen -1;
	            long n1 = numbers[i];
	            while( n1 != 0){
	                long k = n1 % 2;
	                if(k == 1) num[idx--] = 1;
	                else num[idx--] = 0;
	                n1 /= 2;
	            }
	            res = false;
	            dfs(0,treeLen - 1,false);
	            if(!res) answer[i] = 1;
	            else answer[i] = 0;
	        }
	        return answer;
	    }
	}
}
