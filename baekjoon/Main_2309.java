package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 백준 2309 일곱 난쟁이
 * 
 * -> 조합 이용 한번 출력하고 또 출력하는게 있을 수 있기 때문에 한번만 출력하도록 check 설정
 */
public class Main_2309 {
	static int[] smurf;
	static int[] answer;
	static boolean check;
	public static void main(String[] args) {
		 smurf = new int[9];
		 answer = new int[7];
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			smurf[i] = sc.nextInt();
		}
		Arrays.sort(smurf);
		combination(0,0);
		
	}

	private static void combination(int start, int cnt) {
		if(check==true) return;
		if(cnt == 7) {
			int sum =0;
			for(int k : answer) {
				sum+=k;
			}
			if(sum!=100) return;
			check=true;
			for(int k : answer) {
				System.out.println(k);
			}
			return;
		}
		
		for(int i = start; i<9; i++) {
			answer[cnt] = smurf[i];
			combination(i+1,cnt+1);
		}
		
		
	}
	
	
}
