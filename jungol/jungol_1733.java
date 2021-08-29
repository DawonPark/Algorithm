package jungol;

import java.util.Scanner;

public class jungol_1733 {
	public static void main(String[] args) {
		int dx[] = {0,1,1,1}; // 오른쪽 , 아래 , 왼아래대각, 오른아래대각
		int dy[] = {1,0,1,-1};
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[19][19];
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int x =0;
		int y =0;
		for(int i=0; i<19; i++) {
			for(int j=0; j<19; j++) {
				if(arr[i][j]==1) {
						 x = i; 
						 y = j;
						for(int d=0; d<4; d++) {
							int count =1;
							int nx =i;
							int ny =j;
							if(nx-dx[d]>=0&& nx-dx[d]<=18 && ny-dy[d]>=0 && ny-dy[d]<=18) {
								if(arr[nx-dx[d]][ny-dy[d]] == 1) {
									continue;
								}
							}
							for(int k=0; k<5; k++) {
								  nx = nx+dx[d];
								  ny = ny+dy[d];
								if(nx<0 ||  nx>=19 || ny<0 || ny>=19 ) {
									if(count==5) {
										System.out.println("1");
										if(nx > x && ( d==3 )) {
											x= nx - dx[d];
											y= ny - dy[d];
										}
										System.out.println((x+1) + " " + (y+1));
										System.exit(0);
									}
									count =0;
									break;
								}
								if(arr[nx][ny]== 1) {
//									System.out.println(nx + " " + ny);
									count++;
								}else {
									if(count==5) {
										System.out.println("1");
										if(nx > x && ( d==3 )) {
											x= nx - dx[d];
											y= ny - dy[d];
										}
										System.out.println((x+1) + " " + (y+1));
										System.exit(0);
									}
									break;
								}
							}
						}
				}
				if(arr[i][j]==2) {
						 x = i; 
						 y = j;
						for(int d=0; d<4; d++) {
							int nx =x;
							int ny =y;
							int count =1;
							if(nx-dx[d]>=0&& nx-dx[d]<=18 && ny-dy[d]>=0 && ny-dy[d]<=18) {
								if(arr[nx-dx[d]][ny-dy[d]] == 2) {
									continue;
								}
							}
							for(int k=0; k<5; k++) {
								 nx = nx+dx[d];
								 ny = ny+dy[d];
								if(nx<0 ||  nx>=19 || ny<0 || ny>=19 ) {
									if(count==5) {
										System.out.println("2");
										if(nx > x &&( d==3)) {
											x= nx - dx[d];
											y= ny - dy[d];
										}
										System.out.println((x+1) + " " + (y+1));
										System.exit(0);
									}
									count =0;
									break;
								}
								if(arr[nx][ny]== 2) {
									count++;
								}else {
									if(count==5) {
										System.out.println("2");
										if(nx > x && ( d==3)) {
											x= nx - dx[d];
											y= ny - dy[d];
										}
										System.out.println((x+1) + " " + (y+1));
										System.exit(0);
									}
									break;
								}
							}
						}
					
				}
			}
		}
		
		System.out.println("0");
		
	}
}
