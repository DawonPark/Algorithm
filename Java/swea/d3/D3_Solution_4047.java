package swea.d3;

import java.util.Scanner;
/*
 * SWEA 4047 - 영준이의 카드 카운팅
 * 
 * -> 조건에 맞게 2글자씩 문자열을 잘라서 boolean배열을 체크하고 체킹
 */
public class D3_Solution_4047 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
	outer:	for(int t=1; t<=T; t++) {
			boolean[][] cards = new boolean[4][14];
			String msg = sc.nextLine();
			for(int i=0;  i<msg.length(); i++) {
				String temp ="";
				if(msg.charAt(i)=='S') {
					temp = msg.substring(i+1, i+3);
					if(!cards[0][Integer.parseInt(temp)])cards[0][Integer.parseInt(temp)] = true;
					else {
						System.out.println("#"+t+ " " +"ERROR");
						continue outer;
					}
				}else if(msg.charAt(i) == 'D') {
					temp = msg.substring(i+1, i+3);
					if(!cards[1][Integer.parseInt(temp)])cards[1][Integer.parseInt(temp)] = true;
					else {
						System.out.println("#"+t+ " " +"ERROR");
						continue outer;
					}
				}else if(msg.charAt(i) == 'H') {
					temp = msg.substring(i+1, i+3);
					if(!cards[2][Integer.parseInt(temp)])cards[2][Integer.parseInt(temp)] = true;
					else {
						System.out.println("#"+t+ " " +"ERROR");
						continue outer;
					}
				}else if(msg.charAt(i) == 'C') {
					temp = msg.substring(i+1, i+3);
					if(!cards[3][Integer.parseInt(temp)])cards[3][Integer.parseInt(temp)] = true;
					else {
						System.out.println("#"+t+ " " +"ERROR");
						continue outer;
					}
				}
			}
			System.out.print("#"+t + " ");
			for(int i=0; i<4; i++) {
				int count =13;
				for(int j=1; j<14; j++) {
					 if(cards[i][j] == true) {
						 count--;
					 }
				}
				System.out.print(count+" ");
			}
			System.out.println();
		}
	}
}
