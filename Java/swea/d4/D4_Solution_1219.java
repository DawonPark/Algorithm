package swea.d4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_Solution_1219 {
	static int[] arr,arr2;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t<=10; t++) {
			sc.nextInt();
			int N = sc.nextInt();
			arr = new int[N];
			arr2 = new int[N];
			for(int i = 0; i<N; i++) {
				int v = sc.nextInt();
				if(arr[v] == 0 )arr[v] = sc.nextInt();
				else arr2[v]= sc.nextInt();
				
			}
			ans =0;
			search(0);
			System.out.println("#"+t +" " + ans);
			
		}
		sc.close();
	}
	private static void search(int i) {
		if(arr[i] == 99 || arr2[i] == 99) {
			ans=1;
			return;
		}
		if(arr[i] !=0) {
			search(arr[i]);
		}
		if(arr2[i] != 0) {
			search(arr2[i]);
		}
		
	}
}
