package swea;

import java.util.Scanner;

public class Solution_1954 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] dx = {1,0,-1,0}; // 오른쪽 아래 왼쪽 위
		int[] dy = {0,1,0,-1};
		int tc= sc.nextInt();
		for(int t=1; t<=tc;t++) {
			int num=sc.nextInt();
			int[][] arr= new int[num][num];
			int dir=0;
			int n=1;
			int index = num;
			int index_2= 1;
			int x=0;
			int y=0;
			while(true) {
				if(index_2==2) {
					index--;
					index_2=0;
				}
				
			if(dir==0) {
				for(int i=0; i<index;i++) {
					arr[y][x]=n;
					if(i!=index-1) {
					x+= dx[0];
					y+= dy[0];
					}
					n++;
				}
				y+=1;
				dir++;
			}
			else if(dir==1) {
				for(int i=0; i<index;i++) {
					arr[y][x]=n;
					if(i!=index-1) {
					x+=dx[1];
					y+=dy[1];
					}
					n++;
				}
				x-=1;
				dir++;
			}
			else if(dir==2) {
				for(int i=0; i<index;i++) {
					arr[y][x]=n;
					if(i!=index-1) {
					x+= dx[2];
					y+= dy[2];
					}
					n++;
					
				}
				y-=1;
				dir++;
			}
			else if(dir==3) {
				for(int i=0; i<index;i++) {
					arr[y][x]=n;
					if(i!=index-1) {
					x+= dx[3];
					y+= dy[3];
					}
					n++;
				}
				dir=0;
				x+=1;
			}
			index_2++;
			if(n>num*num) 
				break;
			}
			System.out.println("#"+t);
			for(int j=0; j<num; j++) {
				for(int k=0; k<num; k++) {
					System.out.print(arr[j][k]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
