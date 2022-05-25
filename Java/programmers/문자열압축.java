package java. java.programmers;
import java.util.*;

public class 문자열압축 {

	class Solution {
	    public int solution(String s) {
	        int answer = s.length();
	       
	        for(int i=1; i<=s.length()/2; i++){
	            String temp = "";
	            String comp = "";
	            int cnt = 1;
	            for(int j =0; j<s.length(); j+=i){
	                if(j+i<=s.length()){
	                    if(j==0) {
	                        temp = s.substring(j,j+i);
	                        continue;
	                    }
	                    if(temp.equals(s.substring(j,j+i))){
	                        cnt++;
	                    }else{
	                        if(cnt ==1 ){
	                            comp+= temp;
	                        }else{
	                            comp+= Integer.toString(cnt)+ temp;
	                            cnt =1;
	                        }
	                      temp = s.substring(j,j+i);
	                    }
	                }
	                
	                else if(j+i >=s.length()){
	                    comp+=s.substring(j,s.length());
	                }
	         
	            }
	            
	            if(cnt ==1 ){
	                comp+= temp;
	            }else{
	                comp+= Integer.toString(cnt)+ temp;
	            }
	           if(answer > comp.length()){
	               answer = comp.length();
	           }
	            
	            System.out.println(comp);
	        }
	       
	        
	        return answer;
	    }
	}
}
