package javaalgo.programmers;
import java.util.*;

class Solution {
    static int[] seats;
    static boolean[] visited;
    static int ans;
    static char[] characters ={'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        ans =0;
        visited = new boolean[8];
        seats = new int[8];
        pmt(0, data);
  
        return ans;
    }
    
    public static int search(char ch){
        for(int i=0; i<8; i++){
            if(seats[i] == Arrays.binarySearch(characters, ch)) return i;
        }
        return -1;
    }
    
    public static void pmt(int cnt,String[] data){
        if(cnt == 8){
            for(int i =0; i<data.length; i++){
                int start = search(data[i].charAt(0));
                int end = search(data[i].charAt(2));
  
                char con = data[i].charAt(3);
                int range = data[i].charAt(4) - '0';
                int diff = Math.abs(start - end) -1 ;
                switch(con){
                    case '=' :
                        if(diff  != range ) return;
                        break;
                    case '>' :
                        if(diff <= range) return;
                        break;
                    case '<' :
                        if(diff >= range) return;
                        break;    
                }
                
            }
            ans++;
            return;
        }        
        
        for(int i =0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                seats[cnt] = i;
                pmt(cnt+1, data);
                visited[i] = false;
            }
        }
    }
}

