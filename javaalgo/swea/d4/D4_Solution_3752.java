package javaalgo.swea.d4;

import java.util.Scanner;

public class D4_Solution_3752 {
	static int N;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			int sum = 0;
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum+= arr[i];
			}
			
			visited = new boolean[sum+1];
			visited[0] = true;
			int max = 0;
			
			for(int i=0; i<N; i++) {
				max+= arr[i];
				for(int j=max; j>=0; j--) {
					if(visited[j]) {
						visited[j+arr[i]] = true;
					}
				}
				visited[arr[i]]= true;
			}
			
			int ans =0;
			for(boolean b : visited) {
				if(b) ans++;
			}
			System.out.println("#"+t+ " " + ans);
		}
		sc.close();
	}
	
}
