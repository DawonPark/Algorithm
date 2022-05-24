package programmers.스택큐;
import java.util.*;
/*
 * programmers - 프린터
 * 
 * -> queue만 사용하려했는데 그때 가장 높은 순위인 지 확인하기위해서 LinkedList를 사용함
 * 
 */
public class 프린터 {
    class Pair{
        int p;
        int index;
        Pair(int index, int p){
            this.index = index;
            this.p = p;
        }
    }
    public int solution(int[] priorities, int location) {
        LinkedList<Pair> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            queue.offer(new Pair(i,priorities[i]));
        }
        int answer = 0;
        while(!queue.isEmpty()){
            Pair temp = queue.poll();
            int size = queue.size();
            boolean check = false;
           for(int i=0; i<size; i++){
               if(queue.get(i).p > temp.p) {
                   check = true;
                   break;
               }
           }
            if(check==false){
                answer++;
                if(location == temp.index){
                    break;
                }
            }
               
       }
        
        
        
        return answer;
    }
}