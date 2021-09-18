package swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_Solution_1874 {
	/*
	 * 	 문자 의미
	 *  . 평지(전차 들어갈 수 있음)
	 *  * 벽돌로 만들어진 벽 -> 포탄에 부서짐
	 *  # 강철로 만들어진 벽 -> 포탄에 부서지지 않음
	 *  - 물 (전차 못들어감)
	 *  ^ 위쪽을 바라보는 전차(아래 평지)
	 *  v 아래쪽을 바라보는 전차(아래 평지)
	 *  < 왼쪽을 바라보는 전차(아래 평지)
	 *  > 오른쪽을 바라보는 전차(아래 평지)
	 *  
		문자	동작
		U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
		L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
		R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
		S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		
	 */
	static char[][] map;
	static int height;
	static int width;
	
	// 현재 위치와 방향을 받아서 사용
	static void shoot(int x, int y, int dir) {
		if(dir==0) {
			for(int i=x-1; i>=0; i--) { // 위쪽으로 쏠 때
				
				if(map[i][y]== '*') {   // 벽돌이라면 부서짐
					map[i][y]='.'; 
					return;
				}
				if(map[i][y]=='#') {    // 강철이면 끝
					return;
				}
	
			}
		}
		if(dir==1) {
			
			for(int i=x+1; i<height; i++) { // 아래쪽으로 쏠때
				
				if(map[i][y]== '*') {   // 벽돌이라면 부서짐
					map[i][y]='.'; 
					return;
				}
				if(map[i][y]=='#') {    // 강철이면 끝
					return;
				}
				
			}
			
		}
		if(dir==2) {

			for(int i=y-1; i>=0; i--) { // 왼쪽으로 쏠때
				
				if(map[x][i]== '*') {   // 벽돌이라면 평지만들고 나감
					map[x][i]='.'; 
					return;
				}
				if(map[x][i]=='#') {    // 강철이면 끝
					return;
				}
				
			}
			
		}
		if(dir==3) {
			
			for(int i=y+1; i<width; i++) { // 오른쪽으로 쏠때
				
				if(map[x][i]== '*') {   // 벽돌이라면 평지만들고 나감
					map[x][i]='.'; 
					return;
				}
				if(map[x][i]=='#') {    // 강철이면 끝
					return;
				}
				
			}
		}
	}
	
	static boolean go (int x, int y) {
		return x>=0&&x <height && y>=0&& y<width && map[x][y] =='.';
	}
	
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc= Integer.parseInt(br.readLine());
			
			for(int t= 1; t<=tc; t++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
				height = Integer.parseInt(st.nextToken());
				width = Integer.parseInt(st.nextToken());
				map = new char [height][];
				for(int i=0; i<height; i++) {
					map[i] = br.readLine().toCharArray();
				}
				br.readLine();
				char command[] = br.readLine().toCharArray();
				int dir = -1; // 전차의 방향 , 0 위쪽 , 1 아래쪽, 2 왼쪽, 3 오른쪽
				int currentX = 0 ,currentY =0;
				for(int i=0; i<height; i++) {
					for(int j=0; j<width; j++) {
						if(map[i][j]== '^') {
							currentX=i;
							currentY=j;
							dir = 0;
						}
						if(map[i][j]== 'v') {
							currentX=i;
							currentY=j;
							dir = 1;
			
						}
						if(map[i][j]== '<') {
							currentX=i;
							currentY=j;
							dir = 2;
							
						}
						if(map[i][j]== '>') {
							currentX=i;
							currentY=j;
							dir = 3;
						}						
					} // 처음 전차 위치와 방향 탐색	
				}
				
				for(int i=0; i<command.length; i++) { // 커맨드 실행 -움직일 떄는 자기 자리를 평지로 세팅, 움직이지 않으면 위치만 바꿈
					if(command[i]=='U') {
						if(go(currentX-1,currentY)) {
							map[currentX][currentY] ='.';
							dir =0;
							map[--currentX][currentY]='^';
						}
						else {
							dir=0;
							map[currentX][currentY]='^';
						}
					}
					if(command[i]=='D') {
						if(go(currentX+1,currentY)) {
							map[currentX][currentY] ='.';
							dir =1;
							map[++currentX][currentY]='v';
						}
						else {
							dir=1;
							map[currentX][currentY]='v';
						}
					}
					if(command[i]=='L') {
						if(go(currentX,currentY-1)) {
							map[currentX][currentY] ='.';
							dir =2;
							map[currentX][--currentY]='<';
						}
						else {
							dir=2;
							map[currentX][currentY] ='<';
						}
					}
					if(command[i]=='R') {
						if(go(currentX,currentY+1)) {
							map[currentX][currentY] ='.';
							dir =3;
							map[currentX][++currentY]='>';
						}
						else {
							dir=3;
							map[currentX][currentY] ='>';
						}
					}
					if(command[i]=='S') {
						shoot(currentX,currentY,dir);
					}
				}
				
				System.out.print("#"+ t+ " ");
				for(int i=0; i<height; i++) {
					for(int j=0; j<width; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				
			}
			
	}
}
