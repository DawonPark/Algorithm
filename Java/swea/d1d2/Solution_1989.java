package java. swea.d1d2;

import java.util.Scanner;

public class Solution_1989 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc= Integer.parseInt(sc.nextLine());
		for(int t=1; t<=tc; t++) {
			int result =0;
			String msg = sc.nextLine();
			msg.trim();
			String front = " ";
			String end= " ";
			String endReverse= "";
			if(msg.length()%2==1) {
				 end = msg.substring(msg.length()/2,msg.length());
				 front = msg.substring(0,msg.length()/2+1);
			}
			else if(msg.length()%2==0) {
				 end = msg.substring(msg.length()/2,msg.length());
				 front = msg.substring(0,msg.length()/2);
			}
			for(int i=end.length()-1; i>=0; i--)
			{
				endReverse+=end.charAt(i);
			}
			if(front.equals(endReverse)==true){
				result=1;
			}
			System.out.println("#"+t+" "+ result);
		}
		sc.close();
	}
}
