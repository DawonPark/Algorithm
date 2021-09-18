package swea.d3;

import java.util.Scanner;

public class D3_Solution_5215 {
	static int[][] info;
	static int cal;
	static int N;
	static int answer;
	
	static void combination(int start, int calorie , int score) {
		if(calorie > cal)
			return;
		if(start==N) {
			answer = Math.max(score, answer);
			return;
		}
		combination(start+1, calorie+info[start][1], score+info[start][0]); // 뽑고 넘기기
		combination(start+1, calorie, score); // 다음순서로 넘기기
		
	}
	
	public static void main(String[] args) {
		/*
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t =1; t<=tc; t++) {
			N = sc.nextInt();
			cal = sc.nextInt();
			info = new int[N][2];
			for(int i=0; i<N; i++) {
				info[i][0] = sc.nextInt(); // 맛 점수
				info[i][1] = sc.nextInt(); // 칼로리				
			}
			answer= Integer.MIN_VALUE;
			combination(0,0,0);
			System.out.println("#" + t + " " + answer);
			
		}
		sc.close();
		*/
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int cal = sc.nextInt();
			int[] scores = new int[N+1];
			int[] calories = new int[N+1];
			for(int i=1; i<=N; i++) {
				scores[i] = sc.nextInt();
				calories[i] = sc.nextInt();
			}
			int[][] D = new int[N+1][cal+1];
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=cal; j++) {
					if(calories[i] <=j) {
						D[i][j] = Math.max(D[i-1][j], scores[i] + D[i-1][j-calories[i]]);
					}else {
						D[i][j] = D[i-1][j];
					}
				}
			}
			System.out.println("#" + t + " " + D[N][cal]);
		}
		sc.close();
	}
}
