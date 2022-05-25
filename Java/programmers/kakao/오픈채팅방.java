package java.programmers.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Programmer kakao 오픈채팅방
 * 
 * - 이름을 바꾸면 전에 내용도 바뀌기때문에 마지막에 채팅메시지를 정해야함. 
 * - Map과 List를 이용함.
 * - 22.01.04 다시 풀어봄
 */
public class 오픈채팅방 {
    public String[] solution(String[] record) {
        List<String[]> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        int cnt = 0;
        String[] answer = null;
        for(int i=0; i<record.length; i++){
            String[] data = record[i].split(" ");
            if(data[0].equals("Enter")){
                list.add(new String[]{"E",data[1]});
                map.put(data[1], data[2]);
                cnt++;
            }else if(data[0].equals("Leave")){
                list.add(new String[]{"L",data[1]});
                cnt++;
            }else {
                map.put(data[1] , data[2]);
            }
        }
        answer = new String[cnt];
        int i =0;
        for(String[] data : list){
            if(data[0].equals("E")){
                answer[i++] = map.get(data[1]) + "님이 들어왔습니다.";
            }else if(data[0].equals("L")){
                answer[i++] = map.get(data[1]) + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
