package baekjoon;

import java.util.Scanner;

public class Main_1011 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t =0 ; t<T; t++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			
			int max = (int) Math.sqrt(Y-X);
			
			if(max == Math.sqrt(Y-X)) System.out.println(2*max -1);
			else if(Y-X <= max*max + max) System.out.println(2*max);
			else System.out.println(2*max + 1);
		}
		sc.close();
	}
}
