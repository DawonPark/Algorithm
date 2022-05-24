package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
/*
 * 1247 - 최적의 경로
 * 
 * 고객들의 집을 순열을 한 후에 회사에서 시작을 해서 좌표를 바꿔가며  계산을 해주면 됨. 마지막 좌표에서 집의 좌표를 계산
 */
public class D5_Solution_1247 {
		static int N, ans;
		static boolean isVisited[];
		static int[] result;
		static ArrayList<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			isVisited = new boolean[N];
			result = new int[N];
			list = new ArrayList<>();
			st = new StringTokenizer(br.readLine() , " ");
			for(int i=0; i<N+2; i++) {
				list.add(new int[] {Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken()) });
			}
			ans = Integer.MAX_VALUE;
			solve(0);
			System.out.println("#"+t+" " + ans);
		}
	}
	
	static void solve(int cnt) {
		if(cnt == N) {
			int temp =0;
			int currentX =list.get(0)[0]; int currentY =list.get(0)[1]; // 회사 출발
			for(int i=0; i<N; i++) {
				temp+= Math.abs(currentX - list.get(result[i])[0]) + Math.abs(currentY - list.get(result[i])[1]);
				currentX= list.get(result[i])[0]; 
				currentY= list.get(result[i])[1];
			}
			temp +=Math.abs(currentX - list.get(1)[0])+ Math.abs(currentY - list.get(1)[1]); // 집으로 돌아오는 길
			ans = Math.min(ans, temp); // 최단 경로 
			return;
		}
		
		for(int i=2; i<N+2; i++) {
			if(isVisited[i-2] == true) continue;
			
			result[cnt] = i;
			isVisited[i-2]= true;
			solve(cnt+1);
			isVisited[i-2]= false;
			
		}
		
		
	}
	
}
