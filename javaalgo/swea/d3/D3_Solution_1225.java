package javaalgo.swea.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D3_Solution_1225 {
	
	/*
	 * 다음 주어진 조건에 따라 n개의 수를 처리하면 8자리의 암호를 생성할 수 있다.
		- 8개의 숫자를 입력 받는다.
		- 첫 번째 숫자를 1 감소한 뒤, 맨 뒤로 보낸다. 
		다음 첫 번째 수는 2 감소한 뒤 맨 뒤로, 그 다음 첫 번째 수는 3을 감소하고 맨 뒤로, 그 다음 수는 4, 그 다음 수는 5를 감소한다.
		- 숫자가 감소할 때 0보다 작아지는 경우 0으로 유지되며, 프로그램은 종료된다. 이 때의 8자리의 숫자 값이 암호가 된다.
		
		첫 번 째수를 감소시키고 맨 뒤로 보낸다-> queue 줄서기로 접근 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			sc.nextInt();
			for(int i=0; i<8; i++) {
				queue.offer(sc.nextInt());
			}
		
			outer : while(true) {
				for(int i=1; i<=5; i++) {
					int e= queue.poll()-i;
					if(e<=0) {
						queue.offer(0);
						break outer;
					}
					queue.offer(e);
					
				}
			}
			
			System.out.print("#" + t );
			for(int i=0; i<8; i++) {
				System.out.print(" "+ queue.poll());
			}
			System.out.println();
		}
		sc.close();
	}
}
