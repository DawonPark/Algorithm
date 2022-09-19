package javaalgo.programmers.해시;
import java.util.*;
public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> hs = new HashMap<>();
        String answer = "";
        for(String msg : participant){
            if(hs.get(msg) == null){
                hs.put(msg, 1);
            }else{
               hs.put(msg, hs.get(msg)+1); 
            }
        }
        
        for(String msg : completion){
               hs.put(msg, hs.get(msg)-1); 
        }
        
        for(String key : hs.keySet()){
               if(hs.get(key) == 1){
                    answer = key;
                    break;
               }
        }
        
        
        return answer;
    }
}