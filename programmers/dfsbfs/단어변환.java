package programmers.dfsbfs;

public class 단어변환 {
    static int ans;
    static String result;
    static String[] arr;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        ans = 0;
        boolean check = false;
        arr = new String[words.length];
        visited = new boolean[words.length];
        arr = words;
        result = target;
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])) check =true;
        }
        if(check){
            ans = Integer.MAX_VALUE;
            dfs(0,begin);
        }
        return ans;
    }
    public static void dfs(int cnt,String s){
        if(s.equals(result)){
            ans = Math.min(ans,cnt);
            return;
        }
        int index =0;     
        for(int i=0; i<arr.length; i++){
            int count = 0;
            for(int j =0; j<s.length(); j++){
                if(s.charAt(j)!= arr[i].charAt(j)){
                    index = i;
                    count++;
                    if(count == 2) break;
                }
            }
            if(count==1){
                if(!visited[index]){
                    visited[index]= true;
                    s = arr[index];
                    dfs(cnt+1,s);
                }
            }
        }
        
    }
}