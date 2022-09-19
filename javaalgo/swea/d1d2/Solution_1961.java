package javaalgo.swea.d1d2;

import java.util.Scanner;

public class Solution_1961 {
	static int num;
	
	public static int[][] rotation(int[][] array){
		int r = num;
		int c = 0;
		int[][] result = new int[num][num];
		for(int i =0; i<num; i++) {
			for(int j=0; j<num; j++) {
				result[i][j]= array[--r][c];
				if(r==0) {
					r=num;
				}
			}
			c++;
		}
		return result;
	}
	
	public static void main(String[] args) {
			
		Scanner sc= new Scanner(System.in);
		int tc= sc.nextInt();
		for(int t=1; t<=tc; t++) {
			num= sc.nextInt();
			int[][] array =new int[num][num];
			for(int i =0; i<num; i++) { // 값 할당
				for(int j=0; j<num; j++) {
					array[i][j]= sc.nextInt();
				}
			}
				int[][] result_90 =rotation(array);
				int[][] result_180 = rotation(result_90);
				int[][] result_270 = rotation(result_180);
				System.out.println("#"+t);
				for(int r=0; r<num; r++) 
				{
				for(int c=0; c<num; c++) {System.out.print(result_90[r][c]);}
				System.out.print(" ");
				
				for(int c=0; c<num; c++) {System.out.print(result_180[r][c]);}
				System.out.print(" ");
				
				for(int c=0; c<num; c++) {System.out.print(result_270[r][c]);}
				System.out.print(" ");
				System.out.println();
				}
		}
		sc.close();
	}
}
