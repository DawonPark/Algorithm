package swea;

import java.util.Arrays;
import java.util.Scanner;

public class D3_Solution_1244 {
	static int cnt;
	static int[] num;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc =Integer.parseInt(sc.nextLine());
		for(int t=1; t<=tc; t++) {
			String[] s = sc.nextLine().split(" ");
			 num =new int[s[0].length()];
			for(int i=0; i<s[0].length(); i++) {
				num[i]= s[0].charAt(i)-'0';
			}
		
			cnt = Integer.parseInt(s[1]);
			
			result=0;
			dfs(0,0);
			System.out.println("#"+t +" " + result);
		}
		sc.close();
	}
	
	public static void dfs(int start, int count) {
		int temp;
		if(count == cnt) {
			
			int cal = 1;
			int tempResult =0;
			for(int i=num.length-1; i>=0; i--) {
				tempResult+=cal*num[i];
				cal=  cal*10;
			}
			result =Math.max(result, tempResult);
			return;
		}
		
		for(int i=start; i<num.length; i++) {
			for(int j= i+1; j<num.length; j++) {
				temp = num[i]; 
				num[i] = num[j];
				num[j] = temp;
				dfs(i, count+1);
				temp = num[i]; 
				num[i] = num[j];
				num[j] = temp;
				
			}
		}
	}
}
