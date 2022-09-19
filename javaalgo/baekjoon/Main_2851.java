package javaalgo.baekjoon;

import java.util.Scanner;

/*
 * 諛깆� 2851 - �뒋�띁留덈━�삤
 * 
 * -> 100�뿉 媛�源뚯슫 �닽�옄 媛숈쓣 �븣�뒗 �겙 �닔 異쒕젰 -> 媛숈쓣 �븣 �겙�닔�뒗 媛숈쓣�븣 �뜑�븳 媛믪쑝濡� �꽭�똿�븯硫� �맖.
 */
public class Main_2851 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++) {
			mushroom[i] = sc.nextInt();
		}
		int goal = 100;
		int sum = 0;
		int temp = 0;
		for (int i = 0; i < 10; i++) {
			temp += mushroom[i];
			if (Math.abs(goal - sum) >= Math.abs(goal - temp)) {
				sum = temp;
			}
		}

		System.out.println(sum);
		sc.close();
	}

}
