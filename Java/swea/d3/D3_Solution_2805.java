package java. swea.d3;


import java.util.Scanner;

public class D3_Solution_2805 {
	/*
	 * 초기에 leftY, rightY를 2/n으로 설정
	 * x가 2/n일때까지는 1씩 더함. 
	 * 그 이후에는 1씩 빼서 for문을 돌려 result를 구함.
	 */

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int result=0;
			int n= sc.nextInt();
			int[][] farm = new int[n][n];
			for(int i = 0; i < n; i++) {
				String s = sc.next();
				for(int j = 0; j < n; j++) {
					farm[i][j] = s.charAt(j) - '0';
				}
			}
	
			int leftY = n/2;
			int rightY = n/2;
			int x = 0;
			while(x<n) {
				if(x<n/2) {
					for(int i= leftY; i<=rightY; i++) 	{
						result+= farm[x][i];
						}
					if(leftY!=0)
					leftY--;
					if(rightY!=n-1)
					rightY++;
					x++;
					}
				else {
					for(int i= leftY; i<=rightY; i++) 	{
						result+= farm[x][i];
						}
					if(leftY!=n-1)
					leftY++;
					if(rightY!=0)
					rightY--;
					x++;
				}
				
				
			}
			
			
			 
			System.out.println("#" + t + " " + result);
		}
		sc.close();
	}
	
}
