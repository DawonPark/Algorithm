package swea.d1d2;


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
			// m*m 을 칠 수 있는 횟수는(n-m+1)*(n-m+1)
			for(int i=0; i<(n-m+1)*(n-m+1); i++) {
				for(int r=0; r<m; r++) { // x 와 y를 이용해서 파리채를 이동
					for(int c=0; c<m; c++) {
						temp+=area[r+x][c+y];
					}
				}
				y++; // 오른쪽으로 파리채를 이동시킴
				if(y>(n-m)) { // y가 n-m 보다 커지면 배열에서 파리채가 나가고, 한칸 내린 왼쪽 끝에서 다시가야함.
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
