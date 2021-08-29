package jungol;

import java.util.Scanner;

/*
 * 정올 2260 - 오류검사
 * 
 * -> 패리티비트 행 검사를 하면서 2개이상이면 바로 corrupt -> 열 검사 하면서 count가 2개이상이면 corrupt
 * 	  count 1 이면 바꿀 좌표 출력
 */
public class Jungol_2260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int wrongXCnt = 0, wrongYCnt=0;
		int checkCnt = 0;
		int x=0, y=0;
		for(int i= 0; i<N; i++) {
			checkCnt=0;
			for(int j=0; j<N; j++) {
				arr[i][j]= sc.nextInt();
				if(arr[i][j]==1) checkCnt++;
			}
			if(checkCnt%2==1) {
				wrongXCnt++;
				x=i;
			}
		}
		for(int i= 0; i<N; i++) {
			checkCnt=0;
			for(int j=0; j<N; j++) {
				if(arr[j][i]==1) checkCnt++;
			}
			if(checkCnt%2==1) {
				wrongYCnt++;
				y=i;
			}
		}
		
		if(wrongXCnt >=2 || wrongYCnt>=2) {
			System.out.println("Corrupt");
		}else if(wrongXCnt==0&&wrongYCnt==0) {
			System.out.println("OK");
		}else {
			System.out.println("Change bit ("+(x+1)+","+(y+1)+")");
		}
		
		sc.close();
	}
}
