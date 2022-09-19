package javaalgo.programmers.완전탐색;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/*
 * 문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

-> 처음에 단순한 subset 인줄 알았는데 테케에서 011이 있는데 만들수 있는 숫자에서 101이 될 수 있다는 것에서 순열도 포함해야된다는 생각이 듬.
   011 같은 경우에는 1이 중복이기 때문에 순열 세울때 중복이 발생하여 set구조를 이용하였고  부분집합에서는 가변적인 값이 들어오는 걸 처리하기 위해
   list이용, check는 boolean 의 배열을 사용함
   int 배열인 input과 result는 input은 받은 색종이를 저장 , result는 선택한 색종이라고 볼수 있음.
 */
public class 소수찾기 {
	 	static int input[] ,result[];
	    static int N;
	    static boolean isSelected[];
	    static boolean isSelected2[];
	    static HashSet<Integer> hs;
	    static List<Integer> list;
	    
	    public static int solution(String numbers) {
	    	int answer =0;
	        N = numbers.length();
	        input = new int[N];
	        isSelected = new boolean[N];
	        hs = new HashSet<>();
	        for(int i=0; i<numbers.length(); i++) {
	        	input[i] = numbers.charAt(i) - '0';
	        }
	        subset(0);
	        Iterator it = hs.iterator();
	     outer: while(it.hasNext()) {
	        	int num = (int) it.next();
	        	if(num==0 || num==1) continue outer;
	        	for(int i=2; i<num; i++) {
	        		if(num%i==0) {
	        			continue outer;
	        		}
	        	}
	        	answer++;
	        }
	        
	        return answer;
	    }
	    
	    public static void subset(int cnt){
	        if(cnt ==N) {
	        	list = new ArrayList<Integer>();
	        	for(int i=0; i<N; i++) {
	        		if(isSelected[i] == true) {
	        			list.add(input[i]);
	        		}
	        	}
	        	isSelected2 = new boolean[list.size()];
	        	result = new int[list.size()];
	        	permutation(0);
	        	
	        	return;
	        }
	        
	        	isSelected[cnt] = true;
	        	subset(cnt+1);
	        	isSelected[cnt] = false;
	        	subset(cnt+1);
	        
	    }
	
	private static void permutation(int cnt) {
			if(list.size() == cnt) {
				int num=0;
				int j=1;
				for(int i  : result) {
					num+= i*j;
					j*=10;
				}
				hs.add(num);
				return;
			}
			for(int i=0; i<list.size(); i++) {
				if(isSelected2[i] == true) continue;
				isSelected2[i] = true;
				result[cnt] =  list.get(i);
				permutation(cnt+1);
				isSelected2[i] = false;
			}
		}

	public static void main(String[] args) {
		int answer=solution("17");
		System.out.println(answer);
	}
}
