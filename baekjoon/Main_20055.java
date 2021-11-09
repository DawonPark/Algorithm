package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_20055 {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] map = new int[2*N];
		boolean[] check = new boolean[N];
		for(int i=0; i<2*N; i++) {
			map[i] = sc.nextInt();
		}
		int time =0;
		while(true) {
			int zero = 0;
			for(int i =0; i<2*N; i++) {
				if(map[i] == 0) zero++;
				if(zero== K) {
					System.out.println(time);
					return;
				}
			}
			int temp = map[2*N-1];
			for(int i= 2*N-1; i>0; i-- ) {
				map[i] = map[i-1];
			}
			map[0] = temp;
			for(int i = N-1; i>0; i--) {
				check[i] = check[i-1];
			}
			check[0] = false;
			check[N-1] = false;
			
			Queue<Integer> queue = new LinkedList<>();
			for(int i =N-1; i>=0; i--) {
				if(check[i]) {
					int idx = i+1;
					if(!check[idx] && map[idx]!=0) {
						map[idx] = map[idx] -1;
						check[idx-1] = false;
						check[idx] =true;
					}
				}
			}
			
			if(map[0]!=0 ) {
				check[0] = true;
				map[0] = map[0] -1;
			}
			time++;
		}
	}
}
