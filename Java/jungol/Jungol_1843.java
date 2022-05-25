package java. java.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
 * 냉장고 온도를 greed 접근  -> min 으로 정렬을 한다면 가운데 빈부분 까지 처리해야함( -온도 라인선  예시)
 * ---------------------
 *  --------- 
 *              ------- 
 * -> max로 정렬한다면 -> max 값이 넘는 min만 고려해주면 됨.
 *  ---------           
 *              -------
 *           ---------------------                        
 */
public class Jungol_1843 {
	static class Ref implements Comparable<Ref>{
		int min;
		int max;
		public Ref(int min, int max) {
			super();
			this.min = min;
			this.max = max;
		}
		@Override
		public int compareTo(Ref o) {
				return this.max - o.max;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Ref[] refs = new Ref[N];
		
		for(int i=0; i<N; i++) {
			String[] s = br.readLine().split(" ");
			refs[i] = new Ref(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
		}
		
		Arrays.sort(refs);
		int max = refs[0].max; 
		int count = 1;
		for(int i=1; i<N; i++) {
			if(max < refs[i].min ) {
				count++;
				max = refs[i].max;
			}
		}
		
		System.out.println(count);
		
	}
}
