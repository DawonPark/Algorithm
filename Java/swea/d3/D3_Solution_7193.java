package java. swea.d3;

import java.util.Scanner;

public class D3_Solution_7193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;  t<=T; t++) {
			long N = sc.nextLong();
			String X = sc.nextLine().trim();
			long num =0;
			for(int i = X.length()-1; i>=0; i--) {
				num += (X.charAt(i) - '0');
			}
			System.out.println("#"+t + " " +(num%(N-1)));
		}
		sc.close();
	}
}
