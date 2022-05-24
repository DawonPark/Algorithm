package programmers.greedy;

public class 큰수만들기 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(); // String 시간 초과
        int len = number.length();
        int idx= 0;
        for(int i =len-k; i>0; i--){
            char ch =  '0';
            
            for(int j = idx; j <len - i +1 ; j++){
                if(ch < number.charAt(j)){
                    ch = number.charAt(j);
                    idx =  j+1;
                }
            }
            answer.append(ch); 
        }
        
        return answer.toString();
    }
}