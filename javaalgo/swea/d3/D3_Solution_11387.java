package javaalgo.swea.d3;

import java.util.Scanner;
/*
 * 	용사가 몬스터를 공격할 때는 기본적으로 D만큼의 데미지를 입힌다. 여기에, 용사가 익힌 공격의 레벨 L에 따라 추가적인 데미지가 있는데,
	지금까지 몬스터를 때린 횟수가 n번이라고 하면, 다음 공격이 몬스터에게 입히는 데미지는 D(1+nㆍL%)가 된다. %는 1/100을 의미한다.
	지금까지 용사가 몬스터를 때린 횟수가 0번이라고 할 때, 앞으로 총 N번의 공격을 하면 몬스터에게 가한 총 데미지가 몇이 되는지 구하는 프로그램을 작성하라.

	[입력]
	첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
	각 테스트 케이스의 첫 번째 줄에는 세 정수 D, L, N(102 ≤ D ≤ 104, 0 ≤ L ≤ 100, 1 ≤ N ≤ 102)이 공백 하나로 구분되어 주어진다. 
	D는 100의 배수로만 주어진다.

	-> 100배의 배수로 주어진다해서 %에 100씩 곱해서 다시 나누면 짤리는 값이 없을 것이라 생각해서 형 변환 없이 풀어도 된다 생각함.
 */
public class D3_Solution_11387 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int D = sc.nextInt();
			int L = sc.nextInt();
			int N = sc.nextInt();
			int result =0;
			for(int i=0; i<N; i++) {
				result+= D*(100+i*L) / 100;
			}
			System.out.println("#" + t + " "+result);
		}
		sc.close();
	}
}
