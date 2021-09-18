package swea.d1d2;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1983 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int tc=sc.nextInt();
		//N 학생수 K 알고싶은 학생의 번호
		for(int t=1; t<=tc; t++) {
			int N= sc.nextInt();
			int K= sc.nextInt();
			int[] score = new int[N];
			for(int i=0; i<N; i++) {
				score[i]= 35*sc.nextInt() + 45*sc.nextInt() + 20*sc.nextInt();
			}
			int[] grade = new int[N];
			grade= Arrays.copyOf(score, score.length);
			Arrays.sort(grade);
			int index=0;
			for(int i=0; i<grade.length; i++) {
				if(grade[i]== score[K-1]) {
					index =i;
				}
			}
			
			if(index<N/10) {
				System.out.println("#"+t +" " + "D0");
			}
			else if(N/10<=index&&index<2*N/10) {
				System.out.println("#"+t +" " + "C-");
			}
			else if(2*N/10<=index&&index<3*N/10) {
				System.out.println("#"+t +" " + "C0");
			}
			else if(3*N/10<=index&&index<4*N/10) {
				System.out.println("#"+t +" " + "C+");
			}
			else if(4*N/10<=index&&index<5*N/10) {
				System.out.println("#"+t +" " + "B-");
			}
			else if(5*N/10<=index&&index<6*N/10) {
				System.out.println("#"+t +" " + "B0");
			}
			else if(6*N/10<=index&&index<7*N/10) {
				System.out.println("#"+t +" " + "B+");
			}
			else if(7*N/10<=index&&index<8*N/10) {
				System.out.println("#"+t +" " + "A-");
			}
			else if(8*N/10<=index&&index<9*N/10) {
				System.out.println("#"+t +" " + "A0");
			}
			else {
				System.out.println("#"+t +" " + "A+");
			}
			
		}
		sc.close();
	}
}
