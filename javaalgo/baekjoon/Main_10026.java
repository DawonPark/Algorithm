package javaalgo.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 諛깆� 10026 - �쟻濡앹깋�빟
 * 
 * -> 洹몃┝�쓽 媛숈� �깋 援ъ뿭�쓣 援ы븯�뒗�뜲 dfs濡� �깘�깋�빐�꽌 援щ텇�쓣 �븿
 * -> �쟻�깋怨� �끃�깋�씠 媛숈씠蹂댁씠�뒗 �쟻濡앹깋�빟�� �뼱李⑦뵾 �븳 �깋源붾줈 蹂댁씠湲� �븣臾몄뿉 G濡� 蹂댁씠�뒗 寃껋쓣 R濡� �떎 諛붽씀怨� �룎由�.
 */
public class Main_10026 {
	
	static char[][] pic;
	static int ans, N;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pic = new char[N][N];
		char[][] copy = new char[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				pic[i][j] = s.charAt(j);
				if(pic[i][j]=='G') {
					copy[i][j] = 'R';
				}else copy[i][j] = pic[i][j];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(pic[i][j]!='0') {
					dfs(i,j);
					ans++;
				}
			}
		}
		
		System.out.print(ans+ " ");
		ans =0;
		pic =copy;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(pic[i][j]!='0') {
					dfs(i,j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	
	static void dfs(int x, int y) {
		char ch = pic[x][y];
		pic[x][y] = '0';
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
			if(pic[nx][ny] ==ch) {
				dfs(nx,ny);
			}
		}
	}
	

	
	
}
