package baekjoon;

import java.util.Scanner;

public class Main_8911 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for(int t =1; t<=T; t++) {
			String data = sc.nextLine();
			char[] command = new char[data.length()];
			for(int i = 0; i<data.length(); i++) {
				command[i] = data.charAt(i);
			}
			
			int maxX,minX,minY,maxY,x,y,dir;
			x=y=dir=maxX = minX = minY = maxY =0; 
			int[] dx = {-1,0,1,0}; // 북 , 동, 남 , 서
			int[] dy = {0,1,0,-1};
			for(int i=0; i<command.length; i++) {
				switch(command[i]) {
					case 'F':
						x = x+dx[dir];
						y = y+dy[dir];
						maxX = Math.max(maxX, x);
				        minX = Math.min(minX, x);
				        maxY = Math.max(maxY, y);
				        minY = Math.min(minY, y);
						break;
					case 'B':
						x = x -dx[dir];
						y = y -dy[dir];
						maxX = Math.max(maxX, x);
				        minX = Math.min(minX, x);
				        maxY = Math.max(maxY, y);
				        minY = Math.min(minY, y);
						break;
					case 'R':
							if(dir==3) dir =0;
							else dir++;
						break;
					case 'L':
							if(dir==0) dir =3;
							else dir--;
						break;
				}
			}
			System.out.println(((Math.abs(maxX - minX) * Math.abs(maxY - minY))));
		}
		
		sc.close();
	}
}
