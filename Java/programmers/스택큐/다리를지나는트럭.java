package java. programmers.스택큐;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
	 public int solution(int bridge_length, int weight, int[] truck_weights) {
	        Queue<Integer> queue = new LinkedList<>();
	        int sum = truck_weights[0];
	        queue.offer(truck_weights[0]);
	        int answer = 0;
	        int time =0;
	        int i = 1;
	        while(!queue.isEmpty()){
	           if(i>=truck_weights.length) break;
	           if(queue.size()== bridge_length){
	               sum-= queue.poll();
	           }
	           if(i<truck_weights.length && sum+truck_weights[i]<=weight){
	              sum+=truck_weights[i];
	              queue.offer(truck_weights[i]);
	              i++;
	           } else{
	               queue.offer(0);
	           }
	            answer++;
	        }
	        answer+= ++bridge_length;
	        return answer;
	    }
}
