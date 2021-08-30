package swea;

import java.util.Scanner;
import java.util.Stack;
/*
 * 
 */
public class D4_Solution_5432 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		for(int t =1; t<=tc; t++) {
			char[] pipe = sc.nextLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			int sum =0;
			for(int i=0; i<pipe.length; i++) {
				if(pipe[i] == '(') stack.push(pipe[i]); // 쇠막대 ( 시작과 레이저 시작 넣어주기
				else { //  면 일단 pop으로 제거해줌
					stack.pop();
					if(pipe[i-1] =='(') {      // )인데 그전이 (이면 레이저고 스택에 (를 세어주면 왼쪽 막대들 세어짐
						sum+= stack.size();
					}
					else {              //  아니면 쇠막대의 끝, 쇠막대의 오른쪽은 +1 해주면 됨
						sum+=1;
					}
				}
			}
			System.out.println("#"+t + " " +sum);
		}
		sc.close();
	}
}
