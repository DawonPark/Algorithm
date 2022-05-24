package swea.d1d2;

import java.util.Scanner;

public class Solution_1976 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc;t++) {
			int hour1= sc.nextInt();
			int min1= sc.nextInt();
			int hour2= sc.nextInt();
			int min2= sc.nextInt();
			int resultHour, resultMin=0;
			if(hour1+hour2>12) {
				 resultHour = hour1+hour2 -12;
			}
			else {
			resultHour =hour1+hour2;
			}
			if(min1+min2>60) {
				resultHour+=1;
				resultMin=min1+min2-60;
			}
			else {
			resultMin=min1+min2;
			}
			System.out.println("#"+t +" "+resultHour+" "+resultMin);
		}
		sc.close();
	}
}
