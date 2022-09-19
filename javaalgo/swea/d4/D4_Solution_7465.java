package javaalgo.swea.d4;

import java.util.HashSet;
import java.util.Scanner;
/*
 * SWEA 7465 창용 마을 무리의 개수
 * 
 * -> 서로소 집합을 구한 뒤 find 값들을 set에 add후 size로 개수를 구함.
 */
public class D4_Solution_7465 {
	static int N, M;
	static int[] parents;
	
	static void make() {
		for(int i=0; i<N+1; i++) {
			parents[i] = i;
		}
	}
	static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
				
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			parents = new int[N+1];
			make();
			for(int i=0; i<M; i++) {
				union(sc.nextInt(),sc.nextInt());
			}
			HashSet<Integer> hs = new HashSet<>();
			for(int i=1; i<N+1; i++) {
				hs.add(find(i));
			}
			System.out.println("#" + t + " " +hs.size());
			
			
			
		}
		sc.close();
	}
	
}
