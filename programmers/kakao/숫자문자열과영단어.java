package programmers.kakao;
/*
 * String에 replace 를 사용한다면 더 간단함
 */
class Solution {
    public int solution(String s) {
        int answer = 0;
        String temp = "";
        String temp2 = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if( '0' <=ch && ch <= '9'){
                temp+=ch;
                temp2="";
            } 
            else{
                temp2+=ch;
                if(!temp2.equals("")) {
                    switch(temp2){
                        case "zero" : temp+="0"; temp2="";
                            break;
                        case "one" : temp+="1"; temp2="";
                            break;
                        case "two" : temp+="2"; temp2="";
                            break; 
                        case "three" : temp+="3"; temp2="";
                            break;
                        case "four" : temp+="4"; temp2="";
                            break;
                        case "five" : temp+="5"; temp2="";
                            break;
                        case "six" : temp+="6"; temp2="";
                            break;
                        case "seven" : temp+="7"; temp2="";
                            break;
                        case "eight" : temp+="8"; temp2="";
                            break;
                        case "nine" : temp+="9"; temp2="";
                            break;     
                    }
                }
            }
        }
       
        System.out.println(temp);
        return Integer.parseInt(temp);
    }
}