package swea.d3;

import java.util.Scanner;
/* 
 * 1216. 회문 2
 * 
 * 회문 1에서 -> 최고 길이를 찾기위해서 2부터 점차 길이가 늘려주면서 검사하는 루프로 바꿈
 */
public class D3_Solution_1216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t<=10; t++) {
			sc.nextLine();
			char[][] arr = new char[100][100];
			for(int i=0; i<100; i++) {
				String s = sc.nextLine();
				for(int j=0;j<100; j++) {
					arr[i][j]=  s.charAt(j);
				}
			}
			int answerW = 1;
			for(int i=0; i<100;i++) {
				for(int j=0; j<100; j++) {
					
					int weight = 2;
					while(true) {
						if(j+weight>100 ) break;
						boolean check = true;
						for(int k=0; k<weight/2; k++) {
							if(arr[i][j+k] !=arr[i][j+weight-k-1]) {
								check = false;								
								weight++;
								continue;
							}
						}
						if(check==true) {
							answerW = Math.max(weight, answerW);
							weight++;
						}
					}
					
				}
			}
			int answerL =1;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					int length = 2;
					while(true) {
						if(i+length>100 ) break;
						boolean check2 = true;
						for(int k=0; k<length/2; k++) {
							if(arr[i+k][j] !=arr[i+length-k-1][j]) {
								check2 = false;
								length++;
								continue;
							}
						}
						if(check2==true) {
							answerL = Math.max(length, answerL);
							length++;
						}
					}
				}
			}
			
			
			System.out.println("#"+t +" " +Math.max(answerW, answerL));
			
		}
		sc.close();
	}
}
