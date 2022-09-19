package javaalgo.swea.d3;

import java.util.Scanner;

/*
 * SWEA - 10804 문자열의 거울상
 * 
 */
public class D3_Solution_10804 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1; t<=T; t++) {
			String s =  sc.nextLine();
			String ans ="";
			for(int i=s.length()-1; i>=0; i--) {
				switch(s.charAt(i)) {
				case 'p':
					ans+='q';
					break;
				case 'q':
					ans+='p';
					break;
				case 'b':
					ans+='d';
					break;
				case 'd':
					ans+='b';
					break;
				}
			}
			System.out.println("#"+t+ " " + ans);
		}
		sc.close();
	}
}
