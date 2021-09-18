package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_Solution_1234 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int t = 1; t<=10; t++) {
			 	String temp = br.readLine();
	            st = new StringTokenizer(temp);
	            int N = Integer.parseInt(st.nextToken());
	            String keys = st.nextToken();
	            StringBuilder sb = new StringBuilder(keys);
	            int i = 0;
	            while(true) {
	                if(sb.length()<i)
	                    break;
	                if(0<=i&&i<(sb.length()-1) && (sb.charAt(i) == sb.charAt(i+1))) {
	                    sb.replace(i, i+2, "");
	                    i--;
	                }
	                else {
	                    i++;
	                }
	                
	            }
	            
	            System.out.println("#" + t + " "+sb.toString());
		}
	}
}
