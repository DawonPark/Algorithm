package programmers;
import java.util.*;
public class 신고_결과_받기 {
	  public int[] solution(String[] id_list, String[] report, int k) {
	        int[] answer = new int[id_list.length];
	        // 누가 누구를 신고했는지를 저장하고 있어야함.
	        // 신고의 숫자를 가지고 있어야함.
	        // 중복 신고 처리
	        HashMap<String, HashSet<String>> hm = new HashMap<>(); 
	        HashMap<String, Integer> index = new HashMap<>();
	        for(int i=0; i<id_list.length; i++){
	            hm.put(id_list[i], new HashSet<>());
	            index.put(id_list[i], i);
	        }
	        for(int i=0; i<report.length; i++){
	            String[] data = report[i].split(" ");
	            hm.get(data[1]).add(data[0]);
	        }
	        
	        for(int i=0; i<id_list.length; i++){
	            HashSet<String> hs = hm.get(id_list[i]);
	            if(hs.size()>=k){
	                for(String s : hs){
	                    answer[index.get(s)]++;
	                }
	            }
	        }
	        return answer;
	    }
}
