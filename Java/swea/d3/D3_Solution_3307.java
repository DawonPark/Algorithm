package swea.d3;

import java.util.Scanner;

public class D3_Solution_3307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] LIS = new int[N];
			for(int i =0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			int ans =0;
			for(int i = 0; i<N; i++) {
				LIS[i] = 1;
				for(int j = 0; j<i; j++) {
					if(arr[i]>arr[j] && LIS[i]< LIS[j]+1) LIS[i] = LIS[j]+1;
					if(ans<LIS[i]) ans =LIS[i];
				}
			}
			
			
			System.out.println("#" + t +" " + ans);
		}
	}
}
