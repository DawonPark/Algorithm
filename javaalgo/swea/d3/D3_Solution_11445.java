package javaalgo.swea.d3;

import java.util.Scanner;

/*
 * 영어 알파벳으로 만들 수 있는 모든 단어(그것이 뜻이 없어도)가 수록된 무한 사전이 있다.
	두 단어 P, Q가 주어질 때, 사전 상에서 P와 Q사이에 다른 단어가 있는지 없는지 판별하는 프로그램을 작성하라.
	-> String.append 이용하기로함 -> a랑 붙여서 같으면 N 틀리면 Y , 길이가 다를 때는 있을수 밖에 없기 때문에 상관없음
 */
public class D3_Solution_11445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= Integer.parseInt(sc.nextLine());
		for(int t=1; t<=tc; t++) {
			String s = sc.nextLine()+"a";
			String s2 = sc.nextLine();
			System.out.println("#"+t+ (s.equals(s2) ? " N" :" Y"));
		}
		sc.close();
	}
}
