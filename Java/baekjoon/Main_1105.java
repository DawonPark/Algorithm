package baekjoon;

import java.util.Scanner;

public class Main_1105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int R = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		for(int i = L; i<=R; i++) {
			int num = i;
			int temp = 0;
			while(num>0) {
				if(num%10 == 8) temp++;
				num/=10;
			}
			ans = Math.min(temp, ans);
			if(ans==0) break;
		}
		System.out.println(ans);
	}
}
