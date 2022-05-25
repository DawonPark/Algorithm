package java. swea.d1d2;

import java.util.Scanner;

public class Solution_1979 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			int num =sc.nextInt();
			int[][] puzzle =new int[num][num];
			int word= sc.nextInt();
			int result =0;
			int length =0; // 길이 체크용 
			for(int r=0; r<num; r++) {
				for(int c=0; c<num; c++) {
					puzzle[r][c]= sc.nextInt();
				}
			}
			//가로 체크
			for(int r=0; r<num; r++) {
				for(int c=0; c<num; c++) {
					if(puzzle[r][c]==1) {
						for(int i=c; i<num; i++) {
							if(puzzle[r][i]==0) {
								c=i;
								break;
							}
							if(i ==num-1&&puzzle[r][i]==1) {
								c=i;
								length++;
								break;
							}
							length++;
						}
						if(length==word) {
							result++;
						}
						length=0;
					}
				}
			}
			// 세로 체크
			for(int c=0; c<num; c++) {
				for(int r=0; r<num; r++) {
					if(puzzle[r][c]==1) {
						for(int i=r; i<num; i++) {
							if(puzzle[i][c]==0) {
								r=i;
								break;
							}
							if(i ==num-1&&puzzle[i][c]==1) {
								r=i;
								length++;
								break;
							}
							length++;
						}
						if(length==word) {
							result++;
						}
						length=0;
					}
				}
			}
			
			
			
			
			System.out.println("#"+t+" "+ result);
		}
		sc.close();
	}
}
