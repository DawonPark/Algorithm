package swea.d3;


import java.util.Scanner;
/*
 *  자석 교착상태 카운트 세기
 *  테스트 케이스의 첫 번째 줄에는 정사각형 테이블의 한 변의 길이가 주어진다. 그리고 바로 다음 줄에 테스트 케이스가 주어진다.
	총 10개의 테스트 케이스가 주어진다.
	1은 N극 성질을 가지는 자성체를 2는 S극 성질을 가지는 자성체를 의미하며 테이블의 윗 부분에 N극이 아랫 부분에 S극이 위치한다고 가정한다.
 */
public class D3_Solution_1220 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int num = sc.nextInt();
			int count = 0;
			int[][] table = new int[num][num];
			for(int x = 0; x<num; x++) {
				for(int y =0; y<num; y++) {
					table[x][y] = sc.nextInt();
				}
			}
			boolean N =false;
			for(int y=0; y<num; y++) {
				N=false;
				for(int x=0; x<num; x++) {
					if(table[x][y]==1) {
						N= true;
					}else if(table[x][y] ==2 && N ==true) {
						count++;
						N=false;
					}
				}
			}
			
			System.out.println("#"+t+" "+count);
			
			
			
		}
		sc.close();
		
	}
}
