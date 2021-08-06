package swea;

import java.util.Scanner;

public class D3_Solution_12004 {
	/*
	 * 정수 N이 주어졌을 때, N 이 1 이상 9 이하의 두 수 a, b의 곱으로 표현될 수 있는지 판단하라.
	 * 
	 * -> N을 1~9로 나머지가 0이고 그 수로 나눈 몫이 10 아래면 곱으로 표현할 수 있다고 생각
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
	outer:	for(int t =1; t<=tc; t++) {
			int n = sc.nextInt();
			for(int i=1; i<=9; i++) {
				if(n%i==0) {
					if(n/i<10) {
						System.out.println("#" + t + " Yes");
						continue outer ;
					}
				}
			}
			System.out.println("#" + t + " No");
		}
		sc.close();
	}
}
