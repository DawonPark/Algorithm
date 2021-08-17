package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 시간 초과가 많아서 조건 하나라도 줄이기 위해서 많은 시간이 듬
 */
public class Main_1074 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		int N = Integer.parseInt(data[0]); 
		int r = Integer.parseInt(data[1]); 
		int c = Integer.parseInt(data[2]);
		
		 int index =0;
		 while(N>1) {
			 int mid = 1<<N-1;
			 if(r<mid && c<mid) { // 1사분면
				 index +=0;
			 } else if (r <mid && c>= mid) { // 2사분면
				 index +=mid*mid;
				 c -= mid; //  열이 mid에서 나와있기 때문에 줄여줌
			 } else if(r>=mid && c< mid) { // 3사분면 
				 index +=mid*mid*2;
				 r -= mid;// 행이 나와있기 때문에 줄여줌
			 } else {
				 index +=mid*mid*3;
				 c -= mid;
				 r -= mid;
			 }
			 N--;
			
		 }
		 int result = index+ 2*r+c;
		 
		 System.out.println(result);
		
	}
	

	
	
}
