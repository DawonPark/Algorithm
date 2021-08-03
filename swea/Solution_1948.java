package swea;

import java.util.Scanner;

public class Solution_1948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int day[] = { 0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; // 0월은 없으므로 0을 넣어줌 
		for (int t = 1; t <= tc; t++) {
				int start_month = sc.nextInt();
				int start_day = sc.nextInt();
				int end_month = sc.nextInt();
				int end_day = sc.nextInt();
				int i= end_month-start_month-1;
				int result=0;
				while(i>0) {
					result+=day[start_month+i]; // 차이나는 월의 일 수  계산
					i--;
				}
				
				if(end_month==start_month) {
					result+=end_day-start_day+1; // 같은 월 일 때 차이나는 일 수 계산
				}
				else {
				result+=(day[start_month]-start_day)+end_day+1; // 다른 월 일 때
				}
			
			

			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
}
