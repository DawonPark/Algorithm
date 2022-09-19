package javaalgo.swea.d4;

import java.util.Arrays;
import java.util.Scanner;

public class D4_Solution_8458 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
 		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int ans = 0;
			
			int max = Math.abs(sc.nextInt())+ Math.abs(sc.nextInt());
			boolean check = (max%2==0 ? true:false); // 짝수면 true 홀수면 false
			for(int i=1; i<N; i++) {
				int sum = Math.abs(sc.nextInt())+ Math.abs(sc.nextInt());
					if(sum%2==0 && check==false) { // 짝수인데 홀수가 나오면
						ans =-1;
						// 헤맨 곳 : break, continue를 하면 안되는 이유 입력이 쌓여있음. 
					}
					if(sum%2==1 && check==true) {
						ans =-1;
					}
				max = Math.max(sum, max);
			}
			int sum =0;
			if(ans!=-1) {
				while(true) {
					if(sum < max || (sum-max)%2!=0) {
						sum+=++ans;
					}else break;
				}
			}
			System.out.println("#" + t + " " +ans);
		}
 		sc.close();
	}
}
