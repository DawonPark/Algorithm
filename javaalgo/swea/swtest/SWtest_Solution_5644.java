package javaalgo.swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 5644 [모의 SW 역량테스트] 무선 충전
 * 
 * 접근
 * 충전소는 두개 이상 겹치지 않음
 * 이동 명령을 받으면서 이동한 좌표를 ArrayList로 저장을 해놓기로함.
 * 
 * -> 중간에 충전소가 입력이 행 먼저 들어오는 줄 알고 잘못 하고 있었음 시간을 많이 씀.(입력 순서 잘보기!)
 * ->겹쳐있을 때가 변수로 해결하려다가 각각 ArrayList 에 몇 번 충전소에 있는지 저장을 해놓고
 * 사이즈가 둘다 0 이상일때 확인을 하고 한쪽만 0이면 그대로 충전에 더해주는 방법으로 해결함.
 *
 * -> 충전소를 내림차순으로 정렬해서 사용하는 방법도 있음
 */
public class SWtest_Solution_5644 {
	static class AP{
		int x, y, c, p; // x y 좌표 , c 충전범위 ,p 처리량
		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			ArrayList<int[]> moveA = new ArrayList<>();
			ArrayList<int[]> moveB = new ArrayList<>();
			String[] data = br.readLine().split(" ");
			int M = Integer.parseInt(data[0]);
			int A = Integer.parseInt(data[1]);
			int aX =1; int aY =1;
			int bX =10; int bY =10;
			moveB.add(new int[] {bX,bY});
			moveA.add(new int[] {aX,aY});
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=1; j<=M; j++) {
					int val = Integer.parseInt(st.nextToken());
					if(i==0) {
						if(val ==0) {
							moveA.add(new int[] {aX,aY});
						}else if(val ==1) {
							aX -=1;
							moveA.add(new int[] {aX,aY});
						}else if(val ==2) {
							aY +=1;
							moveA.add(new int[] {aX,aY});
						}else if(val ==3) {
							aX +=1;
							moveA.add(new int[] {aX,aY});
						}else if(val ==4) {
							aY -=1;
							moveA.add(new int[] {aX,aY});
						}
					}else {
						if(val ==0) {
							moveB.add(new int[] {bX,bY});
						}else if(val ==1) {
							bX -=1;
							moveB.add(new int[] {bX,bY});
						}else if(val ==2) {
							bY +=1;
							moveB.add(new int[] {bX,bY});
						}else if(val ==3) {
							bX +=1;
							moveB.add(new int[] {bX,bY});
						}else if(val ==4) {
							bY -=1;
							moveB.add(new int[] {bX,bY});
						}
					}
				}
			}
			AP[] aps = new AP[A];
			for(int i=0; i<A; i++) {
				data = br.readLine().split(" ");
				aps[i] = new AP(Integer.parseInt(data[1]),Integer.parseInt(data[0]),Integer.parseInt(data[2]),Integer.parseInt(data[3]));
			}
			int result =0;
			for(int i=0; i<=M; i++) {
				ArrayList<Integer> a = new ArrayList<>();
				ArrayList<Integer> b = new ArrayList<>();
				for(int j=0; j<A; j++) {
					if(Math.abs(aps[j].x - moveA.get(i)[0]) + Math.abs(aps[j].y - moveA.get(i)[1]) <= aps[j].c ) {
						a.add(j);
					}
					if(Math.abs(aps[j].x - moveB.get(i)[0]) +Math.abs(aps[j].y - moveB.get(i)[1]) <= aps[j].c ) {
						b.add(j);
					}
				}

				int temp =0;
 				if(a.size() !=0&& b.size() !=0) {
 					for(int k=0; k<a.size(); k++) {
 						for(int l=0; l<b.size(); l++) {
 							if(a.get(k) == b.get(l)) {
 								temp = Math.max(temp, aps[a.get(k)].p);
 							}
 							else {
 								temp = Math.max(temp, aps[a.get(k)].p+ aps[b.get(l)].p);
 							}
 						}
 					}
 				}
 				if(a.size()!=0 && b.size()==0) {
 					for(int k=0; k<a.size(); k++) {
 						temp = Math.max(temp, aps[a.get(k)].p);
 					}
 				}
 				if(a.size()==0 && b.size()!=0) {
 					for(int k=0; k<b.size(); k++) {
 						temp = Math.max(temp, aps[b.get(k)].p);
 					}
 				}
 				
				result+=temp;
			}
			
			System.out.println("#" + t + " " + result);
			
			
		}
		
		
		
	}
}
