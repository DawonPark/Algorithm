package javaalgo.swea.d3;

import java.util.Scanner;
/*
 * Calkin-Wilf tree는 모든 양의 유리수를 정확히 하나씩 포함하고 있는 트리다. 이 트리는 다음과 같이 정의된다
    ∙ 트리의 루트는 1/1 을 나타낸다.
    ∙ 트리의 각 노드는 왼쪽 자식과 오른쪽 자식을 가지는데 어떤 노드가 a/b 를 나타내고 있다면, 왼쪽 자식은 a/a+b 를 오른쪽 자식은 a+b/b 를 나타낸다.
	루트 노드에서부터, 자식을 따라 내려간 방향이 순서대로 주어질 때, 마지막에 위치한 노드가 어떤 유리수를 나타내는지 구하는 프로그램을 작성하라.
	
	-> String으로 받아서 반복돌아서 해결함
 */
public class D3_Solution_11688 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = Integer.parseInt(sc.nextLine());
		for(int t =1; t<=tc; t++) {
			int a=1;
			int b=1;
			String msg = sc.nextLine();
			for(int i=0; i<msg.length(); i++) {
				if(msg.charAt(i)=='L') {
					b+=a;
				}else {
					a+=b;
				}
			}
			System.out.println("#"+t+" "+a+" "+b);
		}
		sc.close();
	}
}
