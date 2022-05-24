package baekjoon;

import java.util.Scanner;

/*
 * 백준 2999 - 비밀 이메일
 * 
 * 문제 내용대로 문자를 받고 열순서로 입력을 시키고 행순서로 출력을 시킴.
 */
public class Main_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();
		int r = 0;
		int c = 0;
		for(int i=1; i*i<=msg.length(); i++) {
			for(int j=i; j<=msg.length(); j++) {
				if(i*j==msg.length()) {
					r=i;
					c=j;
				}
			}
		}
//		System.out.println(r+" " + c);
		char[][] ans = new char[r][c];
		int index =0;
		
		for(int i =0; i<c; i++) {
			for(int j=0; j<r; j++) {
				ans[j][i]= msg.charAt(index++);
			}
		}
		for(int i =0; i<r; i++) {
			for(int j=0; j<c; j++) {
				System.out.print(ans[i][j]);
			}
		}
		
		sc.close();
	}
}
