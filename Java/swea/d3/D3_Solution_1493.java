package java. swea.d3;

import java.util.Scanner;
/*
 * SWEA 수의 새로운 연산
 * 
 * -> 규칙을 찾아서 해결
 * 규칙 : x = 1인 곳을 start라고 생각하고 1 2 4 7 11 의 규칙으로 나가기 때문에 처음에 좌표를 찾아줄 수 있다.
 * 두개의 좌표를 찾고 더한 후 역으로 다시 숫자를 찾는다.
 */
public class D3_Solution_1493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int a = sc.nextInt(); int b = sc.nextInt();
			int start =1;
			int idx = 2;
			while(true) {
				if(a==1) {
					break;
				}
				if(a>=start) {
					start += (idx-1);
					idx++;
				}else {
					start -= (--idx-1);
					break;
				}
			}
			int resultX =a-start+1;
			int resultY =idx-(a-start+1);
			start =1;
			idx=2;
			while(true) {
				if(b==1) {
					break;
				}
				if(b>=start) {
					start += (idx-1);
					idx++;
				}else {
					start -= (--idx-1);
					break;
				}
			}
			resultX+= b-start+1;
			resultY+= idx-(b-start+1);
			
			idx = resultX + resultY;
			start =1;
			for(int i=1; i<idx-1; i++) {
				start+=i;
			}
			System.out.println("#"+t+" " + (start+resultX-1));
		}
		sc.close();
	}
}
