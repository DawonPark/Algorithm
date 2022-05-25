package java. swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * SWEA 1223 계산기 2
 * 
 * 후위표현식 만드는 방법 -> 숫자는 StringBuilder에 붙여줌 스택에는 연산자만 넣어주는데 넣어주는 연산자가 우선순위가 스택의 peek보다 높으면 push, 같거나 낮으면 모두 pop후 push
 * 후위표현식 계산 -> 숫자면 스택에 넣어주고 연산자를 만날 때마다 숫자 두개를 꺼내와서 계산하고 다시 push
 * 
 */
public class D4_Solution_1223 {
	
	
	static String postfix(String mid, int length) {
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			char ch = mid.charAt(i);
			if('0'<= ch && ch <= '9') sb.append(ch);
			else {
				if(stack.isEmpty()) stack.push(ch); // 스택이 비어있다면 넣음
				else {  // 비어있지않다면
					if(ch =='+') { // + 면 무조건 빼야함
						while(!stack.isEmpty()) {
							sb.append(stack.pop());
						}
						stack.push(ch);
					}else if(ch == '*') { // *면 +가 아니면 빼야함
						while(!stack.isEmpty()) {
							if(stack.peek()=='+') {
								stack.push(ch);
								break;
							}
							else if(stack.peek() =='*') {
								while(!stack.isEmpty()) {
									if(stack.peek() == '+') break;
									sb.append(stack.pop());
								}
								stack.push(ch);
								break;
							}
						}
					}
				}
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	private static int cal(String postfix) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<postfix.length(); i++) {
			char ch = postfix.charAt(i);
			if('0'<= ch && ch <= '9') stack.push(ch - '0');
			else {
				int right =0 , left =0;
				if(ch =='*') {
					 right = stack.pop();
					 left = stack.pop();
					stack.push(left*right);
				}else if(ch =='+') {
					right = stack.pop();
					left = stack.pop();
					stack.push(left+right);
				}
				
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t =1; t<=10; t++) {
			int L = Integer.parseInt(br.readLine());
			String infix = br.readLine();
			String postfix = postfix(infix ,L);
			int result = cal(postfix);
			System.out.println("#" + t + " " + result);
			
		}
	}
}

