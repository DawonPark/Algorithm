package programmers;

public class 피로도 {
	int K, R, ans;
	boolean[] isVisited;
	int[] res;

	public int solution(int k, int[][] dungeons) {
		R = dungeons.length;
		K = k;
		isVisited = new boolean[R];
		res = new int[R];
		permutation(0, dungeons);
		return ans;
	}

	public void permutation(int cnt, int[][] dungeons) {
		if (cnt == R) {
			go(dungeons, res);
			return;
		}
		for (int i = 0; i < R; i++) {
			if (isVisited[i])
				continue;
			isVisited[i] = true;
			res[cnt] = i;
			permutation(cnt + 1, dungeons);
			isVisited[i] = false;
		}
	}

	public void go(int[][] map, int[] sel) {
		int k = K;
		int sum = 0;
		for (int i = 0; i < R; i++) {
			if (k >= map[sel[i]][0]) {
				k -= map[sel[i]][1];
				sum++;
			}
		}
		ans = Math.max(ans, sum);
	}
}
