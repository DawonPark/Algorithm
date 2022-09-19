package javaalgo.programmers.힙;
import java.util.*;
public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs,(o1,o2)->{
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
            }); // 요청시간 내림차순으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) ->o1[1]-o2[1]);// 실행시간 오름차순
        pq.offer(jobs[0]);
        int idx = 1;
        int time =jobs[0][0];
        while(!pq.isEmpty()){
            int[] data = pq.poll();
            time += data[1];
            answer += time-data[0]; // 작업이 끝나면 
            System.out.println(data[1]);
            while(idx<jobs.length && jobs[idx][0]<=time){ // 현재 시간을 기준으로 들어온 작업들을 넣어줌
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty() && idx<jobs.length){
                time = jobs[idx][0];
                pq.offer(jobs[idx++]);
            }
        }
        return answer/jobs.length;
    }
}