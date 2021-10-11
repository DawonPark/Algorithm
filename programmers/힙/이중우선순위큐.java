package programmers.힙;
import java.util.*;
public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1,o2) -> o2-o1); // Collections.reverseOrder();가능
        for(String s : operations){
            String[] msg =s.split(" ");
            if(msg[0].equals("I")){
                minQ.offer(Integer.parseInt(msg[1]));
                maxQ.offer(Integer.parseInt(msg[1]));
            }else{
                if(msg[1].equals("1")){
                    if(!maxQ.isEmpty())  minQ.remove(maxQ.poll()); // Queue에서 remove(Object o) 밖에 없기 때문에 가능함.
                }else{
                    if(!minQ.isEmpty()) maxQ.remove(minQ.poll());
                    }
                }
            } 
        if(!maxQ.isEmpty()) answer[0] = maxQ.poll();
        if(!minQ.isEmpty()) answer[1] = minQ.poll();
        
        return answer;
    }
}