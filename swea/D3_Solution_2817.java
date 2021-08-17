package swea;

import java.util.Scanner;
/*
 * A1, A2, ... , AN의 N개의 자연수가 주어졌을 때, 최소 1개 이상의 수를 선택하여 그 합이 K가 되는 경우의 수를 구하는 프로그램을 작성하시오.
 * 
 * -> 부분집합을 구하고 거기서 계산을 실행시킴 아무것도 안뽑았을 떄는 0 이라서 자연수인 조건에는 상관없어서 처리안함
 */
public class D3_Solution_2817 {
	static int N, K;
	static int[] arr;
	static boolean[] isSelected;
	static int ans;
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			isSelected = new boolean[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			ans =0;
			subset(0);
			System.out.println("#"+t +" "+ ans);
		}
		sc.close();
	}
	static void subset(int cnt) {
		if(cnt == N) {
			int result =0;
			for(int i =0; i<N; i++) {
				if(isSelected[i] == false) continue;
				result+=arr[i]; 
			}
			if(result==K) ans++;
			return;
		}
		
		isSelected[cnt] =true;
		subset(cnt+1);
		isSelected[cnt] = false;
		subset(cnt+1);
		
		
	}
}
