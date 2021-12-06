package swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWTest_Solution_5658 {
	static HashSet<Integer> set;
	static char[] nums;
	static int N,K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new char[N];
			String data = br.readLine();
			for(int i=0; i<N; i++) {
				nums[i] = data.charAt(i);
			}
			
			for(int i=0; i<=N-1; i++) {
				password();
				rotate();
			}
			
			ArrayList<Integer> list = new ArrayList<>(set);
			Collections.sort(list, Collections.reverseOrder());
			
			System.out.println("#" + t + " " + list.get(K-1));
			
		}
	}
	private static void rotate() {
		char temp = nums[N-1];
		for(int i = N-1; i>0; i--) {
			nums[i] = nums[i-1];
		}
		nums[0] = temp;
		
	}
	private static void password() {
		for(int i=0; i<N; i+=N/4) {
			String password = "";
			for(int j = i; j< i + N/4; ++j) {
				password +=nums[j];
			}
			set.add(Integer.parseInt(password,16));
		}
	}
	
	
	
}
