package programmers.해시;

import java.util.HashMap;

public class 위장 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i <clothes.length; i++){
            if(!hm.containsKey(clothes[i][1])) hm.put(clothes[i][1],1);
            else hm.put(clothes[i][1] , hm.get(clothes[i][1])+1);
        }
        int answer = 1;
        for(String s : hm.keySet()){
            answer*=hm.get(s)+1;
        }
        return answer-1;
    }
}