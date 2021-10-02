package programmers.해시;

import java.util.*;

public class 전화번호 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> map = new HashSet<>();
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length; i++){
        	for(int j=0; j<=phone_book[i].length(); j++) {
        		if(map.contains(phone_book[i].substring(0, j))) { // 다른 풀이를 보니 이 부분은 startsWith으로 해결 가능
        			return !answer;
        		}
        	}
            map.add(phone_book[i]);
        }
        System.out.print("true");
        return answer;
    }
}