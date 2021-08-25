package baekjoon;

import java.util.Scanner;
/*
 * 백준 2798 - 블랙잭
 * 
 * 3장의 카드 조합 후  -> 계산
 * ans == M 부른 숫자랑 같으면 그냥 멈추면 됨
 */
public class Main_2798 {
	
	static int N,M,ans;
	static int[] cards,result;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		result = new int[3];
		for(int i=0; i<N; i++) {
			cards[i] = sc.nextInt();
		}
		ans = Integer.MAX_VALUE;
		combination(0,0);
		System.out.println(ans);
		sc.close();
	}
	
	static void combination(int start, int cnt) {
		if(cnt ==3) {
			int sum =0;
			for(int k: result) {
				sum +=k;
			}
			if(sum > M) return;
			if(Math.abs(M-sum) <Math.abs(M-ans)) {
				ans = sum;
			}
			
			
			return;
		}
		if(ans == M)return;
		
		
		for(int i=start; i<N; i++) {
			result[cnt] = cards[i];
			combination(i+1, cnt+1);
		}
		
		
	}
	
}
