package java. swea.d3;

import java.util.Scanner;
/*	퀴즈 대회에 참가해서 우승을 하게 되면 보너스 상금을 획득할 수 있는 기회를 부여받는다
	우승자는 주어진 숫자판들 중에 두 개를 선택에서 정해진 횟수만큼 서로의 자리를 위치를 교환할 수 있다.
	정해진 횟수만큼 숫자판을 교환했을 때 받을 수 있는 가장 큰 금액을 계산해보자.
	
	-> 자리수를 한번씩 다 바꿔봐야한다고 생각해서 완전탐색으로 풀기로함 -> 하나 뽑고 다음꺼 뽑는 bfs(재귀함수) 사용
 */
public class D3_Solution_1244 {
	static int cnt;
	static int[] num;
	static int result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc =Integer.parseInt(sc.nextLine());
		for(int t=1; t<=tc; t++) {
			String[] s = sc.nextLine().split(" ");
			 num =new int[s[0].length()];
			for(int i=0; i<s[0].length(); i++) {
				num[i]= s[0].charAt(i)-'0';
			}
		
			cnt = Integer.parseInt(s[1]);
			
			result=0;
			dfs(0,0);
			System.out.println("#"+t +" " + result);
		}
		sc.close();
	}
	
	public static void dfs(int start, int count) {
		int temp;
		if(count == cnt) {
			int cal = 1;
			int tempResult =0;
			for(int i=num.length-1; i>=0; i--) {
				tempResult+=cal*num[i];
				cal=  cal*10;
			}
			result =Math.max(result, tempResult);
			return;
		}
		
		for(int i=start; i<num.length; i++) {
			for(int j= i+1; j<num.length; j++) {// 완탐
				temp = num[i]; 
				num[i] = num[j];
				num[j] = temp;
				dfs(i, count+1); // i 로 준 이유는 123 에서 3번 바꾸는 방법에서 213 -> 123 -> 213 도 가능해야함,
								   //i+1로 주면 cnt가 배열의 길이넘어가거나 -1일 떄 자기자신이 들어가지 않음 
				temp = num[i]; 
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
}
