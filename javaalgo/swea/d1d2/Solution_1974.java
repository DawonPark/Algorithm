package javaalgo.swea.d1d2;


import java.util.Scanner;

public class Solution_1974 {
	
	public static int sdk(int[][] puzzle) {
		int num[] =new int[10];
		num[0]= 1;
		//가로 테스트
		for(int r=0; r<9; r++){
			for(int c=0; c<9; c++) {
				num[puzzle[r][c]]++;
			}
			for(int k :num ) {
				if(k!=1) {
					return 0;
				}
			}
			num =new int[10];
			num[0] = 1;
		}
		// 가로테스트 통과 세로테스트 시작
		for(int c=0; c<9; c++){
			for(int r=0;r<9; r++) {
				num[puzzle[r][c]]++;
			}
			for(int k :num ) {
				if(k!=1) {
					return 0;
				}
			}
			num =new int[10];	
			num[0] = 1;
		}
		// 세로테스트 통과 격자 테스트 시작
		int r= 0;
		int c= 0;
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					num[puzzle[r++][c]]++;
				}
				if(0<=i&&i<3)
					r=0;
				if(3<=i&&i<6)
					r=0;
				if(6<=i&&i<9)
					r=0;
				c++;
				if(c==9) {
					c=0;
				}
			}
			for(int k :num ) {
				if(k!=1) {
					return 0;
				}
			}		
			num =new int[10];
			num[0] = 1;
		}
			
		
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1; t<=tc; t++) {
			
			int[][] puzzle = new int[9][9];
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					puzzle[r][c]=sc.nextInt();
				}
			}
			
		
			System.out.println("#"+t +" "+ sdk(puzzle));
		}
		sc.close();
	}
}
