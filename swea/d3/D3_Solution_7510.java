package swea.d3;

import java.util.Scanner;

public class D3_Solution_7510 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			int N = sc.nextInt();
			int ans =1; // 자기 자신 숫자도 포함해야하므로 1
			for(int i =1; i<=N/2; i++) {  // 예시로 15는 7이상으로 만들 수 없음
				int start = i;
				int sum =0;
				while(true) {
					sum+=start;
					start++;
					if(sum==N) {
						ans++;
						break;
					}
					if(sum>N) break;
				}
			}
			System.out.println("#"+t + " " +ans);
			
		}
		sc.close();
	}


}
