package programmers.dfsbfs;

public class 네트워크 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        N = n;
        arr = new int[n][n];
        arr = computers;
        visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i]= true;
                answer++;
                dfs(i);
            }
        }

        return answer;
    }
    
    
    public static void dfs(int start){
            for(int i=0; i<N; i++){
                if(!visited[i] && arr[start][i] ==1) {
                    visited[start] = true;
                    dfs(i);
                }
                
            }
        }
        
}