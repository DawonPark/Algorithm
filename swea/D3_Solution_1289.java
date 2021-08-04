package swea;

import java.util.Scanner;

public class D3_Solution_1289
{
	public static void main(String[] args) {
		// 100 -> 2번  010 ->2 번 001 ->1번 1010 ->  4번 
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t =1; t<=tc; t++) {
			int count=0;
			
			char[] arr = sc.next().toCharArray();
			if(arr[0]=='1') {
				count = 1;
			}
			
			for(int i=1; i<arr.length; i++) {
				if(arr[i] !=arr[i-1]) {
					count++;
				}
			}
			
			System.out.println("#"+ t +" " + count);
		}
		sc.close();
	}
}
