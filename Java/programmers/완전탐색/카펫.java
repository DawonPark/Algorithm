package programmers.완전탐색;
/*
 * Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
   Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
   Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
   
   -> yellow 의 약수를 구하는데  for 루프에 i*i를 준 것은 이 범위가 넘어가면 48인 경우에 6*8 -> 8*6 이 가능하기 때문에 조건을 주었음 
   -> sqrt를 이용해서 작은 것에서 나눠서 약수를 구하는 것과 같음
   -> brown은 yellow 곁에 있는 숫자이기 때문에 가로세로 +2 에서 곱한 것이 합과 같으면 됨
   
 */
public class 카펫 {
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
        for(int i =1; i*i<=yellow; i++) {
        	if(yellow%i ==0) {
        		int length = yellow/i + 2;
        		int height = i + 2;
        		
        		if(length*height == brown +yellow ) {
        			answer[0] = length;
        			answer[1] = height;
        			return answer;
        		}
        		
        	}
        }
        	
        
        return answer;
        
        
    }
	
	public static void main(String[] args) {
		solution(24,24);
	}
	
}
