package swea;


import java.util.Scanner;

class Solution_1204 {

	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int count= sc.nextInt();
		int max_num = -1;
		for(int k= 0; k< count; k++) {
			int current = sc.nextInt();
			int[] scores = new int [101];
			for(int i =0; i< 1000; i++) {
				int k1 = sc.nextInt();
				scores[k1]++;
			}
			int result=scores[0];
			for(int i =0; i<= scores.length-1; i++) {
				if(scores[i]>=result) {
					result = scores[i];
					max_num = i;
				}
			}
		System.out.println("#"+ current +" " + max_num);
		
		}
		sc.close();
	}
}
