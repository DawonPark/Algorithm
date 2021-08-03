package baekjoon;

import java.util.Scanner;

public class Main_1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double score[] = new double[num];
		double max =Double.MIN_VALUE;
		for(int i=0; i<num; i++) {
			score[i]= sc.nextInt();
			if(score[i]>max) {
				max= score[i];
			}
		}
		
		double result =0;
		for(double d : score) {
			d = d/max*100;
			result +=d;
		}
	
		result =result/score.length;
		System.out.println(result);
	}
}
