package javaalgo.swea.d3;

import java.util.Scanner;
/*
 * "기러기" 또는 "level" 과 같이 거꾸로 읽어도 앞에서부터 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
	주어진 8x8 평면 글자판에서 가로, 세로를 모두 보아 제시된 길이를 가진 회문의 총 개수를 구하는 문제이다.
	
 	-> 회문은 확인은 맨 앞 맨 뒤부터 인덱스 줄여가면서 확인함 -> 홀수는 상관없음
 */ 
public class D3_Solution_1215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t<=10; t++) {
			int L = Integer.parseInt(sc.nextLine());
			char[][] arr = new char[8][8];
			for(int i=0; i<8; i++) {
				String s = sc.nextLine();
				for(int j=0;j<8; j++) {
					arr[i][j]=  s.charAt(j);
				}
			}
			int answer = 0;
			for(int i=0; i<8;i++) {
				for(int j=0; j<8; j++) {
					if(j+L>8 ) continue;
					boolean check = true;
					for(int k=0; k<L/2; k++) {
						if(arr[i][j+k] !=arr[i][j+L-k-1]) {
							check = false;
							break;
						}
					}
					if(check==true) {
						answer++;
					}
				}
			}
			
			for(int i=0; i<8; i++) {
				for(int j=0; j<8; j++) {
					if(i+L>8 ) break;
					boolean check2 = true;
					for(int k=0; k<L/2; k++) {
						if(arr[i+k][j] !=arr[i+L-k-1][j]) {
							check2 = false;
							break;
						}
					}
					if(check2==true) {answer++;
					}
				}
			}
			
			System.out.println("#"+t +" " +answer);
			
		}
		sc.close();
	}
}
