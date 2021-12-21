package programmers;

public class 신규아이디추천 {
	class Solution {
	    public String solution(String new_id) {
	        String answer =  new_id.toLowerCase();
	        boolean flag = false;
	        for(int i=0; i<answer.length(); i++){
	            char ch =   answer.charAt(i);
	            if('a' <= ch && ch <='z') continue;
	            if('0' <= ch && ch <='9') continue;
	            if('-' == ch || ch =='_' || ch== '.') continue;
	            answer = answer.replace(String.valueOf(ch), "");
	            i--;
	        }
	        
	        for(int i =0; i<answer.length(); i++)
	            {
	                if(answer.charAt(i) == '.'){
	                    int cnt =1;
	                    for(int j=i+1; j<answer.length(); j++){
	                        if(answer.charAt(j) == '.') {
	                            cnt++;
	                        }else break;
	                    }
	                    
	                    if(cnt > 1){
	                        String s = "";
	                        for(int j=0; j<cnt; j++){
	                            s+=".";
	                        }
	                        answer = answer.replace(s,".");
	                    }
	                }

	            }
	        if(answer.startsWith(".")){
	            answer = answer.substring(1,answer.length());
	        }
	        if(answer.endsWith(".")){
	            answer = answer.substring(0,answer.length()-1);
	        }
	        
	        if(answer.length() == 0){
	            answer+= "a";
	        }
	        
	        if(answer.length() >= 16){
	            answer= answer.substring(0,15);
	        } 
	        
	        if(answer.endsWith(".")) {
				answer = answer.substring(0, answer.length()-1);
			}
	        
	        int length = answer.length();
	        if(length <=2){
	            String last = String.valueOf(answer.charAt(length-1));
	            for(int i = 0 ; i<3-length; i++){
	                answer += last;
	            }
	        }
	        return answer;
	    }
	}
}
