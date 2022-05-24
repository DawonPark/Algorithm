package programmers.dfsbfs;

public class 타겟넘버 {
	 static int[] arr;
	    static int t,answer;
	    static boolean[] visited;
	    public int solution(int[] numbers, int target) {
	        arr = new int[numbers.length];
	        arr = numbers;
	        t = target;
	        dfs(0,0);
	        return answer;
	    }
	    public static void dfs(int cnt ,int temp){
	        if(cnt == arr.length){
	            if(t == temp) answer++;
	            return;
	        }
	            dfs(cnt+1,temp+arr[cnt]);
	            dfs(cnt+1,temp-arr[cnt]);
	    }
}
