package java. java.programmers.dfsbfs;



import java.util.*;
public class 여행경로 {
    static boolean[] visited;
    static String answer;
    static ArrayList<String> list;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        /*
        Arrays.sort(tickets,(a,b) ->{
			if(a[0].equals(b[0]))
			return a[1].compareTo(b[1]);
			else return a[0].compareTo(b[0]);
		});
		이렇게 풀면 도착지가 중간에 걸리면 해결이 안됨 -> 도착지가 경유지와 연관이 있으므로 그리디 불가능 완탐
		*/
        list = new ArrayList<>();
        dfs(0,tickets,"ICN" , "ICN");
        Collections.sort(list);
        
        return list.get(0).split(" ");
    }
    
    public void dfs(int cnt, String[][] tickets, String s, String answer){
        if(cnt == tickets.length){
            list.add(answer);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(s) && !visited[i]){
                visited[i] = true;
                dfs(cnt+1, tickets, tickets[i][1], answer+" "+tickets[i][1]);
                visited[i] = false;
            
            }
        }
    }
}