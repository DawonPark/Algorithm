package java. swea.d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
/*
 * SWEA 5948 - 새샘이의 7-3-5 게임
 * 
 * -> 조합으로 합을 만들어주고 중복 때문에 Set 이용 후 정렬을 위해 List
 */
public class D3_Solution_5948 {
	static int num[], temp[];
	static HashSet<Integer> result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			num = new int[7];
			temp = new int[3];
			result = new HashSet<Integer>();
			for(int i=0; i<7; i++) {
				num[i] = sc.nextInt();
			}
		
			combination(0,0);
			ArrayList<Integer> list = new ArrayList<Integer>(result);
			Collections.sort(list);
			System.out.println("#" + t + " " +list.get(list.size()-5));
		}
		sc.close();
	}

	private static void combination(int cnt ,int start) {
		
		if(cnt==3) {
			int temRes = 0;
			for(int v : temp) {
				temRes+=v;
			}
			result.add(temRes);
			return;
		}
		
		
		for(int i=start; i<7; i++) {
			temp[cnt] = num[i];
			combination(cnt+1,i+1);
		}
		
	}
}
