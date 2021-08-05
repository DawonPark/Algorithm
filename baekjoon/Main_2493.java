package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493 {
	/*
	 * 탑들은 왼쪽부터 오른쪽으로 주어진 높이로 세워진다.
	 * 레이저 신호는 각 탑의 수평 왼쪽으로만 간다.
	 * 레이저 신호는 탑 기둥과 한번 만나면 수신이 되고 사라진다.
	 * -> 왼쪽부터 탑을 세우고 레이저도 수평의 왼쪽으로만 보낸다. -> stack 사용
	 *  넣을 때 부터 확인해서 정답배열에 넣고 출력하는 방법으로 생각함.
	 *  
	 *  처음에는 <Integer> 로 했지만 stack.peek().height<height&& maxHeight>height 이 조건에서 index를 가져올 방법이 없어서 Index클래스를 만들었음
	 *  
	 *  메모리 초과 문제 해결 -> scanner 전에 조건으로 stack을 clear 시켜주는 것을 만듬 , 후에도 초과나서 scanner 를 BufferdReader 로 수정하였음
	 */
	static class Index{
		int index;
		int height;
		public Index(int index, int height) {
			this.index =index;
			this.height = height;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine());
		Stack<Index> stack = new Stack<Index>();
		int[] result =new int[N+1]; // 정답을 받을 배열
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		stack.push(new Index(1,Integer.parseInt(st.nextToken()))); // 처음은 무조건 넣음
		result[1] = 0; // 왼쪽에는 건물이 없음. 
		int max = 1;
		int maxHeight = stack.peek().height;
		for(int i=2; i<=N; i++) {
			int height = Integer.parseInt(st.nextToken()); // 건물의 높이
			if(stack.peek().height> height) { // 왼쪽 건물이 더 크면
				result[i] = i-1;
				stack.push(new Index(i,height));
			}
	
			else if(stack.peek().height<height&& maxHeight>height) {
				while(!stack.isEmpty()) {
					if(stack.peek().height>=height) {
						result[i] =stack.peek().index;
						break;
					}else stack.pop();
				}
				stack.push(new Index(i,height));
			}
			else if(maxHeight == height) {
				stack.clear();
				result[i] = max;
				max= i;
				stack.push(new Index(i,height));
			}else if(maxHeight <height) {
				stack.clear();
				result[i] = 0;
				max = i;
				maxHeight=height;
				stack.push(new Index(i,height));
			}
			
		}
		for(int i=1; i<=N; i++) {
			System.out.print(result[i]+" ");			
		}
	}
}
