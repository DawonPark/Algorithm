package swea.d4;

import java.util.Scanner;
import java.util.Stack;

public class D4_Solution_1218 {
	/*
	 * 4 종류의 괄호문자들 '()', '[]', '{}', '<>' 로 이루어진 문자열이 주어진다.
	 *  짝이 모두 맞는지 판별하는 프로그램
	 *  
	 *  괄호 규칙 -> 열린 순서의 반대로 닫힌 괄호가 와야함. -> stack
	 *  
	 *   입력 <{[()]}> 올바르면 pop 하면 비워짐
	 *      <{[(})]> 괄호가 다를 떄 넣으면 비워지지 않음.
	 */
	
	public static void main(String[] args) {
		 Scanner sc= new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int length = Integer.parseInt(sc.nextLine());
			String s= sc.nextLine();
			boolean vaild = false;
			Stack<Character> stack = new Stack<Character>();
			for(int i=0; i<length; i++) {
				if(s.charAt(i)=='{' || s.charAt(i)== '[' ||s.charAt(i)== '{' ||s.charAt(i)== '<'){
					stack.push(s.charAt(i));
					continue;
				}   // 열린 괄호일 떄만 푸쉬
				
				// 닫힌 괄호 일때
				if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek() =='(') stack.pop();
				else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek() =='{')  stack.pop();
				else if(s.charAt(i)=='>' && !stack.isEmpty() && stack.peek() =='<') stack.pop();
				else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek() =='[') stack.pop();
				else stack.push(s.charAt(i)); //  쌍이 안맞을 때
				
				if(stack.isEmpty()) vaild = true;
				
			}
			// 출
			if(vaild) {
			System.out.println("#" +t +" " + 1);
			}else {
				System.out.println("#" +t +" " + 0);
			}
			
		}
		sc.close();
	}
}
