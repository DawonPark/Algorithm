package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 백준 11399 - ATM 퀴즈
 * 
 * -> 줄을 기다린 시간의 총합이므로 최소는 sort후 기다린 시간만큼 더해줌
 */
public class Main_11399 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] people = new int[N];
		for(int i =0; i<N; i++) {
			people[i] = sc.nextInt();
		}
		Arrays.sort(people);
		int ans =0;
		int temp =0;
		for(int i=0; i<N; i++) {
			temp+=people[i];
			ans+=temp;
			
		}
		System.out.println(ans);
		sc.close();
	}
}
