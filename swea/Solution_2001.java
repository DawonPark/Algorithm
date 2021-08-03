package swea;


import java.util.Scanner;

public class Solution_2001 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int n =sc.nextInt();
			int m =sc.nextInt();
			int[][] area= new int[n][n];
			int result=0;
			int temp=0;
			for(int r=0; r<n; r++) {
				for(int c=0; c<n; c++) {
					area[r][c] =sc.nextInt();
				}
			}
			int x=0;
			int y=0;
			for(int i=0; i<(n-m+1)*(n-m+1); i++) {
				for(int r=0; r<m; r++) {
					for(int c=0; c<m; c++) {
						temp+=area[r+x][c+y];
					}
				}
				y++;
				if(y>(n-m)) {
					y=0;
					x++;
				}
				result =Math.max(temp, result);
				temp=0;
			}
			x=0;
			y=0;
			
			
			System.out.println("#"+t+" " + result);
		}
		sc.close();
	}
}
