package javaalgo.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import java.util.StringTokenizer;
/*
 * 카드를 퍼펙트 셔플 한다는 것은, 카드 덱을 정확히 절반으로 나누고 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만드는 것을 의미한다. 
 * 
 * -> 카드 셔플은 반으로 나눠서 처음 나는 것 부터 한 장씩 올리므로 두 부분으로 나누고 한 장씩 올려야함.
 * -> 배열을 두개로 사용해서 한번씩 뽑아서 출력을 해도 되지만 Queue를 사용하여 익숙해지기 위해서 Queue를 사용하는 방식을 선택함.
 *    스택으로 n/2 부터 받아서 뽑는 방법도 있을 것이라고 생각함 
 */
public class D3_Solution_3499 {

		public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			for(int t =1 ; t<=tc; t++) {
				int num = Integer.parseInt(br.readLine());
				st = new StringTokenizer(br.readLine()," ");
				Queue<String> first = new LinkedList<>(); 
				Queue<String> second = new LinkedList<>();
				for(int i=0; i<num; i++) {
					if(i < num/2+ num%2) {    // 홀수 일때는 first 가 한 장더 있어야하므로 
						first.offer(st.nextToken());
					}else {
						second.offer(st.nextToken());
					}
				}
			
				int index= first.size();
				System.out.print("#" + t+ " ");
				for(int i=0; i<index; i++) {
					System.out.print(first.poll()+" ");
					if(!second.isEmpty())	System.out.print(second.poll()+" ");
				}
				System.out.println();
		
				
				
			}
		}
}
