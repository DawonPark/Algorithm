package swea;

import java.util.Scanner;

public class D3_Solution_7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int D = sc.nextInt();
			int[] arr = new int[N+1];
			for(int i=1; i<=N; i++) {
				arr[i] = sc.nextInt();
			}
			int start =0;
			int ans =0;
			for(int i=start; i<=N; i++) {
				boolean check = false;
				int temp = start;
				for(int d = 1; d<=D; d++) {
					if(temp+d >N) continue;
					if(arr[temp+d]==1) {
						start =d+temp;
						check = true;
					}
				}
				
				if(check == false) {
					start+= D;
					if(start >N) break;
					ans++;
				}
			}
			System.out.println("#"+t+" " + ans);
			
		}
	}
}
