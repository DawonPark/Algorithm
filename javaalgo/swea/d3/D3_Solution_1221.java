package javaalgo.swea.d3;

import java.util.Scanner;

public class D3_Solution_1221 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int result =-1;
			if(a<10 && b<10) {
				result = a*b;
			}
			System.out.println("#"+t+ " " + result);
		}
	sc.close();
	}
}
