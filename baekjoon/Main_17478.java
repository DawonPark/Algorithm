package baekjoon;

import java.util.Scanner;
/*
 * 재귀를 이용
 */
public class Main_17478 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		recursive(n);
		sc.close();
	} 
		
	
	
	
	static StringBuilder[] msg = {
			new StringBuilder("\"재귀함수가 뭔가요?\"")
			,new StringBuilder("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.")
			,new StringBuilder("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.")
			,new StringBuilder ("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"")
			,new StringBuilder("\"재귀함수는 자기 자신을 호출하는 함수라네\"")
			,new StringBuilder("라고 답변하였지.")
	};
	
	public static void recursive(int n) {
		
		if(n<1) {
			System.out.println(msg[0].toString());
			System.out.println(msg[4].toString());
			System.out.println(msg[5].toString());
			return;
		
		}
		for(int i=0; i<4; i++) {
			System.out.println(msg[i]);
		}
		for(int i=0; i<msg.length; i++) {
			msg[i].insert(0,"____");	
		}
		recursive(n-1);
		
	
			System.out.println(msg[5].delete(0,4));
		
		
	}
}
