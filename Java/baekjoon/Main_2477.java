package baekjoon;

import java.util.Scanner;

/*
 * 백준 2477 참외 밭
 * 
 * -> 생각보다 너무 복잡하고 어려웠음 빈칸이 나오는 방향을 생각해서 sub(빈칸)을 계산한 후에
 *  sub가 계산이 안될 때가 있는데 그때의 경우도 포함해줘야함.
 * 
 */
public class Main_2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int north=0, south=0 , west=0, east =0;
		int temp=0;
		int dir =0;
		int sub =0;
		for(int i=0; i<6; i++) {
			 dir = sc.nextInt();
			switch(dir) {
			case 1:
				east = sc.nextInt();
				break;
			case 2:
				west = sc.nextInt();
				break;
			case 3:
				south = sc.nextInt();
				break;
			case 4:
				north = sc.nextInt();
				break;
			}
			if(i==0) {
				temp =dir;
				continue;
			}
			if(dir == 1 && temp==4) {
				sub = north* east;
			}else if(dir ==2 && temp== 3) {
				sub = south* west;				
			}else if(dir ==3 && temp== 1) {
				sub = east* south;				
			}else if(dir ==4 && temp== 2) {
				sub = west*north;				
			}
			temp = dir;
		}
		
		if(sub==0) {
			switch(temp) {
			case 1:
				sub = east * (north-south);
				break;
			case 2:
				sub = west * (south-north);
				break;
			case 3:
				sub = south * (east - west);
				break;
			case 4:
				sub = north * (west - east);
				break;
				
			}
		}
		int length = Math.max(west, east);
		int height = Math.max(north, south);
		System.out.println(((length *height)-sub)*K);
		sc.close();
	}
}
