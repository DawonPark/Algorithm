package java. swea.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class SWTest_Solution_1767 {
	static ArrayList<int[]> list;
	static int N,ans;
	static int[][] map;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i ==0 || i== N-1 || j==N-1 ||j ==0) continue;
					if(map[i][j]==1) list.add(new int[] {i,j});
				}
			}
			ans = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			solve(0,0,0);
			System.out.println("#"+t+ " " + ans);
		}
	}
	private static void solve(int cnt, int coreCnt, int len) {
		if(cnt == list.size()) {
			if(max<coreCnt) {
				ans = len;
				max = coreCnt;
			}else if (max==coreCnt){
				ans = Math.min(len, ans);
			}
			return;
		}
		
		for(int d = 0; d<4; d++) {
			int nx = list.get(cnt)[0]; 
			int ny = list.get(cnt)[1];
			boolean check = false;
			int temp =0;
			while(true) {
				nx +=dx[d];
				ny +=dy[d];
				if(nx<0 || nx>=N || ny<0 || ny>=N) {
					check= true;
					break;
				}
				if(map[nx][ny]!=0) {
					break;
				}
				temp++;
			}
			if(check) {
				int count=0;
				int x = list.get(cnt)[0]; 
				int y = list.get(cnt)[1];
				for(int i = 0; i<temp; i++) {
					x+=dx[d];
					y+=dy[d];
					map[x][y] = 2;
					count++;
				}
				
				solve(cnt+1, coreCnt+1,len+count);
				 x = list.get(cnt)[0]; 
				 y = list.get(cnt)[1];
				for(int i = 0; i<temp; i++) {
					x+=dx[d];
					y+=dy[d];
					map[x][y] =0;
				}
			}
			else solve(cnt+1,coreCnt, len);
		}
	}
}
