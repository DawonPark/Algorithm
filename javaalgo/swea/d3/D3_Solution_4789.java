package javaalgo.swea.d3;

import java.util.Scanner;

public class D3_Solution_4789 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t =1; t<=T; t++) {
			String s = sc.nextLine();
			int start = s.charAt(0) -'0';
			int ans = 0;
			for(int i=1; i<s.length(); i++) {
				int temp = s.charAt(i) - '0';
				if(start >=i) {
					start+=temp;
				}else {
					ans += i-start;
					start+=i-start+temp;
				}
			}
			System.out.println("#"+t + " "+ans);
		}
		sc.close();
	}
}
