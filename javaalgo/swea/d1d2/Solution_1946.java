package javaalgo.swea.d1d2;

import java.util.Scanner;

public class Solution_1946 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc =Integer.parseInt(sc.next());
		for(int t=1; t<=tc; t++) {
			int line= Integer.parseInt(sc.next());
			System.out.println("#" + t + " ");
			char[] c =new char[line];
			int[] num= new int[line];
			for(int i=0; i<line; i++) {
				c[i]=sc.next().charAt(0);
				num[i]=Integer.parseInt(sc.next());
			}
			int index=0;
			for(int i=0; i<line; i++) {
				for(int j=0; j<num[i]; j++) {
					System.out.print(c[i]);
					index++;
					if(index==10) {
						System.out.println();
						index=0;
					}
				}
			}
			System.out.println();
 		}
		sc.close();
	}
}
