package baekjoon;

import java.util.Scanner;
/*
 * 백준 2851 - 슈퍼마리오
 * 
 * -> 100에 가까운 숫자 같을 때는 큰 수 출력 -> 같을 때 큰수는 같을때 더한 값으로 세팅하면 됨.
 */
public class Main_2851 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] mushroom = new int[10];
		for(int i =0; i<10; i++) {
			mushroom[i] = sc.nextInt();
		}
		int goal =100;
		int sum = 0;
		int temp =0;
		for(int i=0; i<10; i++) {
			temp+=mushroom[i];
			if(Math.abs(goal-sum) >= Math.abs(goal-temp)){
				sum= temp;
			}
		}
		
		System.out.println(sum);
		sc.close();
	}
	
}
