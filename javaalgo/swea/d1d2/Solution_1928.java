package javaalgo.swea.d1d2;

import java.util.Scanner;
import java.util.Base64;

public class Solution_1928 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc= sc.nextInt();
		sc.nextLine();
		for(int i=1; i<=tc; i++) {
				String msg= sc.nextLine();
				String decode= new String(Base64.getDecoder().decode(msg));
				System.out.printf("#%d %s%n", i, decode);
		}
		sc.close();
	}
}

