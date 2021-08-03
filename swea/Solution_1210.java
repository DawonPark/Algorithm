package swea;

import java.util.Scanner;

public class Solution_1210 {
	private static int[] dr = {0,0,-1};  // 좌 우 위 순으로 감.
	private static int[] dc = {-1,+1,0};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=1; i<=10; i++){
			int start= 0;
			int t= sc.nextInt();
			int[][] ladder = new int[100][100];
		
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					ladder[r][c]=sc.nextInt();
					if(ladder[r][c] ==2) {
						start =  c;
					}
				}
			}
			
			int nr=99, nc=start;
			int dir= 0; // 왼쪽부터볼지 오른쪽부터볼지 
			while(true) {
				if(nc+dc[0]>=0&&nc+dc[0]<=99) {
					if(ladder[nr+dr[0]][nc+dc[0]]==1 &&dir ==0) {
					nr = nr+dr[0];
					nc = nc+dc[0];
					}else {
						dir=1;
					}
					}
				if(nc+dc[1]>=0&&nc+dc[1]<=99) {
					if(ladder[nr+dr[1]][nc+dc[1]]==1 && dir ==1) { // 사다리가 우측에 있는 경우
					nr = nr+dr[1];
					nc = nc+dc[1];
					}
					else {
						dir= 2;
					}
				}
				if(ladder[nr+dr[2]][nc+dc[2]]==1 && dir ==2) { //  사다리가 위쪽에 있는경우
					nr = nr+dr[2];
					nc = nc+dc[2];	
				}else {
					dir=0;
				}
				if(nr==0)
					break;
//				System.out.println(t+"의 " + "nr : " + nr + "nc : " + nc);
			}
			
			System.out.println("#"+t+" " + nc);
		}
	}
}