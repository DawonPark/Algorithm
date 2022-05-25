package java. swea.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class D4_Solution_5643 {
	static ArrayList<Integer> l[] , s[]; // 큰, 작은 경우를 담을 ArrayList
	static int N,M,sum;
	static boolean visited[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			l = new ArrayList[N+1];
			s = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				l[i] = new ArrayList<>();
				s[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++) {
				int small = sc.nextInt();
				int lng = sc.nextInt();
				s[small].add(lng);
				l[lng].add(small);
			}
            int ans =0;
			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				sum = 0;
				visited[i] = true;
				longDfs(i);
				shortDfs(i);
				if(sum == N-1) ans++; // 자신을 제외하고 탐색이 가능하다면
			}
			System.out.println("#"+t + " " + ans);
		}
	}
	private static void shortDfs(int idx) {
		for(int i=0; i<s[idx].size(); i++) {
			int next = s[idx].get(i); 
			if(visited[next]) continue;
			visited[next] = true;
			sum++;
			shortDfs(next);
		}
	}
	private static void longDfs(int idx) {
		for(int i=0; i<l[idx].size(); i++) {
			int next = l[idx].get(i); 
			if(visited[next]) continue;
			visited[next] = true;
			sum++;
			longDfs(next);
		}
	}
}
