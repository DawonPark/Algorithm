package baekjoon;

import java.util.Scanner;

public class Main_1027 {
	static double[] buildings;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		buildings = new double[N];
		for(int i = 0 ; i < N; i++) {
			buildings[i] = sc.nextInt();
		}
		int ans =0;
		for(int i=0; i<N; i++) {
			int temp = check(i);
			if(ans < temp) ans = temp;
		}
		System.out.println(ans);
		
	}
	
	
	public static int check(int idx) {
		int views = 0; // 보이는 건물의 수
		double temp = 0; // 기울기 저장
		// <--- 왼쪽으로 바라볼 때
		for(int i=idx-1; i>=0; i--) {
			double slope =  (buildings[idx] - buildings[i]) / (idx - i);
			if(i == idx-1 ) {
				views++;
				temp = slope;
			}
			
			if(temp > slope) {
				views++;
				temp = slope;
			}
		}
		temp=0;
		// ---> 오른쪽으로 바라볼 때
		for(int i=idx+1; i<N; i++) {
			double slope =  (buildings[i] - buildings[idx]) / (i - idx);
			if(i == idx+1 ) {
				views++;
				temp = slope;
			}
			
			if(temp < slope) {
				views++;
				temp = slope;
			}
		}
		
		return views;
	}
}
