package baekjoon;

import java.util.Scanner;

public class Main_9251 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<= s1.length(); i++) {
			dp[i][0]=0;
		}
		for(int i=0; i<= s2.length(); i++) {
			dp[0][i]=0;
		}
		for(int i=1; i<= s1.length(); i++) {
			for(int j=1; j<= s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+1;
				else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
