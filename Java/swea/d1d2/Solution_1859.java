package swea.d1d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * SWEA 백만 장자 프로젝트
 * 
 * -> 입력에 1,000,000개가 들어오고 매매가가 10000이하이면 최대의 이익은 int의 범위수인 20억은 훨씬 넘는다 -> long으로 결과값 선언
 */
public class Solution_1859 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int T =Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
			long result =0;
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = arr[N-1];
			for(int i = N-2; i>=0; i--) {
				if(max <arr[i]) {
					max = arr[i];
				}else {
					result +=max -arr[i];
				}
			}
			
			System.out.println("#"+t+ " "+ result);
				
		}
	}
}
