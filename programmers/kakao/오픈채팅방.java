package programmers.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/*
 * Programmer kakao 오픈채팅방
 * 
 * - 이름을 바꾸면 전에 내용도 바뀌기때문에 마지막에 채팅메시지를 정해야함. 
 * - Map과 List를 이용함.
 */
public class 오픈채팅방 {
	 public String[] solution(String[] record) {
		    	List<String[]> list = new ArrayList<>();
		        HashMap<String, String> map = new HashMap<>();
		        int cnt =0;
		        for(int i=0; i<record.length; i++){
		            String[] msg = record[i].split(" ");
		            if(msg[0].equals("Enter")) {
		                map.put(msg[1], msg[2]);
		                list.add(new String[]{msg[0],msg[1]});
		                cnt++;
		            }else if(msg[0].equals("Change")){
		                map.put(msg[1], msg[2]);
		            }else{
		                list.add(new String[]{msg[0],msg[1]});
		                cnt++;
		            }
		        }
		        String[] answer = new String[cnt];
		        int i=0;
		    
		        for(String[] arr : list ){
		        	System.out.println(arr[1]);
		            if(arr[0].equals("Enter")){
		                answer[i++]=map.get(arr[1])+"님이 들어왔습니다.";
		            }else if(arr[0].equals("Leave")){
		                answer[i++]=map.get(arr[1])+"님이 나갔습니다.";
		            }
		        }
		        return answer;
		    }
        
}
