package javaalgo.swea.d3;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
 /*	0 ~ 999999 사이의 수를 나열하여 만든 암호문이 있다.
	암호문을 급히 수정해야 할 일이 발생했는데, 이 암호문은 특수 제작된 처리기로만 수정이 가능하다.
	이 처리기는 다음과 같이 1개의 기능을 제공한다.
	1. I(삽입) x, y, s : 앞에서부터 x의 위치 바로 다음에 y개의 숫자를 삽입한다. s는 덧붙일 숫자들이다.[ ex) I 3 2 123152 487651 ]
	위의 규칙에 맞게 작성된 명령어를 나열하여 만든 문자열이 주어졌을 때, 암호문을 수정하고, 수정된 결과의 처음 10개 숫자를 출력하는 프로그램을 작성하여라.
	
  * 처음에 배열로 접근을 했는데 index 관리가 안되는것 같아서 그냥 LinkedList로 연결해서 10으로 뽑아오는 편한 코드로 작성함
  * -> 풀고나서 I의 입력이 0부터 들어온다는 걸 알게되었음.
  * 배열로 풀면 시간도 빠르고 10 아래는 짜르면서 풀 수 있을 것 같음.
  */
public class D3_Solution_1228 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t =1;  t<=10; t++) {
		int num = sc.nextInt();
		List<Integer> list = new LinkedList<Integer>();
		for(int i = 0; i<num; i++) {
			list.add(sc.nextInt());
		}
		sc.nextLine();
		int command = Integer.parseInt(sc.nextLine());
		for(int i=0; i<command; i++ ) {
			sc.next();
			int index= sc.nextInt();
			int count= sc.nextInt();
			for(int  j = 0; j<count; j++) {
				 list.add(index++,sc.nextInt());
			}
		}
		System.out.print("#"+ t+ " ");
		for(int i=0; i<10; i++) {
			System.out.print(list.get(i)+ " ");
		}
		System.out.println();
		
		}
		sc.close();
	}
}
