package javaalgo.swea.d1d2;

import java.util.Scanner;

class Solution_1284 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i = 1; i<= testcase; i++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();
			int a = 0;
			int b = 0;
			a = w*p;
			if(w>r)
				b= q+ (w-r)*s;
			else
				b= q;

			
			if(a>b) 
				System.out.println("#" + i+" " + b);
			else
				System.out.println("#" + i+" "+ a);	
		}
		sc.close();
	}
}
