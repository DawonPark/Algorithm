package java. programmers.완전탐색;
import java.util.*;
/*
* 1,2,3번 수포자의 찍는 방식을 배열에 저장, count 배열 이용해서 맞은 문제 세고
* max 로 가장 많이 맞춘 문제 개수 파악 후 동점자가 있으면 List에 넣고 다시 answer 배열에 입력
*  -> 동점자 체크를 하는 방식을 배열과 반복문으로 해결하려다가 너무 복잡해서 List를 이용함
*/
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
       
        int[] first = { 1, 2, 3, 4, 5};
        int[] second ={2, 1, 2, 3, 2, 4, 2, 5};
        int[] third ={3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = {0,0,0};
        
        for(int i =0; i<answers.length; i++){
            if(answers[i]==first[i%5]) count[0]++;
            if(answers[i]==second[i%8]) count[1]++;
            if(answers[i]==third[i%10]) count[2]++;
        }
        
        int max = -999;
      for(int i=0; i<count.length; i++){
          if(max < count[i]){
              max = count[i];
          }
      }
        
      List<Integer> temp = new ArrayList<>();
       for(int i=0; i<count.length; i++){
          if(max == count[i]){
              temp.add(i+1);
          }
      } 
     int[] answer = new int [temp.size()];
     for(int i=0; i<temp.size(); i++){
         answer[i] = temp.get(i);
     }
        
            
        return answer;
    }
}
public class 모의고사 {
	 public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new int[] {1,2,3,4,5})));
		System.out.println(Arrays.toString(sol.solution(new int[] {1,3,2,4,2})));
	}
}
