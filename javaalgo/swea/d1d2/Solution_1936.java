package javaalgo.swea.d1d2;

import java.util.Scanner;

public class Solution_1936 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		if(a==1&&b==2) {
			System.out.println("B");
		}
		if(a==1&&b==3){
			System.out.println("A");
		}
		if(a==2&&b==3){
			System.out.println("B");
		}
		if(a==3&&b==2) {
			
			System.out.println("A");
		}
		sc.close();
	}
}
