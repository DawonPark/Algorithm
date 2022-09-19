package javaalgo.swea.d3;

import java.util.Arrays;
import java.util.Scanner;

public class D3_Solution_1240 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			int max = 0;
			boolean check = false;
			String result = null;
			for(int i=0; i<N; i++) {
				String msg = sc.nextLine();
				if(!check) {
					for(int j=0; j<msg.length(); j++) {
						if(msg.charAt(j)=='1') {
							check=true;
							result = msg;
						}
					}
				}
			}
			for(int  i=result.length()-1; i>=0; i--) {
				if(result.charAt(i) == '1') {
					max = i;
					break;
				}
			}
			result = result.substring(max-55, max+1);
			int start =0;
			int plus =7;
			int arr[] = new int[8];
			for(int i=0; i<8; i++) {
				String temp = result.substring(start,start+plus);
				start +=plus;
				switch(temp) {
				case "0001101":
					arr[i] = 0;
					break;
				case "0011001":
					arr[i] = 1;
					break;
				case "0010011":
					arr[i] = 2;
					break;
				case "0111101":
					arr[i] = 3;
					break;
				case "0100011":
					arr[i] = 4;
					break;
				case "0110001":
					arr[i] = 5;
					break;
				case "0101111":
					arr[i] = 6;
					break;
				case "0111011":
					arr[i] = 7;
					break;
				case "0110111":
					arr[i] = 8;
					break;
				case "0001011":
					arr[i] = 9;
					break;
				}
			}
			int sum=0;
			int ans=0;
			for(int i=0; i<8;i++) {
				if(i%2==0) {
					sum+=arr[i]*3;
					ans+=arr[i];
				}else {
					sum+=arr[i];
					ans+=arr[i];
				}
			}
			if(sum%10==0) {
				System.out.println("#"+t+" " + ans);
			}else {
				System.out.println("#"+t+" " + 0);
			}
			
		}
	}
}
