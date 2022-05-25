package java. swea.d1d2;

import java.util.Scanner;

public class Solution_1986 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int num= sc.nextInt();
			int[] arr = new int[num];
			for(int i=1; i<=num; i++) {
				if(i%2==0) {
					arr[i-1]=-i;
				}
				else {
					arr[i-1]=i;
				}
			}
			int result=0;
			for(int i: arr) {
				result+=i;
			}
			System.out.println("#"+t+" "+result);
		}
	
	sc.close();
	}
}
