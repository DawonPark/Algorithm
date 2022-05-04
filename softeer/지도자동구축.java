package softeer;

import java.util.*;
import java.io.*;
public class 지도자동구축 {
	    public static void main(String args[]) { 
	        int ans = 2; 
	        Scanner sc = new Scanner(System.in);
	        int n = Integer.parseInt(sc.next());
	        for(int i=0;i<n ;i++) { 
	              ans *= 2; 
	              ans--; 
	            }
	        System.out.println(ans*ans); }

}
