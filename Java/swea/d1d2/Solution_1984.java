package swea.d1d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1984 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t=1; t<=tc; t++) {
			double result =0.0;
			int[] arr = new int[10];
			for(int i=0; i<10;i++) {
				arr[i]= sc.nextInt();
			}
			Arrays.sort(arr);
			for(int i=1; i<=8; i++) {
				result+=arr[i];
			}
			System.out.println("#"+t+" "+Math.round(result/8));
			
		}
		sc.close();
	}
}
