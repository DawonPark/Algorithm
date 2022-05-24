package programmers.greedy;

import java.util.Arrays;
public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int start =0;
	    for (int i = people.length - 1; i>=start; i--){
	      if (people[start] + people[i] <= limit) start++;
	      answer++;
	    }
        return answer;
    }
}