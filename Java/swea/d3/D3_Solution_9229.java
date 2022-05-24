package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

/*
 * 한빈이는 퇴근길에 스팟마트에 들러 과자 두 봉지를 사서 양 손에 하나씩 들고 가려고 한다.
	스팟마트에는 N개의 과자 봉지가 있으며, 각 과자 봉지는 ai그램의 무게를 가진다.
	배가 많이 고픈 한빈이는 최대한 양이 많은 (무게가 많이 나가는) 과자 봉지를 고르고 싶으나,
	과자 두 봉지의 무게가 M 그램을 초과하면 무거워서 과자를 들고 다닐 수 없다.
	한빈이가 들고 다닐수 있는 과자들의 최대 무게 합을 출력하라. 한빈이는 과자를 “정확히” 두 봉지 사야 함에 유의하라.
	
	-> 정확히 두봉지 두 가지만 선택하는 순열로 접근
	-> 정확히 2개를 선택하려면
 */
public class D3_Solution_9229 {
	static int N;
	static int M;
	static int[] snacks;
	static int result;

	public static void combination(int start, int cnt, int weight) {
		if(M <weight) {
			return;
		}
		if(cnt == 2) {		
				result = Math.max(result, weight);
				return;
		}
		for(int i =start; i<N; i++) { 
			combination(i+1,cnt+1,weight+snacks[i]);
			
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int tc = Integer.parseInt(br.readLine());
		for(int t =1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			 N = Integer.parseInt(st.nextToken()); //N 과자의 개수
			 snacks = new int[N];
			 M = Integer.parseInt(st.nextToken()); //M 초과 무게
			
			 
			 st = new StringTokenizer(br.readLine(), " ");
			for(int i =0; i<N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			 result =Integer.MIN_VALUE;
			 combination(0,0,0);
			 if(result == Integer.MIN_VALUE ) result =-1;
			 
			 System.out.println("#"+t+" " + result);
		}
		
	}
}
