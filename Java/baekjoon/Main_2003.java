package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]);
		int M = Integer.parseInt(data[1]);
		data = br.readLine().split(" ");
		int arr[] = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(data[i]);
		}
		int ans=0;
		for(int i=0; i<N; i++) {
			int sum =0;
			for(int j=i; j<N; j++) {
				sum+=arr[j];
				if(sum == M) {
					ans++;
					break;
				}else if(sum > M) {
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
