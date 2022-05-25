package java.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GBC {
	  public static int N, M;
	    public static void main(String[] args) throws IOException {
	       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(bf.readLine());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        int[][] arr = new int[N][2];
	        int answer = 0;
	 
	        for(int i = 0; i < N; i++) {
	            st = new StringTokenizer(bf.readLine());
	            arr[i][0] = Integer.parseInt(st.nextToken());
	            arr[i][1] = Integer.parseInt(st.nextToken());
	        }
	 
	        int[][] speed = new int[M][2];
	        for(int i = 0; i < M; i++) {
	            st = new StringTokenizer(bf.readLine());
	            speed[i][0] = Integer.parseInt(st.nextToken());
	            speed[i][1] = Integer.parseInt(st.nextToken());
	        }
	 
	        int idx = 0;
	       for(int i = 0; i < N; i++) {
	            for(int j = idx; j < M; j++) {
	                if(arr[i][0] < speed[j][0]) {
	                    speed[j][0] -= arr[i][0];
	                    if(speed[j][1] - arr[i][1] > 0) answer = Math.max(answer, speed[j][1] - arr[i][1]);
	                    break;
	                } else if(arr[i][0] > speed[j][0]) {
	                    arr[i][0] -= speed[j][0];
	                    if(speed[j][1] - arr[i][1] > 0) answer = Math.max(answer, speed[j][1] - arr[i][1]);
	                    idx++;
	                } else {
	                    if(speed[j][1] - arr[i][1] > 0) answer = Math.max(answer, speed[j][1] - arr[i][1]);
	                    idx++;
	                    break;
	                }
	            }
	        }
	 
	        System.out.println(answer);
	    }
}
