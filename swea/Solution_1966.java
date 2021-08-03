package swea;

//import java.util.Arrays;
import java.util.Scanner;

public class Solution_1966 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		N=sc.nextInt();
		for(int t=1; t<=N; t++) {
			int num =sc.nextInt();
			int arr[] = new int[num];
			for(int i=0; i<num; i++) {
				arr[i]= sc.nextInt(); 
			}
			int temp=0;
		//	Arrays.sort(arr);
			for(int j=0; j<arr.length; j++) {
				for(int k=j+1;k<arr.length; k++) {
					if(arr[j]>arr[k]) {
						temp=arr[k];
						arr[k]= arr[j];
						arr[j]= temp;
					}
				}
			}
			System.out.print("#"+t+" ");
			for(int e : arr ) {
				System.out.print(e+" ");
			}
			System.out.println();
		}
		sc.close();
	}
}
