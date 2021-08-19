package swea;

import java.util.Scanner;

public class D3_Solution_1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int x = sc.nextInt(); int y = sc.nextInt();
			
			int idx = x+y;
			int start =1;
			for(int i=1; i<=idx-2; i++) {
				start+=i;
			}
			System.out.println(start);
		}
	}
}
