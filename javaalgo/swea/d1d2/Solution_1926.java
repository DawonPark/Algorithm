package javaalgo.swea.d1d2;

import java.util.Scanner;

public class Solution_1926 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			String m= Integer.toString(i);
			boolean check = false;
			for(int j=0; j<m.length(); j++) {
				if(m.charAt(j)=='3'||m.charAt(j)=='6'||m.charAt(j)=='9') {
					System.out.print("-");
					check = true;
				}
				else {
					if(j==m.length()-1&&check==false)
					System.out.print(i);					
				}
			}
				System.out.print(" ");
		}
	sc.close();
	}
}
