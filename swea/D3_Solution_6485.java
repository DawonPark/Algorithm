package swea;

import java.util.Scanner;
/*
 * SWEA 6485 - 삼성시의 버스노선
 * 
 * -> 배열로 관리하려다가 클래스를 만들어서 일차원 배열로 해결함.
 */
public class D3_Solution_6485 {
	static class Pair {
		int start;
		int end;
		public Pair(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			Pair[] list = new Pair[N];
			for(int i=0; i<N; i++) {
				list[i] = new Pair(sc.nextInt(),sc.nextInt());
			}
			int P = sc.nextInt();
			System.out.print("#"+t+" ");
			for(int i=1; i<=P; i++) {
				int count =0;
				int num = sc.nextInt();
				for(Pair p : list) {
					if(p.start<=num&& num<=p.end) count++;
				}
				System.out.print(count+ " ");
			}
			System.out.println();
			
		}
		sc.close();
	}
}
