package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1786 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] text = br.readLine().toCharArray();
		char[] pattern = br.readLine().toCharArray();
		
		int[] pi = new int[pattern.length];
		int cnt =0;
		for(int i=1 , j=0; i<pattern.length; i++) {
			while(j>0 && pattern[i]!= pattern[j]) j = pi[j-1];
			if(pattern[i] == pattern[j]) pi[i]= ++j;
		}
		List<Integer> list = new ArrayList<>(); 
		for(int i=0,j=0; i<text.length; i++) {
			while(j>0 && text[i]!= pattern[j]) j = pi[j-1];
			if(text[i] == pattern[j]) {
				if(j==pattern.length-1) {
					cnt++;
					list.add(i-pattern.length+2);
					j= pi[j];
				}
				else {
					j++;
				}
			}
		}
		
		System.out.println(cnt);
		for(int ans : list) {
			System.out.print(ans + " ");
		}
	}
}
