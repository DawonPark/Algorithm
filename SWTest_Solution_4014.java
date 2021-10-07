import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWTest_Solution_4014 {
	static int N, X, ans;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			ans = 0;
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				// 행 체크
				RowCheck(i);
				// 열 체크
				ColCheck(i);
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	// 열 체크
	private static void ColCheck(int i) {
		int h = map[0][i]; 
		int hCnt = 1;
		int successCnt = 1;
		for (int j = 1; j < N; j++) {
			if (h == map[j][i]) {
				hCnt++;
				successCnt++;
				continue;
			}
			if (Math.abs(h - map[j][i]) > 1) break;
			if (h - map[j][i] == -1) {
				if (hCnt >= X) {
					h = map[j][i];
					hCnt = 1;
					successCnt++;
					continue;
				} else break;
			}
			if (h - map[j][i] == 1) {
				h = map[j][i];
				hCnt = 1;
				successCnt++;
				for (int k = 0; k < X - 1; k++) {
					if (++j < N && h == map[j][i]) {
						hCnt++;
						successCnt++;
					} else {
						successCnt--;
						break;
					}
				}
				hCnt = 0;
			}
		}
		if (successCnt == N) {
			ans++;
		}
	}
	// 행 체크
	private static void RowCheck(int i) {
		int h = map[i][0]; 
		int hCnt = 1;
		int successCnt = 1;
		for (int j = 1; j < N; j++) {
			if (h == map[i][j]) {
				hCnt++;
				successCnt++;
				continue;
			}
			if (Math.abs(h - map[i][j]) > 1) break;
			if (h - map[i][j] == -1) {
				if (hCnt >= X) {
					h = map[i][j];
					hCnt = 1;
					successCnt++;
					continue;
				} else break;
			}
			if (h - map[i][j] == 1) {
				h = map[i][j];
				hCnt = 1;
				successCnt++;
				for (int k = 0; k < X - 1; k++) {
					if (++j < N && h == map[i][j]) {
						hCnt++;
						successCnt++;
					} else {
						successCnt--;
						break;
					}
				}
				hCnt = 0;
			}
		}
		if (successCnt == N) {
			ans++;
		}
	}
}
