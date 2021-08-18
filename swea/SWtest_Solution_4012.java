package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * SWEA 4012. [모의 SW 역량테스트] 요리사
 * 
 * -> 조합까지는 쉽게 갔는데 조합 후 뽑는 반복문을 생각하는데 시간이 오래걸렸다.
 * 	 이중 포문을 사용해서 i는 0번째부터 j는 i의 다음 +1 부터 조합을 만들어서 시너지 값에 다 더해주는 방식으로 함.
 */
public class SWtest_Solution_4012 {
	static int ans,N;
	static int[][] foods;
	static int[] foodA, foodB;
	static boolean[] isSelected, isSelected2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t =1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			 foods = new int[N][N];
			 foodA = new int[N/2];
			 foodB = new int[N/2];
			 isSelected = new boolean[N];
			 
			for(int i =0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					foods[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans =Integer.MAX_VALUE;
			combination(0,0);
			System.out.println("#"+t+" " +ans);
		}
		
	}
	static void combination(int start, int cnt) {
		if(cnt == N/2) {
			int a =0;
			int b =0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]== true) {
					foodA[a++] = i;
				}else {
					foodB[b++] = i;
				}
			}
			int sumA =0;
			int sumB =0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					sumA+=foods[foodA[i]][foodA[j]];
					sumA+=foods[foodA[j]][foodA[i]];
					sumB+=foods[foodB[i]][foodB[j]];
					sumB+=foods[foodB[j]][foodB[i]];
				}
			}
//			System.out.println(sumA + " " + sumB);
			ans = Math.min(ans, Math.abs(sumA-sumB));
			return;
		}
		for(int i = start; i<N; i++) {
			isSelected[i] = true;
			combination(i+1, cnt+1);
			isSelected[i] = false;
		}
	}
}
