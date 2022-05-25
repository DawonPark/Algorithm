package java. java.jungol;

import java.util.Scanner;

public class jungol_1169 {
	static int N;
	static int[] arr;
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int T = sc.nextInt();
		arr = new int[N];
		check = new boolean[7];
		if(T==1) {
			solve1(0);
		}else if(T==2) {
			solve2(1,0);
		}else if(T==3) {
			solve3(0);
		}
		sc.close();
	}

	private static void solve3(int cnt) {
		if(cnt == N) {
			for(int k : arr) {
				System.out.print(k+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=6; i++) {
			if(check[i] == true) continue;
			check[i] = true;
			arr[cnt] = i;
			solve3(cnt+1);
			check[i] = false;
		}
	}

	private static void solve2(int start,int cnt) {
		if(cnt == N) {
			for(int k : arr) {
				System.out.print(k+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=6; i++) {
			arr[cnt] = i;
			solve2(i,cnt+1);
		}
	}

	private static void solve1(int cnt) {
		if(cnt==N) {
			for(int k : arr) {
				System.out.print(k+" ");
			}
			System.out.println();
			return;
		}
		for(int i=1; i<=6; i++) {
			arr[cnt] = i;
			solve1(cnt+1);
		}
		
	}
}
