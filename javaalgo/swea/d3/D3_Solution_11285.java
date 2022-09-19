package javaalgo.swea.d3;

import java.util.Scanner;
/*
 * 	보드에 그려진 다트 게임을 생각해보자. 보드에는 중심이 원점이고 반지름이 20,40,60,80,100,120,140,160,180,200 (단위는 mm)인 10개의 원이 그려져 있다.
	각각의 화살은 꽂힌 지점을 감싸는 가장 가까운 원(경계선에 꽂힌 경우도 포함)의 반지름이 20 * (11 - p)인 경우 p점을 획득한다. (1 ≤ p ≤ 10)
	만약 가장 큰 원 바깥에 꽂혔다면 얻는 점수는 없다. N 개의 화살을 던진 위치가 주어지면, 총 몇 점을 얻었는지 계산하자.
	
	-> 원의거리 피타고라스로 이용해서 구해서 계산
 */
public class D3_Solution_11285 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int num = sc.nextInt();
			int score = 0;
			for(int i=0; i<num; i++) {
				int x = sc.nextInt();
				int y=  sc.nextInt();
				double distance = Math.sqrt(x*x + y*y);
				for(int p=10; p>=1; p--) {
					double rad = 20*(11-p);
					if(distance<=rad) {
						score+=p;
//						System.out.println(distance +" " + rad);
						break;
					}
				}
				
				
			}
			System.out.println("#"+ t + " " + score);
		}
		sc.close();
	}
}
