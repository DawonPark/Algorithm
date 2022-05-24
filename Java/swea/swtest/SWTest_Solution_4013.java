package swea.swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWTest_Solution_4013 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t =1 ; t<=T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[][] magnets = new int[5][9];
			int[][] tempM = new int[5][9];
			for(int i=1; i<=4; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int j = 1; j<=8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
					tempM[i][j] = magnets[i][j];
				}
			}
			for(int i=0; i<K; i++) {
					StringTokenizer st =new StringTokenizer(br.readLine());
					int n = Integer.parseInt(st.nextToken());
					int r = Integer.parseInt(st.nextToken());
					int temp = r;
					for(int j = n; j>1; j--) {
						if(tempM[j][7] != tempM[j-1][3]) {
							if(temp == 1) { // 원래시계의 돌리는 방향이 1이면 다른쪽은 반시계
								rotate2(magnets,j-1);
								temp=-1;
							}else {
								rotate1(magnets, j-1);
								temp=1;
							}
						}else break;
					}
					temp = r;
					for(int j = n; j<4; j++) {
						if(tempM[j][3] != tempM[j+1][7]) {
							if(temp == 1) { // 원래시계의 돌리는 방향이 1이면 다른쪽은 반시계
								rotate2(magnets,j+1);
								temp=-1;
							}else {
								rotate1(magnets, j+1);
								temp=1;
							}
						}else break;
					}
					if(r==1) {
						rotate1(magnets,n);
					}else {
						rotate2(magnets,n);
					}
					
					for(int j=1; j<=4; j++) {
						for(int k=1; k<=8; k++ ) {
							tempM[j][k] = magnets[j][k];
						}
					}
				}
				int ans =0;
				for(int i=1; i<=4; i++) {
					if(magnets[i][1] == 1) ans|=1<<(i-1);
				}
				System.out.println("#"+ t+ " " +ans);
			}
	}
	private static void rotate2(int[][] magnets, int idx) { // 반시계
		int temp = magnets[idx][1];
		for(int i=1; i<8; i++) {
			magnets[idx][i]= magnets[idx][i+1];
		}
		magnets[idx][8] = temp;
	}
	static void rotate1(int[][] magnets, int idx) { // 시계
		int temp = magnets[idx][8];
		for(int i=8; i>1; i--) {
			magnets[idx][i]= magnets[idx][i-1];
		}
		magnets[idx][1] = temp;
	}
}
