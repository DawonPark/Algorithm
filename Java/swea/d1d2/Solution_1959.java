package swea.d1d2;


import java.util.Scanner;

public class Solution_1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc= sc.nextInt();
		for(int t=1;  t<=tc; t++) {
			int result=Integer.MIN_VALUE; 
			int move =0;
			int[] a= new int[sc.nextInt()];
			int[] b= new int[sc.nextInt()];
			for(int i=0; i<a.length; i++) {
				a[i]= sc.nextInt();
			}
			for(int i=0; i<b.length; i++) {
				b[i]= sc.nextInt();
			}
			if(a.length>b.length) {
				move=a.length-b.length;
				int cnt=move;
				for(int j=0; j<=cnt; j++) {
					int temp=0;
					for(int i=0; i<b.length; i++) {
						temp+=a[i+move]*b[i];
					}
					move--;
					result=Math.max(result, temp);
				}
			}
			else if(a.length<=b.length) {
				move=b.length-a.length;
				int cnt=move;
				for(int j=0; j<=cnt; j++) {
					int temp=0;
					for(int i=0; i<a.length; i++) {
						temp+=a[i]*b[i+move];
					}
					move--;
					result=Math.max(result, temp);
				}
			} 

			
			
		System.out.println("#"+t+" "+ result);
		}
		sc.close();
	}
}
