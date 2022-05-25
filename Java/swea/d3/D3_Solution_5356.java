package java. swea.d3;

import java.util.Scanner;
/*
 * SWEA 5356 - 의석이 세로로 말해요
 * 
 */
public class D3_Solution_5356 {
	public static void main(String[] args) {
		Scanner sc=  new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t=1; t<=T; t++) {
			String s1 = sc.nextLine();
			String s2 = sc.nextLine();
			String s3 = sc.nextLine();
			String s4 = sc.nextLine();
			String s5 = sc.nextLine();
			System.out.print("#"+t + " ");
			for(int i =0; i<=15; i++) {
				if(i<s1.length()) System.out.print(s1.charAt(i));
				if(i<s2.length()) System.out.print(s2.charAt(i));
				if(i<s3.length()) System.out.print(s3.charAt(i));
				if(i<s4.length()) System.out.print(s4.charAt(i));
				if(i<s5.length()) System.out.print(s5.charAt(i));
			}
			System.out.println();
		}
		sc.close();
	}
}
