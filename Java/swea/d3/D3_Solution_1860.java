package swea.d3;

import java.util.Arrays;
import java.util.Scanner;
/*
 * SWEA 1860 - 진기의 최고급 붕어빵
 * 
 * -> 붕어빵을 그 시간마다 체크할 필요는 없다고 생각함. 사람이 2 4 6 8 올 때 1개의 붕어빵을 만들 수 있는 시간이 1 이라면
 * 2가 왔을때 1개의 붕어빵과 붕어빵이 다음만들어 지는 시간을 2로 세팅 4가오면 한개를 만들고 3로 세팅 6이 오면 한개를 만들고 4로 세팅
 * 이런 식으로 하면 붕어빵을 줄 수 있는지 아닌지 체크 할 수 있음
 * -> 사람들이 들어오는 입력시간이 내림차순이아니라서 sort를 해줌  
 */
public class D3_Solution_1860 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		outer : for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] people = new int[N];
			for(int i=0; i<N; i++) {
				people[i] = sc.nextInt();
			}
			Arrays.sort(people);
			int temp =M;
			int temp2 =K;
			K =0;
			for(int i=0; i<N; i++) {
				if(people[i]<M && i==0) {
					System.out.println("#"+t +" " + "Impossible");
					continue outer;
				}
				if(people[i]>=M) {
					M+=temp;
					K+=temp2;
				}
				if(K==0) {
					System.out.println("#"+t +" " + "Impossible");
					continue outer;
				}else {
					K--;
				}
			}
			System.out.println("#"+t +" " + "Possible");
		}
		sc.close();
	}
}
