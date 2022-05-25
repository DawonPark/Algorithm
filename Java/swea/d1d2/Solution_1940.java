package java. swea.d1d2;

import java.util.Scanner;

class Solution_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int command = sc.nextInt();
			int speed=0;
			int distance=0;
			for(int i=0; i<command; i++) {
				int mode =sc.nextInt();
				if(mode==1) {
					int acceleration=sc.nextInt();
					speed+=acceleration;
					distance+=1*speed;
				}	
				else if(mode==2) {
					int acceleration=sc.nextInt();
					if(speed<acceleration)
						speed=0;
					else
						speed-=acceleration;
					distance+=1*speed;
				}
				else if(mode==0) {
					distance+=1*speed;
				}
			}
			System.out.println("#"+t+" "+ distance);
		}
		sc.close();
	}
}
