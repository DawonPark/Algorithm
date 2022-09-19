package javaalgo.swea.d3;

import java.util.Scanner;

public class D3_Solution_12051 {
		
	
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int tc= sc.nextInt();
			for(int t=1; t<=tc; t++) {
				long n = sc.nextLong();
				int d = sc.nextInt();
				int g = sc.nextInt();
			
				boolean possible = false;
				for(int i=1; i<=n; i++) {
					if(!((d!=0 && g==0) || (d!=100 && g==100))) {
						if(i*d%100==0) {
							possible = true;
							break;
						}
					}
				}
				if(possible) {
					System.out.println("#"+t+" "+ "Possible");
				}else {
					System.out.println("#"+t+" "+ "Broken");
				}
			}
			sc.close();
		}
}
