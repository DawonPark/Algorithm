package javaalgo.swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 3289 서로소 집합
 * 
 * 서로소 집합을 트리 구조를 사용하여 대표인 것들만 확인하도록 함
 */
public class D4_Solution_3289 {

	
	static int[] parents;
	static int N, M;
	
	static void make() {
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a]== a) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot ==bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			StringTokenizer st= new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			make();
			StringBuilder sb = new StringBuilder("#"+t+" ");
			for(int i=0; i<M; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				int command = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				if(command == 0) {
					union(a,b);
				}else {
//					int aRoot = find(a);
//					int bRoot = find(b);
					if(find(a) ==find(b)) sb.append("1");
					else sb.append("0");
				}
				
			}
			System.out.println(sb);
		}
	}
}
