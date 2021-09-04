package swea;

import java.util.Arrays;
import java.util.Scanner;
public class D4_Solution_12052 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		System.out.println(Arrays.toString(new int[]{1,2}));
		int T = Integer.parseInt(sc.nextLine());
 outer: for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			char[][] tiles = new char[N][M];
			for(int i=0; i<N; i++) {
				String s = sc.nextLine();
				for(int j=0; j<M; j++) {
					tiles[i][j] = s.charAt(j);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(tiles[i][j]=='#') {
						if(i+1>=N || j+1>=M) {
							System.out.println("#"+t+ " " +"NO");
							continue outer;
						}
						if(tiles[i][j+1]!='#') {
							System.out.println("#"+t+ " " +"NO");
							continue outer;
						}
						if(tiles[i+1][j]!='#') {
							System.out.println("#"+t+ " " +"NO");
							continue outer;
						}
						if(tiles[i+1][j+1]!='#') {
							System.out.println("#"+t+ " " +"NO");
							continue outer;
						}
						tiles[i][j]='.';
						tiles[i][j+1]='.';
						tiles[i+1][j]='.';
						tiles[i+1][j+1]='.';
						}
						
					}
				}
			System.out.println("#"+t+ " "+ "YES");
			}
			
			
		
	}
}
