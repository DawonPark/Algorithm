package java. java.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jungol_2577 {
	static int N,d,k,c;
	static int[] arr;
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		selected = new int[d+1]; 
		int sum = 0;
		for(int i=0; i<k; i++) {
			if(selected[arr[i]] == 0) sum++;
			selected[arr[i]]++;
		}
		int ans =sum;
		for(int i=1; i<N; i++) {
			if(--selected[arr[i-1]] == 0 ) sum--;
			if(selected[arr[(i+k-1)%N]]++ == 0) sum++;
			if(ans<=sum) {
				if(selected[c]== 0) ans = sum+1;
				else ans = sum;
			}
		}
		System.out.println(ans);
	}
}
