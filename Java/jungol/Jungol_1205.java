package java. java.jungol;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 정올 - 조커
 * 
 * -> 조커 개수를 세주고 sort팅한 arr에서 맞춰줌
 */
public class Jungol_1205 {
	static int N,ans;
	static int[] cards;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cards = new int[N];
		int joker =0;
		for(int i=0; i<N; i++) {
			cards[i]= sc.nextInt();
			if(cards[i]==0) {
				joker++;
			}
		}
		Arrays.sort(cards);
		for(int i =0; i<N; i++) {
			if(cards[i] == 0) continue;
			solve(i, 1, joker);
		}
		if(ans == 0) ans=joker;
		System.out.println(ans);
	}
	
	static void solve(int n, int count,int joker) {
		if(n==N-1) {
			ans = Math.max(ans, count+joker);
			return;
		}
		if(cards[n+1]==cards[n]+1) {
			solve(n+1,count+1,joker);
			return;
		}
		if(cards[n+1]==cards[n]) {
			solve(n+1,count,joker);
			return;
		}
		
		if(cards[n+1]-cards[n]-1<=joker) {
			solve(n+1,count+cards[n+1]-cards[n],joker-(cards[n+1]-cards[n]-1));
		}else {
			ans = Math.max(ans, count+joker);
		}
		
		
	}
	
}
