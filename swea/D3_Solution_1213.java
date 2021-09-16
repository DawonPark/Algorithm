package swea;

import java.util.Scanner;

public class D3_Solution_1213 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		for(int t =0 ; t<10; t++) {
			sc.nextLine();
			String s = sc.nextLine();
			String msg = sc.nextLine();
			int ans =0;
			for(int i =0; i<msg.length(); i++) {
				if(s.charAt(0) == msg.charAt(i)) {
					int start = i;
					for(int j = 1; j<s.length(); j++) {
						if(++start>msg.length()-1) break;
						if(msg.charAt(start) != s.charAt(j))break;
						if(j==s.length()-1) ans++;
					}
				}
			}
			System.out.println("#" + t + " " + ans);
		}
		sc.close();
	}
}
